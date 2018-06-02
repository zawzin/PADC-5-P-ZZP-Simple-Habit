package xyz.zzp.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryVO implements HomeScreenVO{

    @SerializedName("category-id")
    private String categoryId;

    private String title;

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

}
