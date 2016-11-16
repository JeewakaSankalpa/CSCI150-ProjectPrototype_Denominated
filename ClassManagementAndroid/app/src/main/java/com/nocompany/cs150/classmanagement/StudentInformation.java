package com.nocompany.cs150.classmanagement;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Navjeet on 10/22/2016.
 */
//The api for accessing shared preference data about the student.
public class StudentInformation {
    public static String[] getStoredClassList(Context appContext){
        SharedPreferences sharedPref = appContext.getSharedPreferences(Constants.SHARED_PREFERENCE_KEY_FILE, Context.MODE_PRIVATE);
        Set<String> classList = sharedPref.getStringSet(Constants.STUDENT_CLASS_ENROLLMENT_PREFERENCE,(Set<String>) new HashSet<String>());
        return classList.toArray(new String[classList.size()]);
    }

    public static boolean storedIdIsValid(Context appContext) {
        String studentId = getStoredId(appContext);
        return (studentId != null) && studentIdIsValid(appContext,studentId);
    }

    public static boolean studentIdIsValid(Context appContext, String studentId) {
        final String idPattern = "[0-9]{" + Integer.toString(appContext.getResources().getInteger(R.integer.maxStudentIdLength)) + "}";
        return studentId.matches(idPattern);
    }

    public static boolean idIsSet(Context appContext) {
        return getStoredId(appContext) != null;
    }

    public static String getStoredId(Context appContext) {
        SharedPreferences sharedPref = appContext.getSharedPreferences(Constants.SHARED_PREFERENCE_KEY_FILE, Context.MODE_PRIVATE);
        return sharedPref.getString(Constants.STUDENT_ID_PREFERENCE, null);
    }
}
