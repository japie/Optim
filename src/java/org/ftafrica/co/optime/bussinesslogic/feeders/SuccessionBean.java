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
import org.ftafrica.co.optime.Helper.HeatMap.HeatMapSuccessionHelper;
import org.ftafrica.co.optime.Helper.Succesion.SuccessionHelper;
import org.ftafrica.co.optime.model.Projects;
import org.ftafrica.co.optime.model.Roles;
import org.ftafrica.co.optime.model.Teams;

/**
 *
 * @author Training 8
 */
@Stateless
public class SuccessionBean {
    @PersistenceContext
    EntityManager em;
    

    public List<SuccessionHelper> GenenarteSuccessionHelperByProject(String Project){
        
    List<Teams> SuccesionRoles = em.createNamedQuery("Teams.findAllByProjID",Teams.class).setParameter("proj", Project).getResultList();
    List<SuccessionHelper> suc_List = new ArrayList();
    for(Teams sr: SuccesionRoles){
        SuccessionHelper SucHelper = new SuccessionHelper();    
    Roles roles = sr.getRoleid();
    
    SucHelper.setRoleName(roles.getRole());
    SucHelper.setProjectName(em.find(Projects.class,Project).getProjectName());
    SucHelper.setEmployementType(roles.getEmploymentType());
    SucHelper.setRoleID(roles.getRoleId());
    SucHelper.setProjectID(Project);
    SucHelper.setExpirience(roles.getExperienceRequired());
    
    suc_List.add(SucHelper);
    
    }
        
        
        
        
        
      return suc_List;  

    }
}
