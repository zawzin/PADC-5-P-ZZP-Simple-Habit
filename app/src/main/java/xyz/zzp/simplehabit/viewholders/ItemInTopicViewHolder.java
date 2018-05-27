package xyz.zzp.simplehabit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.TopicsVO;

public class ItemInTopicViewHolder extends BaseViewHolder<TopicsVO> {

    @BindView(R.id.tv_topic_name)
    TextView topicName;

    @BindView(R.id.tv_topic_desc)
    TextView topicDesc;

    @BindView(R.id.iv_topic_background)
    ImageView ivTopicBackground;

    @BindView(R.id.icon_text)
    TextView tvTopicIconText;

    private TopicsVO mTopicVO;

    public ItemInTopicViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(TopicsVO data) {
        mTopicVO = data;
        topicName.setText(data.getTopicName());
        topicDesc.setText(data.getTopicDesc());
    }

    @Override
    public void onClick(View view) {

    }
}
