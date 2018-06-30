package xyz.zzp.simplehabit.mvp.views;


public interface SeriesScreenView extends BaseView {

    void lunchCurrentProgramDetail();

    void lunchCategoryProgramDetail(String categoryId, String categoryProgramId);
}
