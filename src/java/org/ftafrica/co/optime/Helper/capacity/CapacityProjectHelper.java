/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.capacity;

import java.util.Date;

/**
 *
 * @author Training 10
 */
public class CapacityProjectHelper {
    
    String ProjectID;
    String ProjectName;
    String Capacity;
    String Processes;
    Date StartDate;
    Date EndDate;
    long ProjectPhases;

    public String getProjectID() {
        return ProjectID;
    }

    public void setProjectID(String ProjectID) {
        this.ProjectID = ProjectID;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String Capacity) {
        this.Capacity = Capacity;
    }

    public String getProcesses() {
        return Processes;
    }

    public void setProcesses(String Processes) {
        this.Processes = Processes;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public long getProjectPhases() {
        return ProjectPhases;
    }

    public void setProjectPhases(long ProjectPhases) {
        this.ProjectPhases = ProjectPhases;
    }

    public CapacityProjectHelper() {
    }
}
