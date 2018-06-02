package xyz.zzp.simplehabit.data.model;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import xyz.zzp.simplehabit.data.vo.CategoryVO;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.data.vo.HomeScreenVO;
import xyz.zzp.simplehabit.data.vo.ProgramVO;
import xyz.zzp.simplehabit.data.vo.SessionVO;
import xyz.zzp.simplehabit.events.DataReadyEvent;
import xyz.zzp.simplehabit.events.LoadedCategoryProgramEvent;
import xyz.zzp.simplehabit.events.LoadedCurrentProgramEvent;
import xyz.zzp.simplehabit.events.LoadedTopicEvent;
import xyz.zzp.simplehabit.network.RetrofitDataAgent;

public class SeriesModel {

    private static SeriesModel sObjectInstance;

    private List<HomeScreenVO> seriesData;

    private SeriesModel() {

        seriesData = new ArrayList<>();
        EventBus.getDefault().register(this);
    }

    public static SeriesModel getsObjectInstance() {
        if(sObjectInstance == null)
            sObjectInstance = new SeriesModel();
        return sObjectInstance;
    }

    public List<HomeScreenVO> getSeriesData() {
        return seriesData;
    }

    public ProgramVO getProgramByProgramId(String programId){
        ProgramVO programVO = null;
        for(int i=0; i<seriesData.size(); i++){
            if(seriesData.get(i) instanceof CategoryVO){
                for(int j = 0; j<((CategoryVO) seriesData.get(i)).getPrograms().size(); j++){
                    String id = ((CategoryVO) seriesData.get(i)).getPrograms().get(j).getProgramId();
                    if(id.equals(programId))
                        programVO = ((CategoryVO) seriesData.get(i)).getPrograms().get(j);
                }
            }
        }
        return programVO;
    }

    public CurrentProgramVO getProgramsByProgramId(String programId){
        CurrentProgramVO currentProgramVO = null;
        for(int i=0; i<seriesData.size(); i++){
            if(seriesData.get(i) instanceof CurrentProgramVO){
                if(((CurrentProgramVO) seriesData.get(i)).getProgramId().equals(programId))
                    currentProgramVO = (CurrentProgramVO)seriesData.get(i);
            }
        }
        return currentProgramVO;
    }

//    public List<SessionVO> getSessionByProgramId(String programId){
//        List<SessionVO> sessionList = new ArrayList<>();
//        for(int i=0; i<seriesData.size();i++){
//            if(seriesData.get(i) instanceof CurrentProgramVO){
//                String id = ((CurrentProgramVO) seriesData.get(i)).getProgramId();
//                if(id.equals(programId))
//                    sessionList = ((CurrentProgramVO) seriesData.get(i)).getSessions();
//            }
//            else if(seriesData.get(i) instanceof CategoryVO){
//                for(int j = 0; j<((CategoryVO) seriesData.get(i)).getPrograms().size(); j++){
//                    String id = ((CategoryVO) seriesData.get(i)).getPrograms().get(j).getProgramId();
//                    if(id.equals(programId))
//                        sessionList = ((CategoryVO) seriesData.get(i)).getPrograms().get(j).getSessions();
//                }
//            }
//        }
//        return sessionList;
//    }

    public void loadData(){
        RetrofitDataAgent.getsObjectInstance().loadCurrentProgram();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loadCurrentProgram(LoadedCurrentProgramEvent event){
        seriesData.add(event.getCurrentProgram());
        RetrofitDataAgent.getsObjectInstance().loadCategories();
    }
    @Subscribe
    public void loadCategoriesProgram(LoadedCategoryProgramEvent event){
        seriesData.addAll(event.getCategoryProgramList());
        RetrofitDataAgent.getsObjectInstance().loadTopic();
    }
    @Subscribe
    public void loadTopic(LoadedTopicEvent event){
        seriesData.addAll(event.getmTopicList());
        DataReadyEvent dataReadyEvent= new DataReadyEvent(seriesData);
        EventBus.getDefault().post(dataReadyEvent);
    }
}
