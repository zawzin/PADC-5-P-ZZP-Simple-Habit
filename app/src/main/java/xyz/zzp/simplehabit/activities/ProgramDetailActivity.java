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
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.SimpleHabit;
import xyz.zzp.simplehabit.adapters.SessionAdapter;
import xyz.zzp.simplehabit.data.model.SeriesModel;
import xyz.zzp.simplehabit.data.vo.CategoryVO;
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

    public static Intent newIntentCategoryProgram(Context context,String categoryId,String categoryProgramId){
        Intent intent = new Intent(context,ProgramDetailActivity.class);
        intent.putExtra(SimpleHabit.VIEW_TYPE,SimpleHabit.CATEGORY);
        intent.putExtra(SimpleHabit.CATEGORY_ID,categoryId);
        intent.putExtra(SimpleHabit.CATEGORY_PROGRAM_ID,categoryProgramId);
        return intent;
    }

    public static Intent newIntentCurrentProgram(Context context){
        Intent intent = new Intent(context,ProgramDetailActivity.class);
        intent.putExtra(SimpleHabit.VIEW_TYPE,SimpleHabit.CURRENT_PROGRAM);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_detail);

        ButterKnife.bind(this,this);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        }

        mSessionAdapter = new SessionAdapter(this);
        String programId = getIntent().getStringExtra(SimpleHabit.PROGRAM_ID);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvSessions.setLayoutManager(linearLayoutManager);
        rvSessions.setAdapter(mSessionAdapter);


        if(getIntent().getStringExtra(SimpleHabit.VIEW_TYPE).equals(SimpleHabit.CURRENT_PROGRAM)){
            CurrentProgramVO currentProgram = SeriesModel.getsObjectInstance().getCurrentProgram();
            mSessionAdapter.setNewData(currentProgram.getSessions());
            tvTitle.setText(currentProgram.getTitle());
            tvDesc.setText(currentProgram.getDescription());
        }
        else if(getIntent().getStringExtra(SimpleHabit.VIEW_TYPE).equals(SimpleHabit.CATEGORY)){
            String categoryId = getIntent().getStringExtra(SimpleHabit.CATEGORY_ID);
            String categoryProgramId = getIntent().getStringExtra(SimpleHabit.CATEGORY_PROGRAM_ID);

            ProgramVO categoryProgram = SeriesModel.getsObjectInstance().getProgram(categoryId,categoryProgramId);
            mSessionAdapter.setNewData(categoryProgram.getSessions());
            tvTitle.setText(categoryProgram.getTitle());
            tvDesc.setText(categoryProgram.getDescription());
        }
    }
}
