package com.nocompany.cs150.classmanagement;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by Navjeet on 11/7/2016.
 */

public class AttendanceRecordsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //clear();
        setContentView(R.layout.full_attendance_records);
        CalendarView calendarView = (CalendarView) findViewById(R.id.attendanceCalendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //Temporary toast.  Should use database instance to pull all records associated
                //with this day, and then display them
                Toast.makeText(getApplicationContext(), (month + 1) + "/"+dayOfMonth + "/" + year, Toast.LENGTH_SHORT).show();
                createAttendanceRecordView();
            }
        });
        /*
        Should get these dates from database to be dynamic, though you can probably infer
        the min and max based on the current month, since the starting and ending months of a
        semester are likely to be constant, at least for CSU Fresno
        calendar.setMinDate();
        calendar.setMaxDate();
        */


    }
    private void createAttendanceRecordView(){
        LayoutInflater inflater = this.getLayoutInflater();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogLayout = inflater.inflate(R.layout.attendance_day_record,null);
        LinearLayout parentLayout = (LinearLayout) dialogLayout.findViewById(R.id.classRecordContainer);
        for(int i = 0; i < 3; i++){
            View classRecordLayout = inflater.inflate(R.layout.attendance_class_record,null);
            ((TextView) classRecordLayout.findViewById(R.id.classNameTextView)).setText("SampleText");
            parentLayout.addView(classRecordLayout);
        }
        builder.setTitle("Record for blah day, will fix later.");
        builder.setView(dialogLayout);
        builder.create().show();
    }
}
