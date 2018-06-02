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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.SimpleHabit;
import xyz.zzp.simplehabit.adapters.SessionAdapter;
import xyz.zzp.simplehabit.data.model.SeriesModel;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.data.vo.ProgramVO;
import xyz.zzp.simplehabit.data.vo.SessionVO;

public class ProgramDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.rv_sessions)
    RecyclerView rvSessions;

    @BindView(R.id.tv_desc)
    TextView tvDesc;

    @BindView(R.id.btn_read_more)
    TextView btnReadMore;

    private SessionAdapter mSessionAdapter;

    private CurrentProgramVO mCurrentProgramVO;
    private ProgramVO mProgramVO;
    private List<SessionVO> sessionList;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,ProgramDetailActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_detail);

        ButterKnife.bind(this,this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));

        mSessionAdapter = new SessionAdapter(this);
        String programId = getIntent().getStringExtra(SimpleHabit.PROGRAM_ID);

//        sessionList = SeriesModel.getsObjectInstance().getSessionByProgramId(programId);
//        Log.i(SimpleHabit.LOG_TAG,"list siz"+sessionList.size());
        if(SeriesModel.getsObjectInstance().getProgramsByProgramId(programId)!= null){
            mCurrentProgramVO = SeriesModel.getsObjectInstance().getProgramsByProgramId(programId);
            mSessionAdapter.setNewData(mCurrentProgramVO.getSessions());

            tvTitle.setText(mCurrentProgramVO.getTitle());
            tvDesc.setText(mCurrentProgramVO.getDescription());
            if(tvDesc.getLineCount() < tvDesc.getMaxLines())
                btnReadMore.setVisibility(View.GONE);
        }
        else if(SeriesModel.getsObjectInstance().getProgramByProgramId(programId)!= null){
            mProgramVO = SeriesModel.getsObjectInstance().getProgramByProgramId(programId);
            mSessionAdapter.setNewData(mProgramVO.getSessions());

            tvTitle.setText(mProgramVO.getTitle());
            tvDesc.setText(mProgramVO.getDescription());
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvSessions.setLayoutManager(linearLayoutManager);
        rvSessions.setAdapter(mSessionAdapter);

    }
}
