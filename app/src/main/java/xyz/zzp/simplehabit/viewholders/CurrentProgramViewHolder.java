package xyz.zzp.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;

public class CurrentProgramViewHolder extends BaseViewHolder<CurrentProgramVO>{

    @BindView(R.id.tv_current_program_title)
    TextView tvTitle;

    @BindView(R.id.tv_length)
    TextView tvLength;

    @BindView(R.id.tv_current_period)
    TextView tvCurrentPeriod;

    private CurrentProgramVO mCurrentProgramVO;

    public CurrentProgramViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

    }

    @Override
    public void setData(CurrentProgramVO data) {
        int[] averageLength = data.getAverageLength();
        tvTitle.setText(data.getTitle());
        tvLength.setText(averageLength[0]+" mins");
        tvCurrentPeriod.setText(data.getCurrentPeriod());
    }

    @Override
    public void onClick(View view) {

    }
}
