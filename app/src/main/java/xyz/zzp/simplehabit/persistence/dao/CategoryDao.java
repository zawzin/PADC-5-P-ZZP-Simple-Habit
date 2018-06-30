package xyz.zzp.simplehabit.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.CategoryVO;

@Dao
public interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertCategory(CategoryVO category);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertCategories(CategoryVO... categories);

    @Query("SELECT * FROM category")
    List<CategoryVO> getCategoryList();
}
