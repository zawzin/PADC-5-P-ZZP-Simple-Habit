package xyz.zzp.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.viewholders.ItemInTopicViewHolder;
import xyz.zzp.simplehabit.viewholders.TopicViewHolder;

public class ItemTopicAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_topic,parent,false);
        ItemInTopicViewHolder itemInTopicViewHolder = new ItemInTopicViewHolder(view);
        return itemInTopicViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
