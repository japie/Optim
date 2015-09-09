/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.bussinesslogic.feeders;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.ftafrica.co.optime.Helper.Succesion.SuccessionHelper;
import org.ftafrica.co.optime.Helper.Succesion.SuccessionHelperClass;
import org.ftafrica.co.optime.Helper.Succesion.SuccessorData;
import org.ftafrica.co.optime.Helper.Succesion.SuccessorMainData;
import org.ftafrica.co.optime.Helper.Succesion.SuccessorMainDataObject;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Projects;
import org.ftafrica.co.optime.model.Roles;
import org.ftafrica.co.optime.model.Teams;
import org.ftafrica.co.optime.model.Work;
import org.ftafrica.co.optime.Helper.Succesion.recomendationengine.SuccessionRecommendation;
import org.ftafrica.co.optime.model.Education;
import org.ftafrica.co.optime.model.Recommendationdata;


/**
 *
 * @author Training 8
 */
@Stateless
public class SuccessionBean {

    @PersistenceContext
    EntityManager em;

    public List<SuccessionHelper> GenenarteSuccessionHelperByProject(String Project) {

        List<Teams> SuccesionRoles = em.createNamedQuery("Teams.findAllByProjID", Teams.class).setParameter("proj", Project).getResultList();
        List<SuccessionHelper> suc_List = new ArrayList();
        for (Teams sr : SuccesionRoles) {
            SuccessionHelper SucHelper = new SuccessionHelper();
            Roles roles = sr.getRoleid();

            SucHelper.setRoleName(roles.getRole());
            SucHelper.setProjectName(em.find(Projects.class, Project).getProjectName());
            SucHelper.setEmployementType(roles.getEmploymentType());
            SucHelper.setRoleID(roles.getRoleId());
            SucHelper.setProjectID(Project);
            SucHelper.setExpirience(roles.getExperienceRequired());

            suc_List.add(SucHelper);

        }
        return suc_List;

    }

    private List<Employees> GetEmployeesFromTeams(String Project) {

        List<Employees> teamRoleList = em.createNamedQuery("Teams.findEmployeesByProjID").setParameter("proj", Project).getResultList();

        List<Employees> tpList = em.createNamedQuery("Work.FindTeamEmployessById").setParameter("status2", "Open").setParameter("status", "Notice").getResultList();
        List<Employees> tpAndTeamRoleList = new ArrayList<>(teamRoleList);
        for (Employees trl : teamRoleList) {

            int tp_index = tpList.indexOf(trl);
            // int trl_index = teamRoleList.indexOf(trl);
            if (tp_index == -1) {

                tpAndTeamRoleList.remove(trl);

            }

        }

        return tpAndTeamRoleList;
    }

