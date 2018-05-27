package xyz.zzp.simplehabit.data.model;

import xyz.zzp.simplehabit.network.RetrofitDataAgent;
import xyz.zzp.simplehabit.network.TopicDataAgent;

public class TopicsModel {

    private static TopicsModel sObjectInstance;
    private TopicDataAgent mTopicDataAgent;

    private TopicsModel(){
//        mTopicDataAgent = RetrofitDataAgent.getsObjectInstance();
    }

    public static TopicsModel getsObjectInstance() {
        if(sObjectInstance == null)
            sObjectInstance = new TopicsModel();
        return sObjectInstance;
    }
    public void loadTopic(){
        mTopicDataAgent.loadTopic();
    }
}
