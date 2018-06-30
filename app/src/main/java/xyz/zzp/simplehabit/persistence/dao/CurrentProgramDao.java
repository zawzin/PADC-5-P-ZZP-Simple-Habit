package xyz.zzp.simplehabit.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;

@Dao
public interface CurrentProgramDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertCurrentProgram(CurrentProgramVO currentProgram);

    @Query("SELECT * FROM currentProgram")
    CurrentProgramVO getCurrentProgram();

}
