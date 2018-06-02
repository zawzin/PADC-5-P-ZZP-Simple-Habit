package xyz.zzp.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.ProgramVO;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;

public class ProgramViewHolder extends BaseViewHolder<ProgramVO> {

    @BindView(R.id.tv_program_title)
    TextView tvProgramTitle;

    private TapCurrentProgramDelegate mTapCurrentProgramDelegate;

    private ProgramVO mProgram;

    public ProgramViewHolder(View itemView,TapCurrentProgramDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mTapCurrentProgramDelegate = delegate;
    }

    @Override
    public void setData(ProgramVO data) {
        mProgram = data;
        tvProgramTitle.setText(data.getTitle());
    }

    @Override
    public void onClick(View view) {
        mTapCurrentProgramDelegate.onTapCurrentProgram(mProgram.getProgramId());
    }
}
