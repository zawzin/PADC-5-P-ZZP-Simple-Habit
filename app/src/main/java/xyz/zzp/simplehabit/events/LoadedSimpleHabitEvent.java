package xyz.zzp.simplehabit.events;

import java.util.List;

import xyz.zzp.simplehabit.data.vo.CategoryProgramVO;
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

        private List<CategoryProgramVO> categoryProgramList;

        public LoadedCategoryProgramEvent(List<CategoryProgramVO> categoryProgramList) {
            this.categoryProgramList = categoryProgramList;
        }

        public List<CategoryProgramVO> getCategoryProgramList() {
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
