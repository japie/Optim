/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.capacity;

/**
 *
 * @author Training 10
 */
public class CapacityEmployeesHelper {
    String Name;
    String Surnamme;
    String EmployeeId;
    String Role;

    public CapacityEmployeesHelper() {
    }
    public String getName() {
        return Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getSurnamme() {
        return Surnamme;
    }

    public void setSurnamme(String Surnamme) {
        this.Surnamme = Surnamme;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
}