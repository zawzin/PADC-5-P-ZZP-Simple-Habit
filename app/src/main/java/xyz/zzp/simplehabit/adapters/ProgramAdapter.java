package xyz.zzp.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.ProgramVO;
import xyz.zzp.simplehabit.delegates.TapCurrentProgramDelegate;
import xyz.zzp.simplehabit.viewholders.ProgramViewHolder;

public class ProgramAdapter extends BaseRecyclerAdapter<ProgramViewHolder,ProgramVO> {

    private TapCurrentProgramDelegate mTapCurrentProgramDelegate;

    public ProgramAdapter(Context context, TapCurrentProgramDelegate delegate) {
        super(context);
        mTapCurrentProgramDelegate =delegate;
    }

    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ProgramViewHolder programViewHolder = new ProgramViewHolder(layoutInflater.inflate(R.layout.item_card,parent,false), mTapCurrentProgramDelegate);
        return programViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder holder, int position) {
        holder.setData(mData.get(position));
    }
}
