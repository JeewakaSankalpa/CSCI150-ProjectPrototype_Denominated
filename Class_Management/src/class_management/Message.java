/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_management;

/**
 *
 * @author Jeewaka
 */
public class Message {

    
    public final String classId;
    public final String studentId;
    public final String androidId;
    public final String SecurityCode;
    

    public Message(String classId, String studentId, String deviceId,String securityCode){
        this.classId = classId;
        this.studentId = studentId;
        this.androidId = deviceId;
        this.SecurityCode = securityCode;
    }
    public String getStudentID(){
        return studentId;
    }
    public String getClassID(){
        return classId;
    }
    public String getDeviceID(){
        return androidId;
    }
    public String getSecurityCode(){
        return SecurityCode;
    }

}
