package xyz.zzp.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.zzp.simplehabit.HomeScreenVO;

public class CurrentProgramVO implements HomeScreenVO{

    @SerializedName("program-id")
    private String programId;

    private String title;

    @SerializedName("current-period")
    private String currentPeriod;

    private String background;

    @SerializedName("average-lengths")
    private int[] averageLength;

    private String description;

    private List<SessionVO> sessions;

    public String getProgramId() {
        return programId;
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public String getBackground() {
        return background;
    }

    public int[] getAverageLength() {
        return averageLength;
    }

    public String getDescription() {
        return description;
    }

    public List<SessionVO> getSessions() {
        return sessions;
    }
}
