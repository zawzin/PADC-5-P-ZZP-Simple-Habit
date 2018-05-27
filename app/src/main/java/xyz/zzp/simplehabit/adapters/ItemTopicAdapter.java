package xyz.zzp.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.TopicsVO;
import xyz.zzp.simplehabit.viewholders.ItemInTopicViewHolder;
import xyz.zzp.simplehabit.viewholders.TopicViewHolder;

public class ItemTopicAdapter extends BaseRecyclerAdapter<ItemInTopicViewHolder,TopicsVO> {

    private List<TopicsVO> mTopiclist;

    public ItemTopicAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public ItemInTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_topic,parent,false);
        ItemInTopicViewHolder itemInTopicViewHolder = new ItemInTopicViewHolder(view);

        return itemInTopicViewHolder;
    }

}
