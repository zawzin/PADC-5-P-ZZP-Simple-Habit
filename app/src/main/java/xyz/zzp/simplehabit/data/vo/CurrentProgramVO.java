package xyz.zzp.simplehabit.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "currentProgram")
public class CurrentProgramVO implements HomeScreenVO{

    @NonNull
    @PrimaryKey
    @SerializedName("program-id")
    private String Id;

    private String title;

    @SerializedName("current-period")
    private String currentPeriod;

    private String background;

    private int averageLengthTime;

    @Ignore
    @SerializedName("average-lengths")
    private int[] averageLength;

    private String description;

    @Ignore
    private List<SessionVO> sessions;

    public String getProgramId() {
        return Id;
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

    public int getAverageLengthTime() {
        if(averageLengthTime == 0){
            averageLengthTime = averageLength[0];
        }
        return averageLengthTime;
    }

    public String getId() {
        return Id;
    }

    public void setProgramId(String programId) {
            Id = programId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setAverageLengthTime(int averageLengthTime) {
        this.averageLengthTime = averageLengthTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setAverageLength(int[] averageLength) {
        this.averageLength = averageLength;
    }

    public void setSessions(List<SessionVO> sessions) {
        this.sessions = sessions;
    }

}
