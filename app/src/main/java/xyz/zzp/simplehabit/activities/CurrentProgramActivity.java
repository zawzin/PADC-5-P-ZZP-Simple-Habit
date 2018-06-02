package xyz.zzp.simplehabit.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.SimpleHabit;
import xyz.zzp.simplehabit.adapters.CurrentSessionAdapter;
import xyz.zzp.simplehabit.data.model.SeriesModel;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.data.vo.HomeScreenVO;

public class CurrentProgramActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rv_sessions)
    RecyclerView rvSessions;

    @BindView(R.id.tv_desc)
    TextView tvDesc;

    @BindView(R.id.btn_read_more)
    TextView btnReadMore;

    private CurrentSessionAdapter mCurrentSessionAdapter;

    private CurrentProgramVO mCurrentProgramVO;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,CurrentProgramActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_program);

        ButterKnife.bind(this,this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));

        mCurrentSessionAdapter = new CurrentSessionAdapter(this);
        int viewType = getIntent().getIntExtra(SimpleHabit.CURRENT_PROGRAM,0);

        mCurrentProgramVO =(CurrentProgramVO) SeriesModel.getsObjectInstance().getSeriesData().get(viewType);
        mCurrentSessionAdapter.setNewData(mCurrentProgramVO.getSessions());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvSessions.setLayoutManager(linearLayoutManager);
        rvSessions.setAdapter(mCurrentSessionAdapter);

        tvDesc.setText(mCurrentProgramVO.getDescription());
        if(tvDesc.getLineCount() < tvDesc.getMaxLines())
            btnReadMore.setVisibility(View.GONE);
    }
}
