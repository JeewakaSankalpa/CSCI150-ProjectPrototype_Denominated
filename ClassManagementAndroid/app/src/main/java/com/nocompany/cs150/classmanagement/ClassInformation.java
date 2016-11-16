package com.nocompany.cs150.classmanagement;

/**
 * Created by Navjeet on 10/22/2016.
 */

public class ClassInformation {
    private static final String SPLIT_DELIMITER="\\|";
    private static final String DELIMITER = "|";
    public final String className;
    public final String classId;
    public final String startTime;
    public final String endTime;

    public static String prepForStorage(String className, String classId, String startTime, String endTime){
        return className + DELIMITER + classId + DELIMITER + startTime + DELIMITER + endTime;
    }
    public ClassInformation(String className, String classId, String startTime, String endTime) {
        this.className = className;
        this.classId = classId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //Making a lot of assumptions about the string format.
    public ClassInformation(String classInfo){
        String[] classInfoTokens = classInfo.split(SPLIT_DELIMITER);
        for(int i = 0; i < classInfoTokens.length; i++)
            System.out.println(classInfoTokens[i]);
        assert(classInfoTokens.length == 4); //One assumption is that there are only 4 tokens.
        this.className = classInfoTokens[0];
        this.classId = classInfoTokens[1];
        this.startTime = classInfoTokens[2];
        this.endTime = classInfoTokens[3];
    }
}
