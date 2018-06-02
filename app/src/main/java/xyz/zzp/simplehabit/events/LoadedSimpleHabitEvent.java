package xyz.zzp.simplehabit.events;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.CategoryVO;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.data.vo.TopicsVO;

public class LoadedSimpleHabitEvent {

    public static class LoadedCurrentProgramEvent {

        private CurrentProgramVO currentProgram;

        public LoadedCurrentProgramEvent(CurrentProgramVO currentProgram) {
            this.currentProgram = currentProgram;
        }

        public CurrentProgramVO getCurrentProgram() {
            return currentProgram;
        }
    }

    public class LoadedCategoryProgramEvent {

        private List<CategoryVO> categoryProgramList;

        public LoadedCategoryProgramEvent(List<CategoryVO> categoryProgramList) {
            this.categoryProgramList = categoryProgramList;
        }

        public List<CategoryVO> getCategoryProgramList() {
            return categoryProgramList;
        }
    }

    public class LoadedTopicEvent {

        private List<TopicsVO> mTopicList;

        public LoadedTopicEvent(List<TopicsVO> mTopicList) {
            this.mTopicList = mTopicList;
        }

        public List<TopicsVO> getmTopicList() {
            return mTopicList;
        }
    }
}
