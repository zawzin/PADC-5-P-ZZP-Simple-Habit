package xyz.zzp.simplehabit.data.model;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import xyz.zzp.simplehabit.data.vo.HomeScreenVO;
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
