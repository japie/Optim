/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.Helper.HeatMap.sideview;

import java.util.List;

/**
 *
 * @author Training 8
 */
public class MainSideView {
    
    private String Name;
    private String Surname;
    private String EmployeeId;
    private String Role;
    private List<SideViewProjects> EmployeesProjects;
    private List<SideViewSuccession> EmployeeSuccessors;
    private String CommentNotice;

    public MainSideView() {
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

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public List<SideViewProjects> getEmployeesProjects() {
        return EmployeesProjects;
    }

    public void setEmployeesProjects(List<SideViewProjects> EmployeesProjects) {
        this.EmployeesProjects = EmployeesProjects;
    }

    public List<SideViewSuccession> getEmployeeSuccessors() {
        return EmployeeSuccessors;
    }

    public void setEmployeeSuccessors(List<SideViewSuccession> EmployeeSuccessors) {
        this.EmployeeSuccessors = EmployeeSuccessors;
    }

    public String getCommentNotice() {
        return CommentNotice;
    }

    public void setCommentNotice(String CommentNotice) {
        this.CommentNotice = CommentNotice;
    }
    
    
    
    
}
