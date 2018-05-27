package xyz.zzp.simplehabit.events;

import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;

public class LoadedCurrentProgramEvent {

    private CurrentProgramVO currentProgram;

    public LoadedCurrentProgramEvent(CurrentProgramVO currentProgram) {
        this.currentProgram = currentProgram;
    }

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
    }
}
