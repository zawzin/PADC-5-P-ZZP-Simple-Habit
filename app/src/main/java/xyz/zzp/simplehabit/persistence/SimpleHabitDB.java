package xyz.zzp.simplehabit.persistence;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import xyz.zzp.simplehabit.data.vo.CategoryVO;
import xyz.zzp.simplehabit.data.vo.CurrentProgramVO;
import xyz.zzp.simplehabit.data.vo.ProgramVO;
import xyz.zzp.simplehabit.data.vo.SessionVO;
import xyz.zzp.simplehabit.data.vo.TopicsVO;
import xyz.zzp.simplehabit.persistence.dao.CategoryDao;
import xyz.zzp.simplehabit.persistence.dao.CurrentProgramDao;
import xyz.zzp.simplehabit.persistence.dao.ProgramDao;
import xyz.zzp.simplehabit.persistence.dao.SessionDao;
import xyz.zzp.simplehabit.persistence.dao.TopicDao;

@Database(entities = {
        CategoryVO.class, CurrentProgramVO.class, ProgramVO.class,
        SessionVO.class, TopicsVO.class
},version = 1)
public abstract class SimpleHabitDB extends RoomDatabase{

    private static final String DB_NAME = "SimpleHabit.DB";
    private static SimpleHabitDB INSTANCE;

    public abstract CategoryDao categoryDao();
    public abstract CurrentProgramDao currentProgramDao();
    public abstract ProgramDao programDao();
    public abstract SessionDao sessionDao();
    public abstract TopicDao topicDao();

    public static SimpleHabitDB getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,SimpleHabitDB.class,DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

}
