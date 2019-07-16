package com.example.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    private EditText mail;
    private EditText password;
    Button btn;
    private TextView click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        mail=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        btn=(Button)findViewById((R.id.submt));
        click=(TextView)findViewById(R.id.loginadmin);
        final String str =mail.getText().toString();
        final String str1=password.getText().toString();
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.isEmpty())
                {
                    Toast msg=Toast.makeText(getBaseContext(), "ENTER EMAIL ID",Toast.LENGTH_LONG);
                    msg.show();
                }
                if (str1.isEmpty())
                {
                    Toast msg=Toast.makeText(getBaseContext(),"ENTER PASSWORD",Toast.LENGTH_LONG);
                    msg.show();
                }

            }
        });*/
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(loginActivity.this,Adminlogin.class);
                startActivity(intent);
            }
        });



    }

}
