package xyz.zzp.simplehabit.network.responses;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.CategoryProgramVO;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;

public class GetCategoryProgramResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<CategoryProgramVO> categoriesPrograms;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<CategoryProgramVO> getCategoryProgramList() {
        return categoriesPrograms;
    }
}
