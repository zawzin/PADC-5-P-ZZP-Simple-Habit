package xyz.zzp.simplehabit.activities;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.SimpleHabit;
import xyz.zzp.simplehabit.adapters.ItemAdapter;
import xyz.zzp.simplehabit.data.vo.HomeScreenVO;
import xyz.zzp.simplehabit.delegates.TapCategoryProgramDelegate;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;
import xyz.zzp.simplehabit.fragments.OnTheGoFragment;
import xyz.zzp.simplehabit.fragments.SeriesFragment;
import xyz.zzp.simplehabit.fragments.TeacherFragment;
import xyz.zzp.simplehabit.mvp.views.HomeScreenView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.bnv)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.tl_tab)
    TabLayout tlTab;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private List<HomeScreenVO> list;

    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Meditate");
        }

        itemAdapter = new ItemAdapter(getSupportFragmentManager());
        tlTab.setupWithViewPager(viewPager);
        itemAdapter.addTab("On The Go",new OnTheGoFragment());
        itemAdapter.addTab("Series",new SeriesFragment());
        itemAdapter.addTab("Teachers",new TeacherFragment());
        viewPager.setAdapter(itemAdapter);
    }

}
