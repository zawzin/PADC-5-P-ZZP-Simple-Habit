package xyz.zzp.simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.adapters.ItemInCategoryAdapter;

public class HealthyMindViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.rv_category_items)
    RecyclerView recyclerView;

    ItemInCategoryAdapter itemInCategoryAdapter;
    public HealthyMindViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);

        itemInCategoryAdapter= new ItemInCategoryAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(itemInCategoryAdapter);

    }

}
