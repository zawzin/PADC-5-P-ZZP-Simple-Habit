package xyz.zzp.simplehabit.events;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.CategoryProgramVO;

public class LoadedCategoryProgramEvent {

    private List<CategoryProgramVO> categoryProgramList;

    public LoadedCategoryProgramEvent(List<CategoryProgramVO> categoryProgramList) {
        this.categoryProgramList = categoryProgramList;
    }

    public List<CategoryProgramVO> getCategoryProgramList() {
        return categoryProgramList;
    }
}
