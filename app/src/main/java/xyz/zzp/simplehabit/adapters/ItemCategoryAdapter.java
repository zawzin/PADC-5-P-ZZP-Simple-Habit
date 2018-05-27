package xyz.zzp.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.CategoryProgramVO;
import xyz.zzp.simplehabit.data.vo.ProgramVO;
import xyz.zzp.simplehabit.viewholders.ItemCategoryViewHolder;

public class ItemCategoryAdapter extends BaseRecyclerAdapter<ItemCategoryViewHolder,ProgramVO> {
    public ItemCategoryAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ItemCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemCategoryViewHolder itemCategoryViewHolder = new ItemCategoryViewHolder(layoutInflater.inflate(R.layout.item_card,parent,false));
        return itemCategoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCategoryViewHolder holder, int position) {
        holder.setData(mData.get(position));
    }
}
