package xyz.zzp.simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.adapters.ProgramAdapter;
import xyz.zzp.simplehabit.data.vo.CategoryProgramVO;

public class CategoryViewHolder extends BaseViewHolder<CategoryProgramVO>{

    @BindView(R.id.tv_category_title)
    TextView tvCategoryTitle;

    @BindView(R.id.rv_programs)
    RecyclerView rvPrograms;

    private ProgramAdapter mCategoryAdapter;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        mCategoryAdapter = new ProgramAdapter(itemView.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);

        rvPrograms.setLayoutManager(linearLayoutManager);
        rvPrograms.setAdapter(mCategoryAdapter);

    }

    @Override
    public void setData(CategoryProgramVO data) {
        tvCategoryTitle.setText(data.getTitle());
        mCategoryAdapter.setNewData(data.getPrograms());
    }
    @Override
    public void onClick(View view) {

    }
}
