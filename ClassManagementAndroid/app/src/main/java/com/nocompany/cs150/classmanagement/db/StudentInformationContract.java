
package com.nocompany.cs150.classmanagement.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Navjeet on 10/26/2016.
 */

public final class StudentInformationContract {
    //Should not be instantiated
    private StudentInformationContract(){}


    public static class ClassInformation implements BaseColumns{
        public static final String TABLE_NAME = "courses";
        public static final String COLUMN_COURSE_NAME = "course_name";
        public static final String COLUMN_COURSE_ID = "course_id";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String COLUMN_END_TIME = "end_time";
    }

    public static class AttendanceRecords implements BaseColumns{
        public static final String TABLE_NAME = "attendance_records";
        public static final String COLUMN_COURSE_RECORD_ID = "course_record_id";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_STUDENT_WAS_PRESENT = "student_was_present";
    }
}