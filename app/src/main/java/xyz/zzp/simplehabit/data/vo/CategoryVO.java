package xyz.zzp.simplehabit.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "category")
public class CategoryVO implements HomeScreenVO{

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "Id")
    @SerializedName("category-id")
    private String categoryId;

    @ColumnInfo(name = "categoryTitle")
    private String title;

    @Ignore
    private List<ProgramVO> programs;

    public String getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public List<ProgramVO> getPrograms() {
        return programs;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrograms(List<ProgramVO> programs) {
        this.programs = programs;
    }
}
