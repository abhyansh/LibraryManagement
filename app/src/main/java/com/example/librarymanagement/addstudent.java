package com.example.librarymanagement;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addstudent extends AppCompatActivity {
    Button submitstudent, viewdatastudent;
    EditText stu_name, stu_father, stu_mother, stu_mail, stu_pass, stu_percent, stu_college;
    DatabaseHelper myDb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);
        myDb = new DatabaseHelper(this);
        stu_father = (EditText) findViewById(R.id.sfather);
        stu_mail = (EditText) findViewById(R.id.smail);
        stu_mother = (EditText) findViewById(R.id.smother);
        stu_name = (EditText) findViewById(R.id.sname);
        stu_pass = (EditText) findViewById(R.id.spassword);
        stu_percent = (EditText) findViewById(R.id.spercent);
        stu_college = (EditText) findViewById(R.id.scollege);
        submitstudent = (Button) findViewById(R.id.submituser);
        viewdatastudent = (Button) findViewById(R.id.viewstudentdata);

    }

    private void AddData() {

            submitstudent.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name       =   stu_name.getText().toString();
                            String father     =   stu_father.getText().toString();
                            String mother     =   stu_mother.getText().toString();
                            String college    =   stu_college.getText().toString();
                            String percent    =   stu_percent.getText().toString();
                            String mail       =   stu_mail.getText().toString();
                            String password   =   stu_pass.getText().toString();

                            boolean isInserted;
                            if (myDb.insertData(name, father, mother, college, percent, mail, password))
                                isInserted = true;
                            else isInserted = false;

                            if(isInserted)
                                Toast.makeText(addstudent.this,"Data Inserted",Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(addstudent.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                        }
                    }
            );
    }

    public void viewAll() {
        viewdatastudent.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Student Name :"+ res.getString(0)+"\n");
                            buffer.append("Father's Name :"+ res.getString(1)+"\n");
                            buffer.append("Mother's Name :"+ res.getString(2)+"\n");
                            buffer.append("College Name :"+ res.getString(3)+"\n\n");
                            buffer.append("Student Percent :"+ res.getString(4)+"\n\n");
                            buffer.append("Student Email :"+ res.getString(5)+"\n\n");
                            buffer.append("Password :"+ res.getString(6)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
