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
import org.ftafrica.co.optime.Helper.HeatMap.sideview.MainSideView;
import org.ftafrica.co.optime.Helper.HeatMap.sideview.SideViewProjects;
import org.ftafrica.co.optime.Helper.HeatMap.sideview.SideViewSuccession;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Work;

/**
 *
 * @author Training 8
 */
@Stateless
public class SideViewBean {
    @PersistenceContext
    EntityManager em;
    
    private List<Employees> GetSuccessors(String EmpId){
    return em.createNamedQuery("Succession.findByPre2").setParameter("empId", EmpId).getResultList(); // get successors from Suc pplan using Id
    }
    private List<String> GetProjects(String EmpId){
     return em.createNamedQuery("Teams.findProjByEmployeeId").setParameter("empId",EmpId).getResultList(); // get Projects from teams where userId
           }
    private String GetEmployeeRole(String EmpId){
       Work EmpWork = em.createNamedQuery("Work.findByWorkEmpId",Work.class).setParameter("id", EmpId).getSingleResult(); // get info from work using empId
        
    return EmpWork.getPosition();
    }
    
    public MainSideView GenarateHeatMapSideView(String EmployeeId){
    Employees employee = em.find(Employees.class , EmployeeId);
    MainSideView mainSideView = new MainSideView();
   
    
    List<SideViewProjects> ProjectList = new ArrayList();
    List<SideViewSuccession> SuccessorsList = new ArrayList();
    
   List<String> projects = GetProjects(EmployeeId);
   List<Employees> successors = GetSuccessors(EmployeeId);
   for(String p:projects){
       SideViewProjects sideViewProjects = new SideViewProjects();
       
   sideViewProjects.setName(p);
   sideViewProjects.setUtilization(30.0);
   ProjectList.add(sideViewProjects);
   
   }
   
   for(Employees e: successors){
      SideViewSuccession sideViewSuccession = new SideViewSuccession();
      
      sideViewSuccession.setName(e.getName());
      sideViewSuccession.setSurname(e.getSurname());
      sideViewSuccession.setSkillMatch(75);
      sideViewSuccession.setEmployeeId(e.getEmployeeId());
      SuccessorsList.add(sideViewSuccession);

   }
   mainSideView.setName(employee.getName());
   mainSideView.setSurname(employee.getSurname());
   mainSideView.setEmployeeId(EmployeeId);
   mainSideView.setEmployeeSuccessors(SuccessorsList);
   mainSideView.setEmployeesProjects(ProjectList);
   mainSideView.setCommentNotice("current we dont handle comments ;-)");
   mainSideView.setRole(GetEmployeeRole(EmployeeId));
    
    
    return mainSideView;
    }

    
   
}
