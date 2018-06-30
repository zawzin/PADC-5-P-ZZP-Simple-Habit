package xyz.zzp.simplehabit.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.adapters.SeriesAdapter;
import xyz.zzp.simplehabit.data.model.SeriesModel;
import xyz.zzp.simplehabit.data.vo.HomeScreenVO;
import xyz.zzp.simplehabit.delegates.HomePresenterDelegate;
import xyz.zzp.simplehabit.mvp.presenters.HomeScreenPresenter;

public class SeriesFragment extends Fragment {

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    @BindView(R.id.cl_series_fragment)
    CoordinatorLayout clSeries;

    private SeriesAdapter mSeriesAdapter;

    private HomeScreenPresenter mPresenter;

    private HomePresenterDelegate mDelegate;

    public SeriesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series,container,false);
        ButterKnife.bind(this,view);

        mPresenter = mDelegate.getPresenter();

        mSeriesAdapter = new SeriesAdapter(getContext(),mPresenter,mPresenter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(mSeriesAdapter);

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mDelegate = (HomePresenterDelegate)context;
    }

    public void displayHomeScreen(List<HomeScreenVO> list) {
        mSeriesAdapter.setNewData(list);
    }

    public void displayErrorMessage(String errorMsg) {
    }

}
