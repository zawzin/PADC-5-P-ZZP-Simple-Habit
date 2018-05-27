package xyz.zzp.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.CategoryProgramVO;
import xyz.zzp.simplehabit.viewholders.CategoryViewHolder;

public class CategoryAdapter extends BaseRecyclerAdapter {

    private CategoryProgramVO mCategoryProgramVO;

    public CategoryAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(layoutInflater.inflate(R.layout.item_category,parent,false));
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

}
