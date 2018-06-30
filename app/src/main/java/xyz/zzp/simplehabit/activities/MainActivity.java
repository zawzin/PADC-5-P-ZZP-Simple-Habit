package xyz.zzp.simplehabit.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.SimpleHabit;
import xyz.zzp.simplehabit.adapters.ItemAdapter;
import xyz.zzp.simplehabit.data.model.SeriesModel;
import xyz.zzp.simplehabit.data.vo.HomeScreenVO;
import xyz.zzp.simplehabit.delegates.HomePresenterDelegate;
import xyz.zzp.simplehabit.fragments.OnTheGoFragment;
import xyz.zzp.simplehabit.fragments.SeriesFragment;
import xyz.zzp.simplehabit.fragments.TeacherFragment;
import xyz.zzp.simplehabit.mvp.presenters.HomeScreenPresenter;
import xyz.zzp.simplehabit.mvp.views.SeriesScreenView;

public class MainActivity extends AppCompatActivity
        implements HomePresenterDelegate, SeriesScreenView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.bnv)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.tl_tab)
    TabLayout tlTab;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.rl_main_activity)
    RelativeLayout rlMainActivity;

    ItemAdapter itemAdapter;

    private HomeScreenPresenter mPresenter;

    private SeriesFragment mSeriesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Meditate");
        }
        SeriesModel.initSeriesModel(getApplicationContext());

        mPresenter = ViewModelProviders.of(this).get(HomeScreenPresenter.class);
        mPresenter.initPresenter(this);

        itemAdapter = new ItemAdapter(getSupportFragmentManager());
        tlTab.setupWithViewPager(viewPager);
        itemAdapter.addTab("On The Go", new OnTheGoFragment());
        itemAdapter.addTab("Series", new SeriesFragment());
        itemAdapter.addTab("Teachers", new TeacherFragment());
        viewPager.setAdapter(itemAdapter);

        mSeriesFragment = (SeriesFragment) itemAdapter.getItem(1);

        mPresenter.getmSeriesScreenLD().observe(this, new Observer<List<HomeScreenVO>>() {
            @Override
            public void onChanged(@Nullable List<HomeScreenVO> list) {
                displayHomeScreen(list);
                Log.i(SimpleHabit.LOG_TAG, "List Data Size :" + list.size() + "");
            }
        });

        mPresenter.getmErrorLD().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                displayErrorMessage(s);
            }
        });
    }

    public void displayHomeScreen(List<HomeScreenVO> list) {
        mSeriesFragment.displayHomeScreen(list);
    }

    @Override
    public void lunchCurrentProgramDetail() {
        Intent intent = ProgramDetailActivity.newIntentCurrentProgram(getApplicationContext());
        startActivity(intent);
    }


    @Override
    public void lunchCategoryProgramDetail(String categoryId, String categoryProgramId) {
        Intent intent = ProgramDetailActivity.newIntentCategoryProgram(getApplicationContext(), categoryId, categoryProgramId);
        startActivity(intent);
    }

    public void displayErrorMessage(String errorMsg) {
        mSeriesFragment.displayErrorMessage(errorMsg);
        Snackbar.make(viewPager, errorMsg, Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public HomeScreenPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void displayErrorBV(String errorMsg) {
        mSeriesFragment.displayErrorMessage(errorMsg);
    }
}
