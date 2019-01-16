package demo.dragger.sarayu.viewmodeldemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Employee.class}, version = 1, exportSchema = false)
public abstract class EmployeeDatabase extends RoomDatabase {
    public abstract EmpDao emoAccess() ;
}


