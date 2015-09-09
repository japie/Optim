/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.Helper.projects;

import java.util.List;

/**
 *
 * @author Training 8
 */
public class Project {
    String projectId;
    String ProjectName;
    String Capacity;
    double ProjectPlanedCost;
    double ActualProjectCost;
    String StartDate;
    String EndDate;
    String ProjectTeamName;
    String Status;
    String ProjectManager;
    List<ProjectTeam> ProjectTeamList;

    public Project(String projectId, String ProjectName, String Capacity, double ProjectPlanedCost, double ActualProjectCost, String StartDate, String EndDate, String ProjectTeamName, String Status, String ProjectManager, List<ProjectTeam> ProjectTeamList) {
        this.projectId = projectId;
        this.ProjectName = ProjectName;
        this.Capacity = Capacity;
        this.ProjectPlanedCost = ProjectPlanedCost;
        this.ActualProjectCost = ActualProjectCost;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.ProjectTeamName = ProjectTeamName;
        this.Status = Status;
        this.ProjectManager = ProjectManager;
        this.ProjectTeamList = ProjectTeamList;
    }
    

    
    
    
}
