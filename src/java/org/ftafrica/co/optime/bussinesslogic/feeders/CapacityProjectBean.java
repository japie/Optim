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
import org.ftafrica.co.optime.Helper.capacity.CapacityProjectHelper;
import org.ftafrica.co.optime.model.Projects;

/**
 *
 * @author Training 10
 */
@Stateless
public class CapacityProjectBean {

    @PersistenceContext
    EntityManager em;
    
    public List<CapacityProjectHelper> GenerateCapacityProjectHelperByProject(String ManagerId){
        
        List<Projects> CapacityProjects =  em.createNamedQuery("Projects.findByProjectmanager",Projects.class).setParameter("projectmanager", ManagerId).getResultList();
        List<CapacityProjectHelper> Cap_project_List = new ArrayList();
        
        for(Projects sr: CapacityProjects){
            CapacityProjectHelper CapProjectHelper = new CapacityProjectHelper();
        
        
        CapProjectHelper.setProjectID(sr.getProjectid());
        CapProjectHelper.setProjectName(sr.getProjectName());
        CapProjectHelper.setCapacity(sr.getCapacity());
        CapProjectHelper.setStartDate(sr.getStartdate());
        CapProjectHelper.setEndDate(sr.getEnddate());
        CapProjectHelper.setProjectPhases(sr.getProjectphases());
               
               
       
        Cap_project_List.add(CapProjectHelper);
        }    
     return Cap_project_List;   
    }
}
