package xyz.zzp.simplehabit.mvp.presenters;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.zzp.simplehabit.data.model.SeriesModel;
import xyz.zzp.simplehabit.delegates.TapCategoryProgramDelegate;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;
import xyz.zzp.simplehabit.events.DataReadyEvent;
import xyz.zzp.simplehabit.events.NetworkErrorEvent;
import xyz.zzp.simplehabit.mvp.views.HomeScreenView;

public class HomeScreenPresenter extends BasePresenter<HomeScreenView> implements TapCurrentProgramDelegate
    ,TapCategoryProgramDelegate{
    public HomeScreenPresenter(HomeScreenView mView) {
        super(mView);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SeriesModel.getsObjectInstance().loadData();
    }

    @Override
    public void onStart() {
        super.onStart();
        if(!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoaded(DataReadyEvent event){
        if (event != null){
            mView.displayHomeScreen(event.getSeriesData());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataLoadedError(NetworkErrorEvent event){
        mView.dispalyErrorMessage(event.getErrorMsg());
    }

    @Override
    public void onTapCategoryProgramDelegate(String categoryId, String categoryProgramId) {
        mView.lunchDetail(categoryId,categoryProgramId);
    }

    @Override
    public void onTapCurrentProgram() {
        mView.lunchDetail();
    }
}
