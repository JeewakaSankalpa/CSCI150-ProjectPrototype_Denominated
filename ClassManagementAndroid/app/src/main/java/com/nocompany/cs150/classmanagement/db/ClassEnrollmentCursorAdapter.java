package com.nocompany.cs150.classmanagement.db;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.nocompany.cs150.classmanagement.R;
import com.nocompany.cs150.classmanagement.db.StudentInformationContract.ClassInformation;

/**
 * Created by Navjeet on 10/26/2016.
 */

public class ClassEnrollmentCursorAdapter extends CursorAdapter {
    public ClassEnrollmentCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.class_enrollment_list_view_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor c) {
        // Find fields to populate in inflated template
        TextView recordIdText = (TextView) view.findViewById(R.id.classTable_id);
        TextView classNameText = (TextView) view.findViewById(R.id.classNameListItemComponent);
        TextView classIdText = (TextView) view.findViewById(R.id.classIdListItemComponent);
        TextView classStartText = (TextView) view.findViewById(R.id.classStartTimeListItemComponent);
        TextView classEndText = (TextView) view.findViewById(R.id.classEndTimeListItemComponent);
        // Extract properties from cursor
        String recordId = Long.toString(c.getLong(c.getColumnIndexOrThrow(ClassInformation._ID)));
        String className = c.getString(c.getColumnIndexOrThrow(ClassInformation.COLUMN_COURSE_NAME));
        String classId = Integer.toString(c.getInt(c.getColumnIndexOrThrow(ClassInformation.COLUMN_COURSE_ID)));
        String startTime = c.getString(c.getColumnIndexOrThrow(ClassInformation.COLUMN_START_TIME));
        String endTime = c.getString(c.getColumnIndexOrThrow(ClassInformation.COLUMN_END_TIME));

        recordIdText.setText(recordId);
        classNameText.setText(className);
        classIdText.setText(classId);
        classStartText.setText(startTime);
        classEndText.setText(endTime);
    }
}