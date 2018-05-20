package xyz.zzp.simplehabit.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import xyz.zzp.simplehabit.R;
import xyz.zzp.simplehabit.viewholders.HealthyMindViewHolder;
import xyz.zzp.simplehabit.viewholders.MorningMediationsViewHolder;
import xyz.zzp.simplehabit.viewholders.MostPopularViewHolder;
import xyz.zzp.simplehabit.viewholders.NewOnSimpleHabitViewHolder;
import xyz.zzp.simplehabit.viewholders.TopicViewHolder;
import xyz.zzp.simplehabit.viewholders.SeriesViewHolder;

public class SeriesAdapter extends RecyclerView.Adapter {

    private static final int START_HERE = 0;
    private static final int MORNING_MEDIATIONS = 1;
    private static final int A_HEALTHY_MIND = 2;
    private static final int NEW_ON_SIMPLE_HABIT = 3;
    private static final int MOST_POPULAR = 4;
    private static final int ALL_TOPICS = 5;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case START_HERE:
                viewHolder = new SeriesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_start_here,parent,false));
                break;
            case MORNING_MEDIATIONS:
                viewHolder = new MorningMediationsViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_morning_mediations, parent, false));
                break;
            case A_HEALTHY_MIND:
                viewHolder = new HealthyMindViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_healthy_mind, parent, false));
                break;
            case NEW_ON_SIMPLE_HABIT:
                viewHolder = new NewOnSimpleHabitViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_new_on_simple_habit, parent, false));
                break;
            case MOST_POPULAR:
                viewHolder = new MostPopularViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_most_popular, parent, false));
                break;
            case ALL_TOPICS:
                viewHolder = new TopicViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_topic, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        int i = 0;
        switch (position) {
            case 0:
                i = START_HERE;
                break;
            case 1:
                i = MORNING_MEDIATIONS;
                break;
            case 2:
                i = A_HEALTHY_MIND;
                break;
            case 3:
                i = NEW_ON_SIMPLE_HABIT;
                break;
            case 4:
                i = MOST_POPULAR;
                break;
            case 5:
                i = ALL_TOPICS;
                break;
        }
        return i;
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
