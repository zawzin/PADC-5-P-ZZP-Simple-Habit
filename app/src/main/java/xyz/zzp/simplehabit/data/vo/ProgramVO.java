package xyz.zzp.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProgramVO {

    @SerializedName("program-id")
    private String programId;

    private String title;

    private String image;

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

    public String getImage() {
        return image;
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
