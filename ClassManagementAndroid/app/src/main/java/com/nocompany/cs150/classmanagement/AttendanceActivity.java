package com.nocompany.cs150.classmanagement;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.HashMap;

public class AttendanceActivity extends AppCompatActivity {
    private MqttHandler mqtt;
    private String ip = "";
    private final int CLASS_ENROLLMENT_REQUEST = 1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //This is only for debugging. This and all method calls to it should be removed later.
    //It clears the student data in shared preferences since otherwise it persists across builds.
    public void clear() {
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(Constants.SHARED_PREFERENCE_KEY_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.commit();
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //clear();
        setContentView(R.layout.activity_attendance);
        Button sendAttendanceButton = (Button) findViewById(R.id.sendAttendanceButton);
        final Spinner classListSpinner = (Spinner) findViewById(R.id.classListSpinner);
        final EditText secCode = (EditText) findViewById(R.id.txtSecurityCode);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.classids, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        classListSpinner.setAdapter(adapter);
        Button viewAttendanceRecords = (Button) findViewById(R.id.viewAllAttendanceRecordsButton);
        sendAttendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //replace true with isValidData()
                if (true) {
                    String deviceId = Settings.Secure.ANDROID_ID;
                    String studentId = StudentInformation.getStoredId(getApplicationContext());
                    String classId = (String) classListSpinner.getSelectedItem();
                    String Sec = secCode.getText().toString();
                    /***********************************


                        Need to get the current class
                     // get the user to select the class from the Sminner or make a popup and ask to input


                    ************************************/
                    Message m = new Message(Sec, studentId, deviceId);
                    mqtt.publish(m,classId);
                    //MQTT Stuff Goes Here, use above 2 variables and spinner item
                    Toast.makeText(getApplicationContext(), "Attendance Sent Successfully", Toast.LENGTH_SHORT).show();
                } else {
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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onStart() {
        super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();

        if (!StudentInformation.idIsSet(getApplicationContext()))
            promptForId();
        promptForIp();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
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
                startActivityForResult(getEnrolledClassesIntent, CLASS_ENROLLMENT_REQUEST);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    private boolean isValidData() {
        Spinner classListSpinner = (Spinner) findViewById(R.id.classListSpinner);
        boolean classChosen = classListSpinner.getSelectedItem() != null;
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
                        if (StudentInformation.studentIdIsValid(getApplicationContext(), pendingId)) {
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
                        mqtt=MqttHandler.getInstance(getApplicationContext());
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
                        try

                        {
                            mqtt.connect(mqttActionListener, ip);
                        }

                        catch( MqttException e)

                        {
                            e.printStackTrace();
                        }
                        idAlert.dismiss();

                    }
                });
            }


        });
        idAlert.show();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Attendance Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
