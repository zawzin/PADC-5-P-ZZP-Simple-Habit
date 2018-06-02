package xyz.zzp.simplehabit.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import xyz.zzp.simplehabit.activities.CurrentProgramActivity;
import xyz.zzp.simplehabit.adapters.SeriesAdapter;
import xyz.zzp.simplehabit.data.model.SeriesModel;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.delegates.TapCurrentProgram;
import xyz.zzp.simplehabit.events.DataReadyEvent;
import xyz.zzp.simplehabit.events.NetworkErrorEvent;

public class SeriesFragment extends Fragment implements TapCurrentProgram{

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private SeriesAdapter mSeriesAdapter;
//
    public SeriesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series,container,false);
        ButterKnife.bind(this,view);

        SeriesModel.getsObjectInstance().loadData();


        mSeriesAdapter = new SeriesAdapter(getContext(),this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(mSeriesAdapter);

        return view;

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

    @Override
    public void onTapCurrentProgram(CurrentProgramVO currentProgram) {

        int viewType = 0;
        int dataSizeInAdapter = mSeriesAdapter.getItemCount();
        for(int i=0 ; i<dataSizeInAdapter; i++){
            if(SeriesModel.getsObjectInstance().getSeriesData().get(i) instanceof CurrentProgramVO)
                viewType=i;
        }
        Intent intent = CurrentProgramActivity.newIntent(getContext());
        intent.putExtra(SimpleHabit.CURRENT_PROGRAM,viewType);
        startActivity(intent);
    }
}
