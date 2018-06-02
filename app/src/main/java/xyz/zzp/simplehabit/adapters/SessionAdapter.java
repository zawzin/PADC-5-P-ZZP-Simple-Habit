package xyz.zzp.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.SessionVO;
import xyz.zzp.simplehabit.viewholders.SessionViewHolder;

public class SessionAdapter extends BaseRecyclerAdapter<SessionViewHolder,SessionVO> {
    public SessionAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_session,parent,false);
        return new SessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionViewHolder holder, int position) {
        holder.setData(mData.get(position));
    }

}
