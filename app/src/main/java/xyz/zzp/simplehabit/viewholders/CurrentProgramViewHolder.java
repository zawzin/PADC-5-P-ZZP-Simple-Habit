package xyz.zzp.simplehabit.viewholders;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;

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

    private TapCurrentProgramDelegate mTapCurrentProgramDelegate;

    public CurrentProgramViewHolder(View itemView,TapCurrentProgramDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        mTapCurrentProgramDelegate = delegate;
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
        mTapCurrentProgramDelegate.onTapCurrentProgram();
    }
}
