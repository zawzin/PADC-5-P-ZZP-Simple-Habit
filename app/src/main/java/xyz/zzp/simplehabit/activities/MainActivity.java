package xyz.zzp.simplehabit.activities;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.adapters.ItemAdapter;
import xyz.zzp.simplehabit.delegates.TapCurrentProgram;
import xyz.zzp.simplehabit.fragments.OnTheGoFragment;
import xyz.zzp.simplehabit.fragments.SeriesFragment;
import xyz.zzp.simplehabit.fragments.TeacherFragment;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.bnv)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.tl_tab)
    TabLayout tlTab;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

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
