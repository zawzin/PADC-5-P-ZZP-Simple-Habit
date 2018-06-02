package xyz.zzp.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.data.vo.SessionVO;
import xyz.zzp.simplehabit.viewholders.CurrentSessionViewHolder;

public class CurrentSessionAdapter extends BaseRecyclerAdapter<CurrentSessionViewHolder,SessionVO> {
    public CurrentSessionAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public CurrentSessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return new CurrentSessionViewHolder(layoutInflater.inflate(R.layout.item_session,parent,false));
    }

}
