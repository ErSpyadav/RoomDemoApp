package demo.dragger.sarayu.viewmodeldemo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Employee {

    @NonNull
    @PrimaryKey
    private String empId;
    private String empName;
    private int empAge;

    public Employee() {
    }

    @NonNull
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(@NonNull String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }
}