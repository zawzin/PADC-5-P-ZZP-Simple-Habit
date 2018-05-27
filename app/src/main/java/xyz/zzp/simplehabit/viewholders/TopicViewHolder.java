package xyz.zzp.simplehabit.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.adapters.ItemTopicAdapter;
import xyz.zzp.simplehabit.data.vo.TopicListVO;

public class TopicViewHolder extends BaseViewHolder {
    @BindView(R.id.rv_topic_items)
    RecyclerView recyclerView;

    ItemTopicAdapter itemTopicAdapter;

    public TopicViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);


        itemTopicAdapter = new ItemTopicAdapter(itemView.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(itemTopicAdapter);

    }

    @Override
    public void setData(Object data) {
    }

    @Override
    public void onClick(View view) {

    }
}