package xyz.zzp.simplehabit.network.responses;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.TopicsVO;

public class GetTopicResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<TopicsVO> topics;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TopicsVO> getTopics() {
        return topics;
    }
}
