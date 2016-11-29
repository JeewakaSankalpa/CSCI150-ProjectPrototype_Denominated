package com.nocompany.cs150.classmanagement;

public class Message {

    public final String studentId;
    public final String androidId;
    public final String SecCode;

    public Message(String studentId, String deviceId, String attendanceCode){

        this.studentId = studentId;
        this.androidId = deviceId;
        this.SecCode = attendanceCode;
    }
}