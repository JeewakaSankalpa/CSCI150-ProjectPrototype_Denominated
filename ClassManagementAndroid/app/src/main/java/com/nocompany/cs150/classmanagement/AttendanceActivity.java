package com.nocompany.cs150.classmanagement;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nocompany.cs150.classmanagement.db.StudentInformation2;
import com.nocompany.cs150.classmanagement.db.StudentInformationContract;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.ArrayList;
import java.util.HashMap;

public class AttendanceActivity extends AppCompatActivity {
    private StudentInformation2 db;
    private MqttHandler mqtt;
    private HashMap<String,String> classToIdMap;
    private final int CLASS_ENROLLMENT_REQUEST = 1;
    String ip ="";
    IMqttActionListener mqttActionListener = new IMqttActionListener() {
        @Override
        public void onSuccess(IMqttToken iMqttToken) {
            Toast.makeText(getApplicationContext(), "mqtt Connection successfull",
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public void onFailure(IMqttToken iMqttToken, Throwable throwable) {
            Toast.makeText(getApplicationContext(), "mqtt conection failed",
                    Toast.LENGTH_LONG).show();
        }
    };
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.db = new StudentInformation2(getApplicationContext());
        mqtt = MqttHandler.getInstance(getApplicationContext());
        this.classToIdMap = new HashMap<String,String>();
        setContentView(R.layout.activity_attendance);
        Button sendAttendanceButton = (Button) findViewById(R.id.sendAttendanceButton);
        final Spinner classListSpinner = (Spinner) findViewById(R.id.classListSpinner);
        final EditText alternateClassIdEntry = (EditText) findViewById(R.id.alternateClassIdEntry);
        setSpinnerItems();
        final EditText attendanceCodeEditText = (EditText) findViewById(R.id.attendanceCodeEditText);
        Button viewAttendanceRecords = (Button) findViewById(R.id.viewAllAttendanceRecordsButton);
        sendAttendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidData()) {
                    String deviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                    String studentId = StudentInformation.getStoredId(getApplicationContext());
                    String attendanceCode = attendanceCodeEditText.getText().toString();
                    String classId = "";
                    if(alternateClassIdEntry.getText().length() != 0)
                        classId = alternateClassIdEntry.getText().toString();
                    else
                        classId = classToIdMap.get(classListSpinner.getSelectedItem().toString());
                    Message m = new Message(studentId,deviceId,attendanceCode);

                        try {
                            if (!mqtt.isConnected())
                            mqtt.connect(mqttActionListener,ip);
                        } catch (MqttException e) {
                            e.printStackTrace();
                        }
                    mqtt.publish(m,classId);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Some Necessary Value is Invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewAttendanceRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AttendanceRecordsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!StudentInformation.idIsSet(getApplicationContext()))
            promptForId();
        //The call is in on start because this is not something that was going to be necessary
        //in the ideal scenario (there would be a server with a static ip)  so it would be wasteful
        // to add functionality to change the ip address if it was incorrectly entered
        if (ip.equals(""))
        promptForIp();
        try {
            if (!mqtt.isConnected())
            mqtt.connect(mqttActionListener,ip);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.myIdMenuOption:
                promptForId();
                break;
            case R.id.viewEnrolledClasses:
                Intent getEnrolledClassesIntent = new Intent(this, ActivityEnrolledClasses.class);
                startActivityForResult(getEnrolledClassesIntent,CLASS_ENROLLMENT_REQUEST);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CLASS_ENROLLMENT_REQUEST) {
            //We don't actually want any values from the intent but we need to update the spinner
            //items on returning from the activity in case the user adds new classes
            setSpinnerItems();
        }
    }
    private boolean isValidData() {
        Spinner classListSpinner = (Spinner) findViewById(R.id.classListSpinner);
        EditText alternateClassIdEntry = (EditText) findViewById(R.id.alternateClassIdEntry);
        boolean classChosen = classListSpinner.getSelectedItem() != null
                || alternateClassIdEntry.getText().length() != 0;
        return StudentInformation.storedIdIsValid(getApplicationContext()) && classChosen;
    }


    //Opens a dialog for the user to enter their student ID.  The dialog does not go away until
    //the user enters a valid Id.
    private void promptForId() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.studentIdDialogTitle);
        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);
        //The stored Id may match the pattern but still be incorrectly entered by the user
        String storedId = StudentInformation.getStoredId(getApplicationContext());
        if (storedId != null)
            input.setText(storedId);
        builder.setPositiveButton(R.string.ok, null);
        final AlertDialog idAlert = builder.create();
        idAlert.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button dialogOkButton = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                dialogOkButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String pendingId = input.getText().toString();
                        if (StudentInformation.studentIdIsValid(getApplicationContext(),pendingId)) {
                            SharedPreferences.Editor editor = getApplicationContext().getSharedPreferences(Constants.SHARED_PREFERENCE_KEY_FILE, Context.MODE_PRIVATE).edit();
                            editor.putString(Constants.STUDENT_ID_PREFERENCE, pendingId);
                            editor.commit();
                            idAlert.dismiss();
                        } else {
                            Toast.makeText(getApplicationContext(), R.string.invalidIdToast, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        idAlert.show();
    }

    //Asks for the ip.  This is meant for testing purposes since the developers will run an mqtt broker on
    //their particular machine which have different ips.  Since we didn't get the android database connection working, it's
    //going to stay in use for the demonstration.
    private void promptForIp() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("enter ip address");
        // Set up the input
        final EditText input = new EditText(this);
        builder.setView(input);
        builder.setPositiveButton(R.string.ok, null);
        final AlertDialog idAlert = builder.create();
        idAlert.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button dialogOkButton = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                dialogOkButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ip = input.getText().toString();
                        try {
                            mqtt.connect(mqttActionListener, ip);
                        } catch (MqttException e) {
                            e.printStackTrace();
                        }
                        idAlert.dismiss();
                    }
                });
            }
        });
        idAlert.show();
    }

    public void setSpinnerItems(){
        this.classToIdMap.clear();
        Cursor c = db.readClassList();
        ArrayList<String> classList = new ArrayList<String>();
        while(c.moveToNext()){
            String className = c.getString(c.getColumnIndexOrThrow(StudentInformationContract.ClassInformation.COLUMN_COURSE_NAME));
            String classId = Integer.toString(c.getInt(c.getColumnIndexOrThrow(StudentInformationContract.ClassInformation.COLUMN_COURSE_ID)));
            classList.add(className);
            this.classToIdMap.put(className,classId);
        }
        if(!classList.isEmpty()){
            Spinner classListSpinner = (Spinner) findViewById(R.id.classListSpinner);
            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,R.layout.class_list_spinner_item, classList.toArray(new String[0]));
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            classListSpinner.setAdapter(spinnerArrayAdapter);
        }
    }
}
