package xyz.zzp.simplehabit.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.SessionVO;

@Dao
public interface SessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertSession(SessionVO session);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertSessions(SessionVO... sessions);

    @Query("SELECT * FROM session WHERE sessionId = :id")
    List<SessionVO> getSessionsByProgramId(String id);
}
