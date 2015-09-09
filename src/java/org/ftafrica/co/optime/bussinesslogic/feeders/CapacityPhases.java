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
import org.ftafrica.co.optime.Helper.capacity.CapacityMainPhase;
import org.ftafrica.co.optime.Helper.capacity.CapacityPhasesHelper;
import org.ftafrica.co.optime.model.Projects;
import org.ftafrica.co.optime.model.Task1A;

/**
 *
 * @author Training 10
 */
@Stateless
public class CapacityPhases {

    @PersistenceContext
    EntityManager em;

    public List<CapacityMainPhase> GenerateCapacityPhasesB(String ManagerId) {

        List<CapacityMainPhase> capacityMainPhasesList = new ArrayList();
        List<String> Projectmanager = em.createNamedQuery("Projects.findDistinctByProjectmanager",String.class).setParameter("projectmanager", ManagerId).getResultList();
        for ( String prj : Projectmanager) {
            CapacityMainPhase capacityPhasesHelper = new CapacityMainPhase();
            List<Task1A> CapacityPhases = null;
            try {
                CapacityPhases = em.createNamedQuery("Task1A.findByProjectid", Task1A.class).setParameter("projid", prj).getResultList();
            } catch (Exception e) {
            }
            List<CapacityPhasesHelper> PhasesList;
            PhasesList = new ArrayList();
            for (Task1A ph : CapacityPhases) {
                CapacityPhasesHelper CapPhases = new CapacityPhasesHelper();
                Projects pr = em.find(Projects.class, prj);

                CapPhases.setProj_id(pr.getProjectid());
                CapPhases.setProjectName(pr.getProjectName());
                CapPhases.setPhases(ph.getPhase());
                CapPhases.setStartDate(ph.getStartdate());
                CapPhases.setEndDate(ph.getEnddate());
                CapPhases.setEstimatedManDays(ph.getEstimatemandays());
                CapPhases.setActualManDays(ph.getActualmandays());
                CapPhases.setNumberOfEmployees(ph.getNumberofEmployees());
                PhasesList.add(CapPhases);
            }
            capacityPhasesHelper.setProjectid(prj);
            capacityPhasesHelper.setCapacityMain(PhasesList);
            capacityMainPhasesList.add(capacityPhasesHelper);

        }
        return capacityMainPhasesList;
    }

}

//    public List<CapacityHelper> GenerateCapacityHelperByProject(){
//        
//        List<Projects> CapacityProjects =  em.createNamedQuery("Projects.findAll", Projects.class).getResultList();
//        List<CapacityHelper> Capa_List = new ArrayList();
//        
//        for(Projects sr: CapacityProjects){
//            CapacityHelper CapHelper = new CapacityHelper();
//        
//        
//        CapHelper.setProjectID(sr.getProjectid());
//        CapHelper.setProjectName(sr.getProjectName());
//        CapHelper.setProjectTeam(sr.getProjectTeam());
//       
//        Capa_List.add(CapHelper);
//        }    
//     return Capa_List;   
//    }
