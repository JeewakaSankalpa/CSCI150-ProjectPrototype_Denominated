package com.nocompany.cs150.classmanagement.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Navjeet on 10/26/2016.
 */

public class StudentInformationDBHelper extends SQLiteOpenHelper {

    private static StudentInformationDBHelper instance;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME ="StudentInformation.db";
    public static final String COMMA_SEP = ",";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INT";
    private static final String INT_PRIMARY_KEY = " INTEGER PRIMARY KEY AUTOINCREMENT,";


    private static final String SQL_CREATE_CLASSES =
            "CREATE TABLE " + StudentInformationContract.ClassInformation.TABLE_NAME + " (" +
                    StudentInformationContract.ClassInformation._ID + INT_PRIMARY_KEY +
                    StudentInformationContract.ClassInformation.COLUMN_COURSE_NAME + TEXT_TYPE + COMMA_SEP +
                    StudentInformationContract.ClassInformation.COLUMN_COURSE_ID + INT_TYPE + COMMA_SEP +
                    StudentInformationContract.ClassInformation.COLUMN_START_TIME + TEXT_TYPE + COMMA_SEP +
                    StudentInformationContract.ClassInformation.COLUMN_END_TIME + TEXT_TYPE + ")";


    public static synchronized StudentInformationDBHelper getInstance(Context context) {
        if (instance == null) {
            instance= new StudentInformationDBHelper(context.getApplicationContext());
        }
        return instance;
    }
    private StudentInformationDBHelper(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CLASSES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}