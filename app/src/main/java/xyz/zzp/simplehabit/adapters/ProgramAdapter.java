package xyz.zzp.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.CategoryVO;
import xyz.zzp.simplehabit.data.vo.ProgramVO;
import xyz.zzp.simplehabit.delegates.TapCategoryProgramDelegate;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;
import xyz.zzp.simplehabit.viewholders.ProgramViewHolder;

public class ProgramAdapter extends BaseRecyclerAdapter<ProgramViewHolder,ProgramVO> {

    private TapCategoryProgramDelegate mTapCategoryProgramDelegate;

    private CategoryVO mRootCategory;
    public ProgramAdapter(Context context, TapCategoryProgramDelegate delegate) {
        super(context);
        mTapCategoryProgramDelegate =delegate;
    }

    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ProgramViewHolder programViewHolder = new ProgramViewHolder(layoutInflater.inflate(R.layout.item_card,parent,false), mTapCategoryProgramDelegate);
        return programViewHolder;
    }

    @Override
    public void onBindViewHolder(ProgramViewHolder holder, int position) {
        holder.setData(mData.get(position));
        holder.setCategory(mRootCategory);
    }

    public void setCategory(CategoryVO category) {
        mRootCategory = category;
    }
}
