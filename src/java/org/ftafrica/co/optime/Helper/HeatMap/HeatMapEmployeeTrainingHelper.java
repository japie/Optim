/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.HeatMap;

/**
 *
 * @author Training 8
 */
public class HeatMapEmployeeTrainingHelper {
     String Name;
     String Surname;
     String EmployeeId;
     String Course;

    public HeatMapEmployeeTrainingHelper() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    @Override
    public String toString() {
        return "HeatMapEmployeeTrainingHelper{" + "Name=" + Name + ", Surname=" + Surname + ", EmployeeId=" + EmployeeId + ", Course=" + Course + '}';
    }
     
    
    
}
