package com.nocompany.cs150.classmanagement.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Navjeet on 10/26/2016.
 */
//Provides an api to store student related information so queries aren't littered throughout.
//Will replace the shared preference oriented storage (besides id).
public class StudentInformation2 {
    private final Context appContext;
    SQLiteOpenHelper dbHelper;

    public StudentInformation2(Context context){
        this.appContext = context;
        this.dbHelper = StudentInformationDBHelper.getInstance(context);
    }

    //Writes new class or updates existing record if recordId is not -1
    public void writeClass(Long recordId,String className, int classId){
        SQLiteDatabase writer = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(StudentInformationContract.ClassInformation.COLUMN_COURSE_NAME,className);
        values.put(StudentInformationContract.ClassInformation.COLUMN_COURSE_ID,classId);
        if(recordId >= 0){
            int i = writer.update(StudentInformationContract.ClassInformation.TABLE_NAME,values, StudentInformationContract.ClassInformation._ID + "=" + recordId,null);
            System.out.println("Does this even get called?");
            System.out.println("update return value " + i);
            System.out.println("attempted id: " + recordId);
        } else {
            writer.insert(StudentInformationContract.ClassInformation.TABLE_NAME, null, values);
        }
    }
    public Cursor readClassList(){
        SQLiteDatabase reader = dbHelper.getReadableDatabase();
        Cursor c = reader.rawQuery("select * from " + StudentInformationContract.ClassInformation.TABLE_NAME,null);
        return c;
    }
}