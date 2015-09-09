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
import org.ftafrica.co.optime.Helper.projects.ProjectHelper;
import org.ftafrica.co.optime.Helper.projects.ProjectsHelper;
import org.ftafrica.co.optime.model.Projects;
//import org.ftafrica.co.optime.model.Tasks;

/**
 *
 * @author Training 10
 */
@Stateless
public class ProjectOverviewBean {

        @PersistenceContext
        EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

        
        public List<ProjectsHelper> GenerateProjectOverView(String ManagerId){
            
            List<ProjectsHelper> ProjectView = new ArrayList();
            List<Projects> Projectbuilder  = em.createNamedQuery("Projects.findByProjectmanager", Projects.class).setParameter("projectmanager", ManagerId).getResultList();
            
            for(Projects pr: Projectbuilder){
            
//                Tasks tsk = em.find(Tasks.class, pr);
               // Hiring hr = em.find(Hiring.class, pr);
                
            ProjectsHelper projectList = new ProjectsHelper();
            
            projectList.setProjectName(pr.getProjectName());
            projectList.setProjectID(pr.getProjectid());
            projectList.setProjectTeam(pr.getProjectTeam());
            //projectList.setHiredEmployees(hr.getStatus());
            
            
            
            
            
            
            ProjectView.add(projectList);
                    
        }
        return ProjectView;
}
}
