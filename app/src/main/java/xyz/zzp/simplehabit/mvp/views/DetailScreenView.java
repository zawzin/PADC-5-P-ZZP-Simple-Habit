package xyz.zzp.simplehabit.mvp.views;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.data.vo.ProgramVO;

public interface DetailScreenView extends BaseView {

    void displayCurrentProgram(CurrentProgramVO currentProgramVO);

    void displayCategoryProgram(ProgramVO programVO);

}
