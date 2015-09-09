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
public class CapacityPhasesHelper {
    
    String Proj_id;
    String ProjectName;
    String Phases;
    Date StartDate;
    Date EndDate;
    String EstimatedManDays;
    String ActualManDays;
    String NumberOfEmployees;

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }
    public String getProj_id() {
        return Proj_id;
    }

    public void setProj_id(String Proj_id) {
        this.Proj_id = Proj_id;
    }

    public CapacityPhasesHelper() {
    }

    public String getPhases() {
        return Phases;
    }

    public void setPhases(String Phases) {
        this.Phases = Phases;
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

    public String getEstimatedManDays() {
        return EstimatedManDays;
    }

    public void setEstimatedManDays(String EstimatedManDays) {
        this.EstimatedManDays = EstimatedManDays;
    }

    public String getActualManDays() {
        return ActualManDays;
    }

    public void setActualManDays(String ActualManDays) {
        this.ActualManDays = ActualManDays;
    }

    public String getNumberOfEmployees() {
        return NumberOfEmployees;
    }

    public void setNumberOfEmployees(String NumberOfEmployees) {
        this.NumberOfEmployees = NumberOfEmployees;
    }

    public class setNumberOfEmployees {

        public setNumberOfEmployees() {
        }
    }
   
    
}
