package xyz.zzp.simplehabit.viewholders;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.delegates.TapCurrentProgram;

public class CurrentProgramViewHolder extends BaseViewHolder<CurrentProgramVO>{

    @BindView(R.id.tv_current_program_title)
    TextView tvTitle;

    @BindView(R.id.tv_length)
    TextView tvLength;

    @BindView(R.id.tv_current_period)
    TextView tvCurrentPeriod;

    @BindView(R.id.rl_current_program)
    RelativeLayout rlCurrentProgram;

    private CurrentProgramVO mCurrentProgramVO;

    private TapCurrentProgram mTapCurrentProgram;

    public CurrentProgramViewHolder(View itemView,TapCurrentProgram delegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        mTapCurrentProgram = delegate;
        rlCurrentProgram.setOnClickListener(this);
    }

    @Override
    public void setData(CurrentProgramVO data) {

        mCurrentProgramVO = data;

        int[] averageLength = data.getAverageLength();
        tvTitle.setText(data.getTitle());
        tvLength.setText(averageLength[0]+" mins");
        tvCurrentPeriod.setText(data.getCurrentPeriod());
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(itemView.getContext(),"click current program",Toast.LENGTH_SHORT).show();
        mTapCurrentProgram.onTapCurrentProgram(mCurrentProgramVO);
    }
}
