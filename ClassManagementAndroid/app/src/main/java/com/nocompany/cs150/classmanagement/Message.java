package com.nocompany.cs150.classmanagement;

public class Message {

    public final String studentId;
    public final String androidId;
    public final String SecCode;
    public Message(String SecCode, String studentId, String deviceId){
        this.SecCode = SecCode;
        this.studentId = studentId;
        this.androidId = deviceId;
    }
}