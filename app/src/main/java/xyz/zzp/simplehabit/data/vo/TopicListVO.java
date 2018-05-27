package xyz.zzp.simplehabit.data.vo;

import java.util.List;

import xyz.zzp.simplehabit.HomeScreenVO;

public class TopicListVO implements HomeScreenVO {
    private List<TopicsVO> topicList;

    public List<TopicsVO> getTopicList() {
        return topicList;
    }
}
