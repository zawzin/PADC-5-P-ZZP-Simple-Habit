package xyz.zzp.simplehabit.events;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.CategoryVO;

public class LoadedCategoryProgramEvent {

    private List<CategoryVO> categoryProgramList;

    public LoadedCategoryProgramEvent(List<CategoryVO> categoryProgramList) {
        this.categoryProgramList = categoryProgramList;
    }

    public List<CategoryVO> getCategoryProgramList() {
        return categoryProgramList;
    }
}
