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

    
    //public final String classId;
    public final String studentId;
    public final String androidId;
    public final String SecCode;
    

    public Message(String studentId, String deviceId,String secCode){
       // this.classId = classId;
        this.studentId = studentId;
        this.androidId = deviceId;
        this.SecCode = secCode;
    }
    public String getStudentID(){
        return studentId;
    }
    
    public String getDeviceID(){
        return androidId;
    }
    public String getSecurityCode(){
        return SecCode;
    }

}
