package com.example.librarymanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addbook extends AppCompatActivity {
    EditText title , author , publisher ,publish_date,isbn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        title=(EditText)findViewById(R.id.book_title);
        author=(EditText)findViewById(R.id.book_author);
        publisher=(EditText)findViewById(R.id.ebook_publisher);
        publish_date=(EditText)findViewById(R.id.book_publish_date);
        isbn=(EditText)findViewById(R.id.book_isbn);

    }

}
