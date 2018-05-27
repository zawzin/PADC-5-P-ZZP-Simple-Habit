package xyz.zzp.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

public class SessionVO {

    @SerializedName("session-id")
    private String sessionId;

    private String title;

    @SerializedName("length-in-seconds")
    private int lengthInSeconds;

    @SerializedName("file-path")
    private String filepath;

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
}
