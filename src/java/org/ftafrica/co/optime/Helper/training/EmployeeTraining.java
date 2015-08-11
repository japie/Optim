/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.Helper.training;

import java.util.List;

/**
 *
 * @author Training 8
 */
public class EmployeeTraining {
    private String Name;
    private String Surname;
    private String UserId;
    private List<Qualification> QualificationsList;

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

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public List<Qualification> getQualificationsList() {
        return QualificationsList;
    }

    public void setQualificationsList(List<Qualification> QualificationsList) {
        this.QualificationsList = QualificationsList;
    }
    
    
}
