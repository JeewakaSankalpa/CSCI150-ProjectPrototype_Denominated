/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_management;

/**
 *
 * @author carlos
 */
//import com.mysql.fabric.jdbc;
import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Nadun
 */
public class DBClass {

    /**
* Connect to database
* @return Connection to database
* @throws java.lang.Exception
*/
    public java.sql.Connection getdbConnection()throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String myDB ="jdbc:mysql://localhost:3306/ClassManager?autoReconnect=true&useSSL=false";
        return DriverManager.getConnection(myDB,"root","root");
    }

/**
* This method will load vector of vector of string and load all the data in
* the vector
* @return vector of vector of string
* @throws java.lang.Exception
*/
    public Vector getFaculty()throws Exception
    {
        Vector<Vector<String>> facVector = new Vector<Vector<String>>();

        Connection conn = (Connection) getdbConnection();
        PreparedStatement pre = conn.prepareStatement("select * from Faculty");

        ResultSet rs = pre.executeQuery();

        while(rs.next())
        {
            Vector<String> fac = new Vector<String>();
            fac.add(rs.getString(1)); //ID
            fac.add(rs.getString(2)); //first name
            fac.add(rs.getString(3)); //last name
            fac.add(rs.getString(4)); //MI
            fac.add(rs.getString(5)); //address1
            
            fac.add(rs.getString(6)); //Mobile
            fac.add(rs.getString(7)); //accessLevel
            //fac.add(rs.getString(8)); //Pass
            facVector.add(fac);
        }

        /*Close the connection after use (MUST)*/
        if(conn!=null)
            conn.close();

        return facVector;
    }

}
    public Vector getStudent()throws Exception
    {
        Vector<Vector<String>> studVector = new Vector<Vector<String>>();

        Connection conn = dbConnection();
        PreparedStatement pre = conn.prepareStatement("select * from faculty");

        ResultSet rs = pre.executeQuery();

        while(rs.next())
        {
            Vector<String> stud = new Vector<String>();
            stud.add(rs.getString(1)); //ID
            stud.add(rs.getString(2)); //first name
            stud.add(rs.getString(3)); //last name
            stud.add(rs.getString(4)); //MI
            stud.add(rs.getString(5)); //address 1
            stud.add(rs.getString(6)); //address 2
            stud.add(rs.getString(7)); //Mobile #
            studVector.add(stud);
        }

        /*Close the connection after use (MUST)*/
        if(conn!=null)
            conn.close();

        return studVector;
    }
