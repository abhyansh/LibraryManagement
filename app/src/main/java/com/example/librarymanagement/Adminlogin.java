package com.example.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Adminlogin extends AppCompatActivity {
    private EditText adminmail;
    private EditText adminpass;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        getSupportActionBar().hide();
        adminmail=(EditText)findViewById(R.id.adminmail);
        adminpass=(EditText)findViewById(R.id.adminpassword);
        btn1=(Button)findViewById(R.id.submit);
        btn1.setOnClickListener(new View.OnClickListener() {
            String str3=adminmail.getText().toString();
            String str4=adminpass.getText().toString();
            public void onClick(View v) {
              /*  if(str3.isEmpty())
                {
                    Toast msg=Toast.makeText(getBaseContext(), "ENTER EMAIL ID",Toast.LENGTH_LONG);
                    msg.show();
                }
                else if(str4.isEmpty())
                {
                    Toast msg=Toast.makeText(getBaseContext(),"ENTER PASSWORD",Toast.LENGTH_LONG);
                    msg.show();
                }*/


                    Intent dashintent= new Intent(Adminlogin.this, dashboard.class);
                    startActivity(dashintent);


            }
        });

    }
}
