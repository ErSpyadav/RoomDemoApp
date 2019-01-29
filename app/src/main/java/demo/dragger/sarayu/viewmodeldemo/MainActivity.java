package demo.dragger.sarayu.viewmodeldemo;
import android.arch.persistence.room.Room;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText empId,empName,empAge;
    Button saveBtn,fetchBtn;
    TextView valTxt;

    final String DATABASE_NAME = "EMP.db";
    EmployeeDatabase empDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empId=(EditText)findViewById(R.id.userId);
        empName=(EditText)findViewById(R.id.userName);
        empAge=(EditText)findViewById(R.id.userAge);
        valTxt=(TextView)findViewById(R.id.value);
        saveBtn=(Button)findViewById(R.id.btn_save);
        fetchBtn=(Button)findViewById(R.id.btn_retrive);

        System.out.println("This is Room Library demo app");
        empDatabase = Room.databaseBuilder(getApplicationContext(),
                EmployeeDatabase.class, DATABASE_NAME)
                .build();
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee emp=new Employee();
                emp.setEmpId(empId.getText().toString().trim());
                emp.setEmpName(empName.getText().toString().trim());
                emp.setEmpAge(Integer.parseInt(empAge.getText().toString().trim()));
                insertValue(emp);

            }
        });
        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Employee emp = empDatabase.emoAccess().fetchOneEmpbyMovieId(Integer.parseInt(empId.getText().toString().trim()));
                           System.out.println("Name:"+emp.getEmpName());
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                }) .start();


            }
        });
    }



    public void insertValue(final Employee emp)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    empDatabase.emoAccess().insertOnlySingleEmp(emp);
                    Log.d("MainActivity","Done");
                }
                catch (Exception e)
                {
                   e.printStackTrace();
                }
            }
        }) .start();

    }
}
