package xyz.zzp.simplehabit.data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xyz.zzp.simplehabit.data.vo.CategoryProgramVO;
import xyz.zzp.simplehabit.network.RetrofitDataAgent;
import xyz.zzp.simplehabit.network.CategoryProgramDataAgent;

public class CategoryProgramModel {

    private static CategoryProgramModel sObjectInstance;
    private CategoryProgramDataAgent categoryProgramDataAgent;
    private List<CategoryProgramVO> mCategoryProgramList;
    private Map<String,CategoryProgramVO> categoryProgram;

    public CategoryProgramModel() {
        mCategoryProgramList = new ArrayList<>();
//        categoryProgramDataAgent = RetrofitDataAgent.getsObjectInstance();
    }

    public static CategoryProgramModel getsObjectInstance() {
        if (sObjectInstance == null)
            sObjectInstance = new CategoryProgramModel();
        return sObjectInstance;
    }

    public void loadCategoryProgram(){
        categoryProgramDataAgent.loadCategoryProgram();
    }

    public List<CategoryProgramVO> getmCategoryProgramList() {
        return mCategoryProgramList;
    }

    public void setmCategoryProgramList(List<CategoryProgramVO> categoryProgramList) {
        mCategoryProgramList.addAll(categoryProgramList);
    }
}
