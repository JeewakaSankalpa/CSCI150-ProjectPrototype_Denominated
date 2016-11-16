package com.nocompany.cs150.classmanagement;

public class Message {
    public final String classId;
    public final String studentId;
    public final String androidId;

    public Message(String classId, String studentId, String deviceId){
        this.classId = classId;
        this.studentId = studentId;
        this.androidId = deviceId;
    }
}