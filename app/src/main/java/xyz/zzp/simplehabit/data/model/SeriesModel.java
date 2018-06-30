package xyz.zzp.simplehabit.data.model;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import xyz.zzp.simplehabit.SimpleHabit;
import xyz.zzp.simplehabit.data.vo.CategoryVO;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.data.vo.HomeScreenVO;
import xyz.zzp.simplehabit.data.vo.ProgramVO;
import xyz.zzp.simplehabit.data.vo.SessionVO;
import xyz.zzp.simplehabit.data.vo.TopicsVO;
import xyz.zzp.simplehabit.network.responses.GetCategoryProgramResponse;
import xyz.zzp.simplehabit.network.responses.GetCurrentProgramResponse;
import xyz.zzp.simplehabit.network.responses.GetTopicResponse;

public class SeriesModel extends BaseModel{

    private static SeriesModel sObjectInstance;

    private List<HomeScreenVO> seriesData;

    private MutableLiveData<List<HomeScreenVO>> mHomeScreenModelLD;

    private MutableLiveData<String> mErrorModelLD;

    private SeriesModel(Context context) {
        super(context);
        seriesData = new ArrayList<>();
    }

    public static void initSeriesModel(Context context){
        sObjectInstance = new SeriesModel(context);
    }

    public static SeriesModel getsObjectInstance() {
        return sObjectInstance;
    }

    public List<HomeScreenVO> getSeriesData() {
        return seriesData;
    }

    public CurrentProgramVO getCurrentProgram(){
        for(HomeScreenVO obj:seriesData){
            if(obj instanceof CurrentProgramVO)
                return (CurrentProgramVO)obj;
        }
        return null;
    }

    public ProgramVO getProgram(String categoryId,String categoryProgramId){
        for(int i=0; i<seriesData.size(); i++){
            if(seriesData.get(i) instanceof CategoryVO){
                if(((CategoryVO) seriesData.get(i)).getCategoryId().equals(categoryId)){
                    for(int j = 0; j < ((CategoryVO) seriesData.get(i)).getPrograms().size(); j++){
                        if(((CategoryVO) seriesData.get(i)).getPrograms().get(j).getProgramId().equals(categoryProgramId)){
                            return ((CategoryVO) seriesData.get(i)).getPrograms().get(j);
                        }
                    }
                }
            }
        }
        return null;
    }
    public void loadData(MutableLiveData<List<HomeScreenVO>> mSeriesScreenLD,
                         MutableLiveData<String> mErrorLD){

        mHomeScreenModelLD = mSeriesScreenLD;
        mErrorModelLD = mErrorLD;
        loadCurrentProgram();


    }

    public List<HomeScreenVO> getDataFromPersist(){

        List<HomeScreenVO> dataFromPersist = new ArrayList<>();
        dataFromPersist.add(mTheDB.currentProgramDao().getCurrentProgram());
        dataFromPersist.addAll(mTheDB.categoryDao().getCategoryList());
        for (HomeScreenVO homeScreen:dataFromPersist){
            if (homeScreen instanceof CategoryVO){
                ((CategoryVO) homeScreen).setPrograms(mTheDB.programDao().getProgramsByCategoryId(((CategoryVO) homeScreen).getCategoryId()));
            }
        }
        dataFromPersist.addAll(mTheDB.topicDao().getTopicList());
        return dataFromPersist;
    }

