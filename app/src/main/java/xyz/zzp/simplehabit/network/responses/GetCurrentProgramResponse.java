package xyz.zzp.simplehabit.network.responses;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;

public class GetCurrentProgramResponse {

    private int code;
    private String message;
    private String apiVersion;
    private CurrentProgramVO currentProgram;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
    }
}
