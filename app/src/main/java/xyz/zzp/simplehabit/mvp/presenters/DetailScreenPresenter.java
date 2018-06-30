package xyz.zzp.simplehabit.mvp.presenters;

import xyz.zzp.simplehabit.data.model.SeriesModel;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.data.vo.ProgramVO;
import xyz.zzp.simplehabit.mvp.views.DetailScreenView;

public class DetailScreenPresenter extends BasePresenter<DetailScreenView> {

    @Override
    public void initPresenter(DetailScreenView mView) {
        super.initPresenter(mView);
    }

    public void onDetectCurrentProgram(){
        CurrentProgramVO currentProgram = SeriesModel.getsObjectInstance().getCurrentProgram();
        mView.displayCurrentProgram(currentProgram);
    }

    public void onDetectCategoryProgram(String categoryId, String categoryProgramId){
        ProgramVO program = SeriesModel.getsObjectInstance().getProgram(categoryId,categoryProgramId);
        mView.displayCategoryProgram(program);
    }
}
