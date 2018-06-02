package xyz.zzp.simplehabit.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.SimpleHabit;
import xyz.zzp.simplehabit.activities.ProgramDetailActivity;
import xyz.zzp.simplehabit.adapters.SeriesAdapter;
import xyz.zzp.simplehabit.data.model.SeriesModel;
import xyz.zzp.simplehabit.delegates.TapCategoryProgramDelegate;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;
import xyz.zzp.simplehabit.events.DataReadyEvent;
import xyz.zzp.simplehabit.events.NetworkErrorEvent;

public class SeriesFragment extends Fragment {

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private SeriesAdapter mSeriesAdapter;

    private TapCurrentProgramDelegate mCurrentProgramDelegate;

    private TapCategoryProgramDelegate mCategoryProgramDelegate;
//
    public SeriesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series,container,false);
        ButterKnife.bind(this,view);

        SeriesModel.getsObjectInstance().loadData();


        mSeriesAdapter = new SeriesAdapter(getContext(),mCurrentProgramDelegate,mCategoryProgramDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(mSeriesAdapter);

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCurrentProgramDelegate = (TapCurrentProgramDelegate) context;
        mCategoryProgramDelegate = (TapCategoryProgramDelegate) context;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loadedData(DataReadyEvent event){
        mSeriesAdapter.setNewData(event.getSeriesData());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void networkError(NetworkErrorEvent event){
        Snackbar.make(rvList.getRootView(),"Netword Error!",Snackbar.LENGTH_INDEFINITE).show();
    }
}
