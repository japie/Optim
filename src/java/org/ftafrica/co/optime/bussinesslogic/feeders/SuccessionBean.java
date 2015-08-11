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
import org.ftafrica.co.optime.Helper.Succesion.SuccessionHelper;
import org.ftafrica.co.optime.Helper.Succesion.SuccessionHelperClass;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Projects;
import org.ftafrica.co.optime.model.Roles;
import org.ftafrica.co.optime.model.Teams;
import org.ftafrica.co.optime.model.Work;

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
             sucHelperClass.setID(""+TeamMember.getRoleid().getRoleId());
              
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
}
