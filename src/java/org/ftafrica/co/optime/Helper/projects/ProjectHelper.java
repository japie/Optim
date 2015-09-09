/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.Helper.projects;

import java.util.Date;

/**
 *
 * @author Training 8
 */
public class ProjectHelper {
    
    String ProjectName;
   String Duration;
   String Notices;
   String HiredEmployees;
   Date StartDate;
   Date EndDate;
   

    public ProjectHelper() {
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public String getNotices() {
        return Notices;
    }

    public void setNotices(String Notices) {
        this.Notices = Notices;
    }

    public String getHiredEmployees() {
        return HiredEmployees;
    }

    public void setHiredEmployees(String HiredEmployees) {
        this.HiredEmployees = HiredEmployees;
    }
   
    
}


