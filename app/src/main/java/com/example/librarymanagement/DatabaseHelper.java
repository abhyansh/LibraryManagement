package com.example.librarymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static int DATABASE_VERSION     =   1;
    private static String DATABASE_NAME     =   "Library";


    private static String TABLE_ADD_USER    =   "add_user";
    private static String TABLE_ADD_STUDENT =   "add_student";
    private static String TABLE_ADD_BOOK    =   "add_book";

    //TABLE-ADD STUDENT
    private static String STUDENT_NAME      =   "student_name";
    private static String FATHER_NAME       =   "student_father";
    private static String MOTHER_NAME       =   "student_mother";
    private static String STUDENT_MAIL      =   "student_mail";
    private static String STUDENT_COLLEGE   =   "student_college";
    private static String STUDENT_PERCENT   =   "student_percent";
    private static String STUDENT_PASSWORD  =   "student_password";

    // ADD BOOKS - column names
    private static String BOOK_TITLE        =   "title_book";
    private static String BOOK_AUTHOR       =   "author_book";
    private static String BOOK_PUBLISHER    =   "publisher_book";
    private static String BOOK_ISBN         =   "isbn_book";

    // ADD USER - column names
    private static String USER_NAME         =   "name_user";
    private static String USER_MAIL         =   "mail_user";
    private static String USER_PASSWORD     =   "password_user";

    // CREATING ADD_STUDENT
    private static String CREATE_TABLE_ADD_STUDENT = "CREATE TABLE "
            + TABLE_ADD_STUDENT + "(" + STUDENT_NAME + " TEXT," + FATHER_NAME +  " TEXT," + MOTHER_NAME
            + " TEXT," + STUDENT_COLLEGE + "TEXT," + STUDENT_PERCENT + "INTEGER," + STUDENT_MAIL + " TEXT PRIMARY KEY," + STUDENT_PASSWORD
            + " TEXT" + ")";

    // CREATING ADD_BOOK
    private static String CREATE_TABLE_ADD_BOOK = "CREATE TABLE " + TABLE_ADD_BOOK
            + "(" + BOOK_ISBN + " INTEGER PRIMARY KEY," + BOOK_AUTHOR + " TEXT,"
            + BOOK_TITLE + " TEXT," + BOOK_PUBLISHER + " TEXT " + ")";

    // CREATING ADD_USER
    private static String CREATE_TABLE_ADD_USER = "CREATE TABLE "
            + TABLE_ADD_USER + "(" + USER_MAIL + " TEXT PRIMARY KEY,"
            + USER_NAME + " TEXT," + USER_PASSWORD + " TEXT" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("table", CREATE_TABLE_ADD_STUDENT);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_ADD_USER);
        db.execSQL(CREATE_TABLE_ADD_BOOK);
        db.execSQL("CREATE TABLE "
                + TABLE_ADD_STUDENT + "(" + STUDENT_NAME + " TEXT," + FATHER_NAME +  " TEXT," + MOTHER_NAME
                + " TEXT," + STUDENT_COLLEGE + "TEXT," + STUDENT_PERCENT + "INTEGER," + STUDENT_MAIL + " TEXT PRIMARY KEY," + STUDENT_PASSWORD
                + " TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADD_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADD_BOOK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADD_STUDENT);

        //create new tables
        onCreate(db);
    }

    public boolean insertData(String studentname, String studentfathername, String studentmothername, String studentcollege, String studentpercent, String studentmail, String studentpassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        boolean result=true;
        contentValues.put(studentname,STUDENT_NAME);
        contentValues.put(studentfathername,FATHER_NAME);
        contentValues.put(studentmothername,MOTHER_NAME);
        contentValues.put(studentcollege,STUDENT_COLLEGE);
        contentValues.put(studentpercent,STUDENT_PERCENT);
        contentValues.put(studentmail,STUDENT_MAIL);
        contentValues.put(studentpassword,STUDENT_PASSWORD);

        if(db.insert(TABLE_ADD_STUDENT,null ,contentValues) > 0)
            result=true;

        else
            result=false;
        db.close();
        return result;
    }
public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_ADD_STUDENT,null);
        return res;
    }

}
