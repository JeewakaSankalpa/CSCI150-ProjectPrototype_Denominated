package com.nocompany.cs150.classmanagement;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.nocompany.cs150.classmanagement.db.ClassEnrollmentCursorAdapter;
import com.nocompany.cs150.classmanagement.db.StudentInformation2;

public class ActivityEnrolledClasses extends AppCompatActivity {
    private StudentInformation2 db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrolled_classes);
        db = new StudentInformation2(getApplicationContext());
        ListView enrolledClassesView = (ListView) findViewById(R.id.enrolledClassesListView);
        //Note: the list item view form is class_enrollment_list_view_item.xml
        enrolledClassesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                promptForClassInfo(editClassEntryDialog(view));

            }
        });
        ((Button) findViewById(R.id.addClass)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptForClassInfo(defaultClassEntryDialog());
            }
        });
        updateListView();
    }


    //Too simple? Just reduce to argument in function call?
    private View defaultClassEntryDialog() {
        LayoutInflater inflater = this.getLayoutInflater();
        return inflater.inflate(R.layout.class_entry_dialog, null);
    }

    private View editClassEntryDialog(View listItem) {
        //Get the empty default view
        View classEntryDialog = defaultClassEntryDialog();
        //Get existing data from listItem
        String recordId = ((TextView) listItem.findViewById(R.id.classTable_id)).getText().toString();
        String className = ((TextView) listItem.findViewById(R.id.classNameListItemComponent)).getText().toString();
        String classId = ((TextView) listItem.findViewById(R.id.classIdListItemComponent)).getText().toString();

        ((TextView) classEntryDialog.findViewById(R.id.classTable_id)).setText(recordId);
        ((EditText) classEntryDialog.findViewById(R.id.classNameEditText)).setText(className);
        ((EditText) classEntryDialog.findViewById(R.id.classIdEditText)).setText(classId);
        return classEntryDialog;

    }

    private void promptForClassInfo(final View alertDialogView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.classEntryDialogTitle);
        builder.setView(alertDialogView);
        //There is no validation on these fields yet, any strings will work.  For right now, if any
        //field is blank, it will crash.
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //If this is a new entry and not an edit of an existing class, then the hidden record id field will be empty.
                final long NO_RECORD_ID_EXISTS = -1;
                TextView recordIdText = (TextView) alertDialogView.findViewById(R.id.classTable_id);
                long recordId;
                if (recordIdText.getText().length() == 0) {
                    recordId = NO_RECORD_ID_EXISTS;
                } else {
                    recordId = Integer.parseInt(recordIdText.getText().toString());
                }
                String className = ((EditText) alertDialogView.findViewById(R.id.classNameEditText)).getText().toString();
                int classId = Integer.parseInt(((EditText) alertDialogView.findViewById(R.id.classIdEditText)).getText().toString());
                db.writeClass(recordId, className, classId);
                updateListView();
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    //Updates the list of classes to reflect newly entered classes.
    private void updateListView() {
        ListView classListView = (ListView) this.findViewById(R.id.enrolledClassesListView);
        Cursor classListCursor = db.readClassList();
        classListView.setAdapter(new ClassEnrollmentCursorAdapter(getApplicationContext(), classListCursor));
    }
}