    public List<SuccessionHelperClass> GenerateSuccessionPlan(String Project) {
        
       List<Employees> SuccEmp = GetEmployeesFromTeams(Project);
       List<SuccessionHelperClass> succList = new ArrayList<>();
       
       for(Employees e:SuccEmp){
          SuccessionHelperClass sucHelperClass = new SuccessionHelperClass();
          
          Work employeeWorkData = new Work();
          try{
          employeeWorkData = em.createNamedQuery("Work.findByWorkEmpId",Work.class).setParameter("id",e.getEmployeeId()).getSingleResult();
          }
          catch(Exception s){}
          Teams TeamMember = new Teams();
          try{
          TeamMember = em.createNamedQuery("Teams.findEmployeesByProjID2",Teams.class).setParameter("proj", Project).setParameter("id", e.getEmployeeId()).getSingleResult();
          
          }catch(Exception n){}
          
          
          if(TeamMember!=null){
          if("Open".equals(employeeWorkData.getStatus())){
              
              
             sucHelperClass.setHeading(employeeWorkData.getPosition());
             sucHelperClass.setNoticeType("Open");
             sucHelperClass.setProjects(em.find(Projects.class, Project).getProjectName());
             sucHelperClass.setInfo("Employement Type: "+TeamMember.getRoleid().getEmploymentType()+" Education: " +TeamMember.getRoleid().getRequiredQualification()+" Expirience required: "+TeamMember.getRoleid().getExperienceRequired());
             sucHelperClass.setPostDate(employeeWorkData.getNoticeDate().toString());
             sucHelperClass.setID(""+TeamMember.getEmployeeid().getEmployeeId());
              
          }
          else{
              sucHelperClass.setHeading(e.getName()+ " "+e.getSurname());
              sucHelperClass.setID(e.getEmployeeId());
              sucHelperClass.setNoticeType("Notice");
              sucHelperClass.setProjects(em.find(Projects.class, Project).getProjectName());
              sucHelperClass.setInfo("Role: "+employeeWorkData.getPosition()+"    Department: "+employeeWorkData.getDepartment());
              sucHelperClass.setPostDate(employeeWorkData.getNoticeDate().toString());
           
          }
          succList.add(sucHelperClass);
          }
          
       
       }

        return succList;
    }
   public List<SuccessorData> SuggestSuccessors(List<RecommendedItem> recItem){
       List<SuccessorData> sucDataList = new ArrayList();
//       System.out.print(recItem.get(1).getValue());
       for(RecommendedItem ri: recItem){
           SuccessorData sucData = new SuccessorData();
           sucData.setEmployeeId(""+ri.getItemID());
           sucData.setMatchPercentage(ri.getValue()*100);
         
          sucDataList.add(sucData); 
          
       }
      
   return sucDataList;
   }
   
   
   // recommendations for the predecessor #succession plan
   public SuccessorMainDataObject SuggestSuccessorsObject(String SuccessorId){
        try {
            ConvertDB2CSVFile();
        } catch (IOException ex) {
            Logger.getLogger(SuccessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
   SuccessionRecommendation sucRec = new SuccessionRecommendation();
   List<SuccessorData> succDataList = SuggestSuccessors(sucRec.MakeRecommendation(18,5));
   List<SuccessorMainData> successorMainData = new ArrayList();
   SuccessorMainDataObject sucMainDataObject = new SuccessorMainDataObject();
   
   for(SuccessorData sd: succDataList){
    Employees emp = em.find(Employees.class,sd.getEmployeeId());
    Work work = new Work();
    Education education = new Education();
    try{
    work = em.createNamedQuery("Work.findByWorkEmpId",Work.class).setParameter("id",sd.getEmployeeId()).getSingleResult();
    }
    catch(Exception e){
    
    }
    try{
    
       education = em.createNamedQuery("Education.findByEmployeeId",Education.class).setParameter("id", sd.getEmployeeId()).getSingleResult();
    
    }catch(Exception e){
   
        
    }
    
    SuccessorMainData SucMainData  = new SuccessorMainData();
    SucMainData.setEmployeeId(sd.getEmployeeId());
    SucMainData.setMatchPercentage(sd.getMatchPercentage());
    SucMainData.setNameAndQualification(emp.getName()+" "+emp.getSurname()+"| "+education.getQualification());
    SucMainData.setJobTitleAndExpirience(work.getPosition()+" , "+work.getGeneralExperience());
    successorMainData.add(SucMainData);
   }
   
    Employees emp1 = em.find(Employees.class,SuccessorId);
    Work work1 = new Work();
    Education education1 = new Education();
    try{
    work1 = em.createNamedQuery("Work.findByWorkEmpId",Work.class).setParameter("id",SuccessorId).getSingleResult();
    }
    catch(Exception e){
    
    }
    try{
    
       education1 = em.createNamedQuery("Education.findByEmployeeId",Education.class).setParameter("id", SuccessorId).getSingleResult();
    
    }catch(Exception e){ 
        
        
        
    }
    sucMainDataObject.setJobTitle(work1.getPosition());
    sucMainDataObject.setNoticeDate(work1.getNoticeDate().toString());
    sucMainDataObject.setExpirienceAndQualification(work1.getGeneralExperience()+" | "+education1.getQualification());
    sucMainDataObject.setSuccessorsList(successorMainData);
    sucMainDataObject.setPredeccessorNameAndSurname(emp1.getName()+" "+emp1.getSurname());
    
   
   return sucMainDataObject;
           }
   
   
    public void ConvertDB2CSVFile() throws IOException{
        List<Recommendationdata> recData = GetRecData();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\8460p\\Documents\\Optim Share\\project updated\\___Master____\\optim\\data\\data.csv",true))) {
            for(Recommendationdata rd: recData){
                
                bw.write(rd.getEmployeeId() + "," + rd.getRecItemId() +  "\n");
            }     }
    
    }
    
    public List<Recommendationdata> GetRecData(){
      
        return em.createNamedQuery("Recommendationdata.findAll").getResultList();
    }
    
    
}

