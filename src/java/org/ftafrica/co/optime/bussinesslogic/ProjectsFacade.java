/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.bussinesslogic;

import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftafrica.co.optime.Helper.projects.Project;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Projects;
import java.util.List;
import org.ftafrica.co.optime.Helper.projects.ProjectTeam;
import org.ftafrica.co.optime.model.Teams;

/**
 *
 * @author Training 8
 */

@Stateless
public class ProjectsFacade extends AbstractFacade<Projects> {
    @PersistenceContext(unitName = "OptimPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjectsFacade() {
        super(Projects.class);
    }
    public Project getProjectProfile(String ProjectId){
        
    //Project(String projectId, String ProjectName, String Capacity, String ProjectPlanedCost, String ActualProjectCost, Date StartDate, Date EndDate, String ProjectTeamName, String Status, String ProjectManager) {
     
           Projects projects =  em.find(Projects.class, ProjectId);
           
           Date DateStartDate =projects.getStartdate();
           Date DateEndDate = projects.getEnddate();
         int day = DateEndDate.getDate();
         int month =DateEndDate.getMonth();
         int year = DateEndDate.getYear()+1900;
         int sday = DateStartDate.getDate();
         int smonth =DateStartDate.getMonth();
         int syear = DateStartDate.getYear()+1900;
         String EndDate= day+"-"+month+"-"+year;
         String StartDate= sday+"-"+smonth+"-"+syear;
           List<ProjectTeam> TeamMemberList= new ArrayList(); 
           List<Teams> TeamList = em.createNamedQuery("Teams.findByProjID2").setParameter("projId", ProjectId).getResultList();
           for(Teams emplo:TeamList){
               ProjectTeam projectTeam = new ProjectTeam();
               projectTeam.setEmployeeID(emplo.getEmployeeid().getEmployeeId());
               projectTeam.setJobTitle(emplo.getRoleid().getRole());
               projectTeam.setNameAndSurname(emplo.getEmployeeid().getName()+" "+emplo.getEmployeeid().getSurname());
               TeamMemberList.add(projectTeam);
           }
           
           Project project = new Project(projects.getProjectid(),projects.getProjectName(),Integer.toString(TeamMemberList.size()),projects.getProjectbudget(),projects.getProjectActualExpense(),StartDate,EndDate,projects.getProjectTeam(),projects.getStatus(),em.find(Employees.class, /*projects.getProjectmanager()*/"1").getName()+" "+em.find(Employees.class, /*projects.getProjectmanager()*/"1").getSurname(),TeamMemberList);
           
                   //  Project project = new Project("1","A","a",1.00,1.00,"a","a","1","w","w");
    return project;
            
    }
    
}