    public void  loadCurrentProgram(){
        mSeriesApi.loadCurrentProgram("b002c7e1a528b7cb460933fc2875e916", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetCurrentProgramResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetCurrentProgramResponse getCurrentProgramResponse) {
                        if (getCurrentProgramResponse != null && getCurrentProgramResponse.getCurrentProgram() != null){
                            seriesData.add(getCurrentProgramResponse.getCurrentProgram());
                            loadCategoryProgram();
                        }
                        else mErrorModelLD.setValue("Network Error");
                    }

                    @Override
                    public void onError(Throwable e) {
                        mErrorModelLD.setValue(e.getMessage());
                        Log.i(SimpleHabit.LOG_TAG,"Data From Room :"+getDataFromPersist().size());
                        mHomeScreenModelLD.postValue(getDataFromPersist());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void loadCategoryProgram(){
        mSeriesApi.loadCategoryProgram("b002c7e1a528b7cb460933fc2875e916", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetCategoryProgramResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetCategoryProgramResponse getCategoryProgramResponse) {
                        seriesData.addAll(getCategoryProgramResponse.getCategoryProgramList());
                        loadTopic();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mErrorModelLD.setValue(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void loadTopic(){
        mSeriesApi.loadTopic("b002c7e1a528b7cb460933fc2875e916", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetTopicResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetTopicResponse getTopicResponse) {
                        seriesData.addAll(getTopicResponse.getTopics());
//                        mHomeScreenModelLD.setValue(seriesData);
                        if (seriesData.size() > 0){
                            persistSeriesScreenList(seriesData);
                        }
                        mHomeScreenModelLD.setValue(getDataFromPersist());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mErrorModelLD.setValue(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    private void persistSeriesScreenList(List<HomeScreenVO> seriesList) {

        if (seriesList.size() > 0) {

            mTheDB.clearAllTables();

            CurrentProgramVO currentProgram = null;
            List<CategoryVO> categoryList = new ArrayList<>();
            List<ProgramVO> programList = new ArrayList<>();
            List<SessionVO> sessionList = new ArrayList<>();
            List<TopicsVO> topicList = new ArrayList<>();

            for (HomeScreenVO homeScreenVO : seriesList) {
                if (homeScreenVO instanceof CurrentProgramVO) {
                    currentProgram = (CurrentProgramVO) homeScreenVO;
                    currentProgram.setAverageLengthTime(((CurrentProgramVO) homeScreenVO).getAverageLength()[0]);
                }

                if (homeScreenVO instanceof CategoryVO) {
                    categoryList.add((CategoryVO) homeScreenVO);
                    for (ProgramVO program : ((CategoryVO) homeScreenVO).getPrograms()) {
                        program.setCategoryId(((CategoryVO) homeScreenVO).getCategoryId());
                        programList.add(program);
                        sessionList.addAll(program.getSessions());
                    }
                }

                if (homeScreenVO instanceof TopicsVO) {
                    topicList.add((TopicsVO) homeScreenVO);
                }

            }

            long insertedCurrentProgram = mTheDB.currentProgramDao().insertCurrentProgram(currentProgram);
            Log.i(SimpleHabit.LOG_TAG, " insertedCurrentProgram :" + insertedCurrentProgram);

            long[] insertedCategory = mTheDB.categoryDao().insertCategories(categoryList.toArray(new CategoryVO[0]));
            Log.i(SimpleHabit.LOG_TAG, " insertedCategory :" + insertedCategory);

            long[] insertedProgram = mTheDB.programDao().insertPrograms(programList.toArray(new ProgramVO[0]));
            Log.i(SimpleHabit.LOG_TAG, "insertedProgram :" + insertedProgram);

            long[] insertedSession = mTheDB.sessionDao().insertSessions(sessionList.toArray(new SessionVO[0]));
            Log.i(SimpleHabit.LOG_TAG, "insertedSession :" + insertedSession);

            long[] insetedTopic = mTheDB.topicDao().insertTopics(topicList.toArray(new TopicsVO[0]));
            Log.i(SimpleHabit.LOG_TAG, "insertedTopic :" + insetedTopic);

            Log.i(SimpleHabit.LOG_TAG, "topic from room :" + mTheDB.topicDao().getTopicList().size());
            Log.i(SimpleHabit.LOG_TAG, "current program :" + mTheDB.currentProgramDao().getCurrentProgram().getTitle());
            Log.i(SimpleHabit.LOG_TAG, "category :" + mTheDB.categoryDao().getCategoryList().get(0).getTitle());
        }
    }
}
