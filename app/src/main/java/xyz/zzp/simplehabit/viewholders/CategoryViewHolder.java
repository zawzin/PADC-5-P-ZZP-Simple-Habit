package xyz.zzp.simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.adapters.ProgramAdapter;
import xyz.zzp.simplehabit.data.vo.CategoryVO;
import xyz.zzp.simplehabit.delegates.TapCategoryProgramDelegate;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;

public class CategoryViewHolder extends BaseViewHolder<CategoryVO>{

    @BindView(R.id.tv_category_title)
    TextView tvCategoryTitle;

    @BindView(R.id.rv_programs)
    RecyclerView rvPrograms;

    private TapCategoryProgramDelegate mTapCategoryProgramDelegate;
    private ProgramAdapter mProgramAdapter;

    public CategoryViewHolder(View itemView,TapCategoryProgramDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mTapCategoryProgramDelegate = delegate;

        mProgramAdapter = new ProgramAdapter(itemView.getContext(),mTapCategoryProgramDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);

        rvPrograms.setLayoutManager(linearLayoutManager);
        rvPrograms.setAdapter(mProgramAdapter);

    }

    @Override
    public void setData(CategoryVO data) {
        tvCategoryTitle.setText(data.getTitle());
        mProgramAdapter.setNewData(data.getPrograms());
        mProgramAdapter.setCategory(data);
    }
    @Override
    public void onClick(View view) {

    }
}
