package xyz.zzp.simplehabit.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "program",
        foreignKeys = @ForeignKey(entity = CategoryVO.class,
                                  parentColumns = "Id",
                                  childColumns = "categoryId"))
public class ProgramVO {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "Id")
    @SerializedName("program-id")
    private String programId;

    private String title;

    private String image;

    @Ignore
    @SerializedName("average-lengths")
    private int[] averageLength;

    private int averageLengthTime;

    private String description;

    private String categoryId;

    @Ignore
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

    public String getCategoryId() {
        return categoryId;
    }

    public int getAverageLengthTime() {
        if(averageLengthTime == 0){
            averageLengthTime = averageLength[0];
        }
        return averageLengthTime;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAverageLength(int[] averageLength) {
        this.averageLength = averageLength;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setAverageLengthTime(int averageLengthTime) {
        this.averageLengthTime = averageLengthTime;
    }

    public void setSessions(List<SessionVO> sessions) {
        this.sessions = sessions;
    }
}
