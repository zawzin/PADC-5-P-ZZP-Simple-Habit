package xyz.zzp.simplehabit.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "session",
        foreignKeys = {@ForeignKey(entity = ProgramVO.class,
                                    parentColumns = "Id",
                                    childColumns = "programId"),
                        @ForeignKey(entity = CurrentProgramVO.class,
                                    parentColumns = "Id",
                                    childColumns = "programId")})
public class SessionVO {

    @NonNull
    @PrimaryKey
    @SerializedName("session-id")
    private String sessionId;

    private String title;

    @SerializedName("length-in-seconds")
    private int lengthInSeconds;

    @SerializedName("file-path")
    private String filepath;

    private String programId;

    public String getSessionId() {
        return sessionId;
    }

    public String getTitle() {
        return title;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getFilepath() {
        return filepath;
    }

    public String getProgramId() {
        return programId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }


}
