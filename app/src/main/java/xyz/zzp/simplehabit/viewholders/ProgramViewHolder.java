package xyz.zzp.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.ProgramVO;

public class ProgramViewHolder extends BaseViewHolder<ProgramVO> {

    @BindView(R.id.tv_program_title)
    TextView tvProgramTitle;


    public ProgramViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(ProgramVO data) {
        tvProgramTitle.setText(data.getTitle());
    }

    @Override
    public void onClick(View view) {

    }
}
