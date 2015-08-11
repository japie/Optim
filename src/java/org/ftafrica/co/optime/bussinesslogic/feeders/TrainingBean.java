/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.bussinesslogic.feeders;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftafrica.co.optime.Helper.training.EmployeeTraining;
import org.ftafrica.co.optime.Helper.training.MainTraining;
import org.ftafrica.co.optime.Helper.training.Qualification;
import org.ftafrica.co.optime.model.Course;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Roles;

import org.ftafrica.co.optime.model.TrainingPlan;

/**
 *
 * @author Training 8
 */
@Stateless
public class TrainingBean {
    
    @PersistenceContext
    EntityManager em;
    
    public List<MainTraining> GenerateTrainingPlanObject(String Project) {
        List<String> DistinctRoles = GetDistinctRolesFromTeams(Project);
        List<MainTraining> TrainingPlanList = new ArrayList();
        for (String dr : DistinctRoles) {
            MainTraining mainTraining = new MainTraining();
            List<Employees> TeamEmployees = GetEmployeesFromTeams(Project,dr);// find all from teams with given projId and roleId
            List<EmployeeTraining> EmployeesInTrainingList = new ArrayList();
            for (Employees te : TeamEmployees) {
                List<Qualification> qualificationList = new ArrayList();//list that contains qualification class
                EmployeeTraining employeeTraining = new EmployeeTraining();
                List<Course> courses = em.createNamedQuery("Course.findByRoleId").setParameter("roleId", dr).getResultList();// find courses from course using roleid;
                for (Course c : courses) {
                    /*add qualification class t */
                    Qualification qualification = new Qualification();
                    TrainingPlan SingleTrainingPlan = new TrainingPlan();
                    try{
                     SingleTrainingPlan = em.createNamedQuery("TrainingPlan.findSingleResult", TrainingPlan.class).setParameter("empId", te.getEmployeeId()).setParameter("course", c.getCoursesId()).setParameter("roleId", dr).getSingleResult();//get single reuslt from training plan using empId,courseId and Role Id
                    }
                    catch(Exception e){}
                    if(SingleTrainingPlan != null){
                    
                    qualification.setQualificationTitle(SingleTrainingPlan.getCourseName());
                    qualification.setQualificationStatus(SingleTrainingPlan.getStatus());
                    qualificationList.add(qualification);
                    }
                }
                
                employeeTraining.setName(te.getName());
                employeeTraining.setSurname(te.getSurname());
                employeeTraining.setUserId(te.getEmployeeId());
                employeeTraining.setQualificationsList(qualificationList);
                EmployeesInTrainingList.add(employeeTraining);
            }
            
            Roles role = em.find(Roles.class, dr);
            mainTraining.setRole(role.getRole());
            mainTraining.setEmployeeTrainingInfoList(EmployeesInTrainingList);
            TrainingPlanList.add(mainTraining);
        }
        
        return TrainingPlanList;
        
    }
    
    private List<String> GetDistinctRolesFromTeams(String Project) {
        
        
        List<String> tpList = em.createNamedQuery("TrainingPlan.findDistinctRoles").getResultList();
        
       List<String> teamRoleList =  em.createNamedQuery("Teams.findRolesByProjID").setParameter("proj", Project).getResultList();
       List<String> tpAndTeamRoleList = new ArrayList<>(teamRoleList);
       for(String trl:teamRoleList){
       
         int tp_index =  tpList.indexOf(trl);
        // int trl_index = teamRoleList.indexOf(trl);
         if(tp_index == -1){
         
         tpAndTeamRoleList.remove(trl);
         
         }
       
       }
     
     return tpAndTeamRoleList;
        
    }
     private List<Employees> GetEmployeesFromTeams(String Project, String RoleId) {
        
        
        List<Employees>  teamRoleList= em.createNamedQuery("Teams.findRolesByProjIdAndRole").setParameter("proj", Project).setParameter("roleId", RoleId).getResultList();
        
       List<Employees> tpList =  em.createNamedQuery("TrainingPlan.findAllEmployees").getResultList();
       List<Employees> tpAndTeamRoleList = new ArrayList<>(teamRoleList);
       for(Employees trl:teamRoleList){
       
         int tp_index =  tpList.indexOf(trl);
        // int trl_index = teamRoleList.indexOf(trl);
         if(tp_index == -1){
         
         tpAndTeamRoleList.remove(trl);
         
         }
       
       }
     
     return tpAndTeamRoleList;
        
    }
    
}

