package demo.dragger.sarayu.viewmodeldemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface EmpDao {
    @Insert
    void insertOnlySingleEmp (Employee emp);
    @Insert
    void insertOnlyMultipleEmp (List<Employee> emp);

    @Query ("SELECT * FROM Employee WHERE empId = :empId")
    Employee fetchOneEmpbyMovieId (int empId);

    @Update
    void updateMovie (Employee emp);
    @Delete
    void deleteMovie (Employee emp);
}
