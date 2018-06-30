package xyz.zzp.simplehabit.mvp.presenters;

import android.arch.lifecycle.MutableLiveData;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import xyz.zzp.simplehabit.data.model.SeriesModel;
import xyz.zzp.simplehabit.data.vo.HomeScreenVO;
import xyz.zzp.simplehabit.delegates.TapCategoryProgramDelegate;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;
import xyz.zzp.simplehabit.events.DataReadyEvent;
import xyz.zzp.simplehabit.events.NetworkErrorEvent;
import xyz.zzp.simplehabit.mvp.views.SeriesScreenView;

public class HomeScreenPresenter extends BasePresenter<SeriesScreenView>
        implements TapCurrentProgramDelegate, TapCategoryProgramDelegate{

    private MutableLiveData<List<HomeScreenVO>> mSeriesScreenLD;

    @Override
    public void initPresenter(SeriesScreenView mView) {
        super.initPresenter(mView);
        mSeriesScreenLD = new MutableLiveData<>();
        SeriesModel.getsObjectInstance().loadData(mSeriesScreenLD,mErrorLD);

    }

    public MutableLiveData<List<HomeScreenVO>> getmSeriesScreenLD() {
        return mSeriesScreenLD;
    }

    @Override
    public void onTapCategoryProgramDelegate(String categoryId, String categoryProgramId) {
        mView.lunchCategoryProgramDetail(categoryId,categoryProgramId);
    }

    @Override
    public void onTapCurrentProgram() {
        mView.lunchCurrentProgramDetail();
    }
}
