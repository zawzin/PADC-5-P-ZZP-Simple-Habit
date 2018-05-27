package xyz.zzp.simplehabit.data.model;

import xyz.zzp.simplehabit.network.RetrofitDataAgent;
import xyz.zzp.simplehabit.network.CurrentProgramDataAgent;

public class CurrentProgramModel {

    private static CurrentProgramModel sObjectInstance;

    private CurrentProgramDataAgent mCurrentProgramDataAgent;

    public CurrentProgramModel() {
//        mCurrentProgramDataAgent = RetrofitDataAgent.getsObjectInstance();
    }

    public static CurrentProgramModel getsObjectInstance() {
        if (sObjectInstance == null)
            sObjectInstance = new CurrentProgramModel();
        return sObjectInstance;
    }

    public void loadCurrentProgram(){
        mCurrentProgramDataAgent.loadCurrentProgram();
    }
}
