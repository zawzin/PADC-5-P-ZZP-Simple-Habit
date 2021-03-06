package xyz.zzp.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.HomeScreenVO;
import xyz.zzp.simplehabit.data.vo.CategoryVO;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.data.vo.TopicsVO;
import xyz.zzp.simplehabit.delegates.TapCategoryProgramDelegate;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;
import xyz.zzp.simplehabit.viewholders.BaseViewHolder;
import xyz.zzp.simplehabit.viewholders.CategoryViewHolder;
import xyz.zzp.simplehabit.viewholders.CurrentProgramViewHolder;
import xyz.zzp.simplehabit.viewholders.TopicViewHolder;

public class SeriesAdapter extends BaseRecyclerAdapter<BaseViewHolder, HomeScreenVO> {

    private static final int START_HERE = 0;
    private static final int CATEGORY = 1;
    private static final int ALL_TOPICS = 2;

    private TapCurrentProgramDelegate mTapCurrentProgramDelegate;
    private TapCategoryProgramDelegate mTapCategoryProgramDelegate;

    public SeriesAdapter(Context context, TapCurrentProgramDelegate currentProgramDelegate,
                         TapCategoryProgramDelegate categoryProgramDelegate) {
        super(context);
        mTapCurrentProgramDelegate = currentProgramDelegate;
        mTapCategoryProgramDelegate = categoryProgramDelegate;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        BaseViewHolder viewHolder = null;
        if(viewType == START_HERE){
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_current_program,parent,false);
            viewHolder = new CurrentProgramViewHolder(itemView, mTapCurrentProgramDelegate);
        }
        else if(viewType == CATEGORY){
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
            viewHolder = new CategoryViewHolder(itemView,mTapCategoryProgramDelegate);
        }
        else if(viewType == ALL_TOPICS){
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic,parent,false);
            viewHolder = new TopicViewHolder(itemView);
        }
          return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if(mData.get(position) instanceof CurrentProgramVO)
            return START_HERE;
        else if(mData.get(position) instanceof CategoryVO)
            return CATEGORY;
        else if(mData.get(position) instanceof TopicsVO)
            return ALL_TOPICS;
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
