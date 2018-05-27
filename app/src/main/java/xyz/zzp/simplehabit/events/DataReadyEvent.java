package xyz.zzp.simplehabit.events;

import java.util.Collection;
import java.util.List;

import xyz.zzp.simplehabit.HomeScreenVO;

public class DataReadyEvent {

    private List<HomeScreenVO> seriesData;

    public DataReadyEvent(List<HomeScreenVO> seriesData) {
        this.seriesData = seriesData;
    }

    public List<HomeScreenVO> getSeriesData() {
        return seriesData;
    }
}
