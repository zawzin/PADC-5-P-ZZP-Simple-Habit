package xyz.zzp.simplehabit.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.TopicsVO;

@Dao
public interface TopicDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertTopic(TopicsVO topic);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTopics(TopicsVO... topics);

    @Query("SELECT * FROM topic")
    List<TopicsVO> getTopicList();
}
