package xyz.zzp.simplehabit.fragments;

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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.activities.ProgramDetailActivity;
import xyz.zzp.simplehabit.adapters.SeriesAdapter;
import xyz.zzp.simplehabit.data.vo.HomeScreenVO;
import xyz.zzp.simplehabit.delegates.TapCategoryProgramDelegate;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;
import xyz.zzp.simplehabit.mvp.presenters.HomeScreenPresenter;
import xyz.zzp.simplehabit.mvp.views.HomeScreenView;

public class SeriesFragment extends Fragment implements HomeScreenView{

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private SeriesAdapter mSeriesAdapter;

    private HomeScreenPresenter mPresenter;

    private TapCurrentProgramDelegate mCurrentProgramDelegate;

    private TapCategoryProgramDelegate mCategoryProgramDelegate;

    public SeriesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series,container,false);
        ButterKnife.bind(this,view);

        mPresenter = new HomeScreenPresenter(this);
        mPresenter.onCreate();

        mCurrentProgramDelegate = mPresenter;
        mCategoryProgramDelegate = mPresenter;


        mSeriesAdapter = new SeriesAdapter(getContext(),mCurrentProgramDelegate,mCategoryProgramDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(mSeriesAdapter);

        return view;

    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        homeScreenView = (HomeScreenView) context;
//    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void displayHomeScreen(List<HomeScreenVO> list) {
        mSeriesAdapter.setNewData(list);
    }

    @Override
    public void lunchDetail() {
        Intent intent = ProgramDetailActivity.newIntentCurrentProgram(getContext());
        startActivity(intent);
    }

    @Override
    public void lunchDetail(String categoryId, String categoryProgramId) {
        Intent intent = ProgramDetailActivity.newIntentCategoryProgram(getContext(),categoryId,categoryProgramId);
        startActivity(intent);
    }

    @Override
    public void dispalyErrorMessage(String errorMsg) {
        Snackbar.make(rvList, errorMsg, Snackbar.LENGTH_INDEFINITE).show();
    }

}
