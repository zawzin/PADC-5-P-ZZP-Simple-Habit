package xyz.zzp.simplehabit.mvp.views;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.HomeScreenVO;

public interface HomeScreenView extends BaseView {

    void displayHomeScreen(List<HomeScreenVO> list);

    void lunchDetail();

    void lunchDetail(String categoryId,String categoryProgramId);

}
