package xyz.zzp.simplehabit.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.ProgramVO;

@Dao
public interface ProgramDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertProgram(ProgramVO program);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertPrograms(ProgramVO... programs);

    @Query("SELECT * FROM program where categoryId = :id")
    List<ProgramVO> getProgramsByCategoryId(String id);
}
