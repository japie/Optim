/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper;

/**
 *
 * @author Training 8
 */
public class CurrentUser {
    
    String Name;
    String Surname;

    public CurrentUser() {
    }

    public CurrentUser(String Name, String Surname) {
        this.Name = Name;
        this.Surname = Surname;
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

   
    
}
