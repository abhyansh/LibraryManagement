package com.example.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity {
    Button adduser;
    Button addstudent;
    Button addbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        adduser=(Button)findViewById(R.id.add_user_button);
        addstudent=(Button)findViewById(R.id.add_student_button);
        addbook=(Button)findViewById(R.id.add_books);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dashboard.this,adduser.class);
                startActivity(intent);
            }
        });
        addstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(dashboard.this, addstudent.class);
                startActivity(intent1);
            }
        });
        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(dashboard.this,addbook.class);
                startActivity(intent2);
            }
        });
    }
}
