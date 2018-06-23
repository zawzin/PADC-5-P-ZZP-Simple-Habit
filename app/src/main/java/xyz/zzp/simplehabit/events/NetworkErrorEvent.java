package xyz.zzp.simplehabit.events;

public class NetworkErrorEvent {

    private String errorMsg = "";

    public NetworkErrorEvent(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
