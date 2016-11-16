/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_management;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author jeewaka
 */
@Entity
@Table(name = "Faculty", catalog = "ClassManager", schema = "")
@NamedQueries({
    @NamedQuery(name = "Faculty_1.findAll", query = "SELECT f FROM Faculty_1 f"),
    @NamedQuery(name = "Faculty_1.findByFacultyID", query = "SELECT f FROM Faculty_1 f WHERE f.facultyID = :facultyID"),
    @NamedQuery(name = "Faculty_1.findByFacultyFirstName", query = "SELECT f FROM Faculty_1 f WHERE f.facultyFirstName = :facultyFirstName"),
    @NamedQuery(name = "Faculty_1.findByFacultyLastName", query = "SELECT f FROM Faculty_1 f WHERE f.facultyLastName = :facultyLastName"),
    @NamedQuery(name = "Faculty_1.findByFacultyMiddleInitial", query = "SELECT f FROM Faculty_1 f WHERE f.facultyMiddleInitial = :facultyMiddleInitial"),
    @NamedQuery(name = "Faculty_1.findByStudentAddress1", query = "SELECT f FROM Faculty_1 f WHERE f.studentAddress1 = :studentAddress1"),
    @NamedQuery(name = "Faculty_1.findByFacultyAddress2", query = "SELECT f FROM Faculty_1 f WHERE f.facultyAddress2 = :facultyAddress2"),
    @NamedQuery(name = "Faculty_1.findByFacultyMobileNo", query = "SELECT f FROM Faculty_1 f WHERE f.facultyMobileNo = :facultyMobileNo"),
    @NamedQuery(name = "Faculty_1.findByAcessLevel", query = "SELECT f FROM Faculty_1 f WHERE f.acessLevel = :acessLevel"),
    @NamedQuery(name = "Faculty_1.findByPassword", query = "SELECT f FROM Faculty_1 f WHERE f.password = :password")})
public class Faculty_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Faculty_ID")
    private Integer facultyID;
    @Column(name = "Faculty_First_Name")
    private String facultyFirstName;
    @Column(name = "Faculty_Last_Name")
    private String facultyLastName;
    @Column(name = "Faculty_Middle_Initial")
    private String facultyMiddleInitial;
    @Column(name = "Student_Address_1")
    private String studentAddress1;
    @Column(name = "Faculty_Address_2")
    private String facultyAddress2;
    @Column(name = "Faculty_Mobile_No")
    private String facultyMobileNo;
    @Column(name = "AcessLevel")
    private String acessLevel;
    @Column(name = "Password")
    private String password;

    public Faculty_1() {
    }

    public Faculty_1(Integer facultyID) {
        this.facultyID = facultyID;
    }

    public Integer getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Integer facultyID) {
        Integer oldFacultyID = this.facultyID;
        this.facultyID = facultyID;
        changeSupport.firePropertyChange("facultyID", oldFacultyID, facultyID);
    }

    public String getFacultyFirstName() {
        return facultyFirstName;
    }

    public void setFacultyFirstName(String facultyFirstName) {
        String oldFacultyFirstName = this.facultyFirstName;
        this.facultyFirstName = facultyFirstName;
        changeSupport.firePropertyChange("facultyFirstName", oldFacultyFirstName, facultyFirstName);
    }

    public String getFacultyLastName() {
        return facultyLastName;
    }

    public void setFacultyLastName(String facultyLastName) {
        String oldFacultyLastName = this.facultyLastName;
        this.facultyLastName = facultyLastName;
        changeSupport.firePropertyChange("facultyLastName", oldFacultyLastName, facultyLastName);
    }

    public String getFacultyMiddleInitial() {
        return facultyMiddleInitial;
    }

    public void setFacultyMiddleInitial(String facultyMiddleInitial) {
        String oldFacultyMiddleInitial = this.facultyMiddleInitial;
        this.facultyMiddleInitial = facultyMiddleInitial;
        changeSupport.firePropertyChange("facultyMiddleInitial", oldFacultyMiddleInitial, facultyMiddleInitial);
    }

    public String getStudentAddress1() {
        return studentAddress1;
    }

    public void setStudentAddress1(String studentAddress1) {
        String oldStudentAddress1 = this.studentAddress1;
        this.studentAddress1 = studentAddress1;
        changeSupport.firePropertyChange("studentAddress1", oldStudentAddress1, studentAddress1);
    }

    public String getFacultyAddress2() {
        return facultyAddress2;
    }

    public void setFacultyAddress2(String facultyAddress2) {
        String oldFacultyAddress2 = this.facultyAddress2;
        this.facultyAddress2 = facultyAddress2;
        changeSupport.firePropertyChange("facultyAddress2", oldFacultyAddress2, facultyAddress2);
    }

    public String getFacultyMobileNo() {
        return facultyMobileNo;
    }

    public void setFacultyMobileNo(String facultyMobileNo) {
        String oldFacultyMobileNo = this.facultyMobileNo;
        this.facultyMobileNo = facultyMobileNo;
        changeSupport.firePropertyChange("facultyMobileNo", oldFacultyMobileNo, facultyMobileNo);
    }

    public String getAcessLevel() {
        return acessLevel;
    }

    public void setAcessLevel(String acessLevel) {
        String oldAcessLevel = this.acessLevel;
        this.acessLevel = acessLevel;
        changeSupport.firePropertyChange("acessLevel", oldAcessLevel, acessLevel);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facultyID != null ? facultyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty_1)) {
            return false;
        }
        Faculty_1 other = (Faculty_1) object;
        if ((this.facultyID == null && other.facultyID != null) || (this.facultyID != null && !this.facultyID.equals(other.facultyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "class_management.Faculty_1[ facultyID=" + facultyID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
