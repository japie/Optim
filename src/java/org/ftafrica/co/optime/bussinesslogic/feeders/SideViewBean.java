/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.bussinesslogic.feeders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.ftafrica.co.optime.Helper.HeatMap.sideview.MainSideView;
import org.ftafrica.co.optime.Helper.HeatMap.sideview.SideViewProjects;
import org.ftafrica.co.optime.Helper.HeatMap.sideview.SideViewSuccession;
import org.ftafrica.co.optime.Helper.Succesion.SuccessorData;
import org.ftafrica.co.optime.Helper.Succesion.recomendationengine.SuccessionRecommendation;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Projects;
import org.ftafrica.co.optime.model.Roles;
import org.ftafrica.co.optime.model.Task1A;
import org.ftafrica.co.optime.model.Teams;
import org.ftafrica.co.optime.model.Work;

/**
 *
 * @author Training 8
 */
@Stateless
public class SideViewBean {
    @PersistenceContext
    EntityManager em;
    SuccessionBean sb; 
    int count = 0;

    public SideViewBean() {
        this.sb = new SuccessionBean();
    }
    
    private List<Employees> GetSuccessors(String EmpId){
    return em.createNamedQuery("Succession.findByPre2").setParameter("empId", EmpId).getResultList(); // get successors from Suc pplan using Id
    }
    private List<String> GetProjects(String EmpId){
    //  em.createNamedQuery("Teams.findProjByEmployeeId").setParameter("empId", EmpId).get
     System.out.println(em.createNamedQuery("Teams.findProjByEmployeeId").setParameter("empId",EmpId).getResultList());
     return em.createNamedQuery("Teams.findProjByEmployeeId").setParameter("empId",EmpId).getResultList(); // get Projects from teams where userId
           }
    private String GetEmployeeRole(String EmpId){
       Work EmpWork = em.createNamedQuery("Work.findByWorkEmpId",Work.class).setParameter("id", EmpId).getSingleResult(); // get info from work using empId
      
    return EmpWork.getPosition();
    }
    
    private String GetUsage(String EmpId){
   
      
     double percentage = 0.0;
     List<String> projects = GetProjects(EmpId);
     Projects pj = null;
     Work  EmpWork = null; 
      double util=0.0;
      double util2 =0.0;
     String pos=null;String projy = null;
        for (String project : projects) {
            pj = (Projects) em.createNamedQuery("Projects.findByProjectName").setParameter("projectName", project).getSingleResult();
            //System.out.println(pj.getProjectid());
            projy = pj.getProjectid();
            EmpWork = em.createNamedQuery("Work.findByWorkEmpId",Work.class).setParameter("id", EmpId).getSingleResult(); // get info from work using empId
             pos = EmpWork.getPosition();
            
        }
        
         if("Head of GMT".equals(pos))
         {}else{
            
             Task1A md = (Task1A) em.createNamedQuery("Task1A.findByPPj").setParameter("phase", pos).setParameter("projid", projy).getSingleResult();
              double amd = Double.parseDouble(md.getEstimatemandays());
              if(Integer.parseInt(md.getNumberofEmployees())==1){
               util = (amd/251)*100; //overall utilization for individual person
              //System.out.println(util);
              }else{
                  double mday = (amd/Double.parseDouble(md.getNumberofEmployees()));
                  
                   util2 = (mday/251)*100;//abstracting individual utilization from a team
                   util = Math.rint(util2);
                  //System.out.println(util);
              }
              
         }
            
    return String.valueOf(Math.rint(util));
    }
   
    
 
    public MainSideView GenarateHeatMapSideView(String EmployeeId){
    Employees employee = em.find(Employees.class , EmployeeId);
    MainSideView mainSideView = new MainSideView();
    
    //GetUsage(EmployeeId);
  
    List<SideViewProjects> ProjectList = new ArrayList();
    List<SideViewSuccession> SuccessorsList = new ArrayList();
    
   List<String> projects = GetProjects(EmployeeId);
    
   List<Employees> successors = GetSuccessors(EmployeeId);
   for(String p:projects){
       SideViewProjects sideViewProjects = new SideViewProjects();
       
   sideViewProjects.setName(p);
   sideViewProjects.setUtilization(Double.parseDouble(GetUsage(EmployeeId)));
   ProjectList.add(sideViewProjects);
   
   }
   
   
   // (^) this guy's successor (v) is down here...
   for(Employees e: successors){
      SideViewSuccession sideViewSuccession = new SideViewSuccession();
      
     // sideViewSuccession.setName(e.getName());
     // sideViewSuccession.setSurname(e.getSurname());
     // sideViewSuccession.setSkillMatch(Double.parseDouble(GetSuccessor(EmployeeId)));
     // sideViewSuccession.setEmployeeId(e.getEmployeeId());
     // SuccessorsList.add(sideViewSuccession);

   }
   mainSideView.setName(employee.getName());
   mainSideView.setSurname(employee.getSurname());
   mainSideView.setEmployeeId(EmployeeId);
   mainSideView.setEmployeeSuccessors( GetSuccessor(EmployeeId));
   mainSideView.setEmployeesProjects(ProjectList);
   mainSideView.setCommentNotice("No Comment");
   mainSideView.setRole(GetEmployeeRole(EmployeeId));
    
    
    return mainSideView;
    }
    //distribute successors information to be displayed on the UI
  public List<SideViewSuccession> GetSuccessor(String empId){
      
      
     SideViewSuccession successorData = new SideViewSuccession();    
     List<SideViewSuccession> SuccessorsList = new ArrayList(); 
     SuccessionRecommendation sucRec = new SuccessionRecommendation();
      
      
      
      try{
        
   List<SideViewSuccession> succDataList = SuggestSuccessor(sucRec.MakeRecommendation(Long.valueOf(empId),1));
     
    for(SideViewSuccession sd: succDataList){
         Employees emp = em.find(Employees.class,sd.getEmployeeId());
         
      //System.out.println("Successor's name: "+emp.getName()+">>>"+);
      successorData.setName(emp.getName());
      successorData.setSurname( emp.getSurname());
      successorData.setSkillMatch(sd.getSkillMatch());
      successorData.setEmployeeId(emp.getEmployeeId());
      SuccessorsList.add(successorData);
      
    }
      }catch(Exception x){
          x.getStackTrace();
         
      }
      
      return SuccessorsList;
  }
  
    // sends request to the recommendor engine(class) to obtains possible successors for empID clicked for side view
   public List<SideViewSuccession> SuggestSuccessor(List<RecommendedItem> recItem){
       List<SideViewSuccession> sucDataList = new ArrayList();
       
       for(RecommendedItem ri: recItem){
           SideViewSuccession successorData = new SideViewSuccession();
           successorData.setEmployeeId(""+ri.getItemID());
           successorData.setSkillMatch(ri.getValue()*100);
         
           
          sucDataList.add(successorData); 
          
       }
      
   return sucDataList;
   }
    
   
}
