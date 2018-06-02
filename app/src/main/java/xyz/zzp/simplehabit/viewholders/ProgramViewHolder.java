package xyz.zzp.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.CategoryVO;
import xyz.zzp.simplehabit.data.vo.ProgramVO;
import xyz.zzp.simplehabit.delegates.TapCategoryProgramDelegate;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;

public class ProgramViewHolder extends BaseViewHolder<ProgramVO> {

    @BindView(R.id.tv_program_title)
    TextView tvProgramTitle;

    private TapCategoryProgramDelegate mTapCategoryProgramDelegate;

    private CategoryVO mCategoryVO;

    private ProgramVO mProgram;

    public ProgramViewHolder(View itemView,TapCategoryProgramDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mTapCategoryProgramDelegate = delegate;
    }

    @Override
    public void setData(ProgramVO data) {
        mProgram = data;
        tvProgramTitle.setText(data.getTitle());
    }

    public void setCategory(CategoryVO category){
        mCategoryVO = category;
    }

    @Override
    public void onClick(View view) {
        mTapCategoryProgramDelegate.onTapCategoryProgramDelegate(mCategoryVO.getCategoryId(),mProgram.getProgramId());
    }
}
