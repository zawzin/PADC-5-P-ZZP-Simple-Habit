package xyz.zzp.simplehabit.events;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.TopicsVO;

public class LoadedTopicEvent {

    private List<TopicsVO> mTopicList;

    public LoadedTopicEvent(List<TopicsVO> mTopicList) {
        this.mTopicList = mTopicList;
    }

    public List<TopicsVO> getmTopicList() {
        return mTopicList;
    }
}
