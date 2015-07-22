/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic.feeders;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftafrica.co.optime.Helper.DashBoard.CapacityGraph;
import org.ftafrica.co.optime.Helper.DashBoard.DashboardMain;
import org.ftafrica.co.optime.Helper.DashBoard.SuccessionGraph;
import org.ftafrica.co.optime.Helper.DashBoard.HiringGraph;
import org.ftafrica.co.optime.Helper.DashBoard.TrainingGraph;
import org.ftafrica.co.optime.model.Succession;
import org.ftafrica.co.optime.model.Teams;
import org.ftafrica.co.optime.model.TrainingPlan;
import org.ftafrica.co.optime.model.Work;

/**
 *
 * @author Training 8
 */
@Stateless
public class DashboardBean {
    @PersistenceContext
    EntityManager em;
    
   public DashboardMain  dashBoardMain(String ProjectId){
   
   List<Teams> ProjTeam = em.createNamedQuery("").setParameter("", ProjectId).getResultList();
   CapacityGraph capGraph = new CapacityGraph();
   SuccessionGraph sucGraph = new SuccessionGraph();
   HiringGraph HirGraph = new HiringGraph();
   TrainingGraph trainGraph = new TrainingGraph();
   
   int capOpen = 0, capPlaced =0,capNotice=0;
   int OnTraining = 0,Trained = 0,NotTrained= 0;
   
   for(Teams pt: ProjTeam){
       
       Work empWork = em.createNamedQuery("",Work.class).setParameter("", pt.getEmployeeid().getEmployeeId()).getSingleResult();
       TrainingPlan emTraining = em.createNamedQuery("",TrainingPlan.class).setParameter("",pt.getEmployeeid().getEmployeeId()).getSingleResult();
       
      if(empWork.getStatus().equalsIgnoreCase("Active")){
      
      capOpen++;
      
      }
      if(empWork.getStatus().equalsIgnoreCase("Active")){
      
      capPlaced++;
      
      }
      if(empWork.getStatus().equalsIgnoreCase("Active")){
      
      capNotice++;
      
      }
      if(emTraining.getStatus().equalsIgnoreCase("completed")){
      Trained++;
      
      }
      if(emTraining.getStatus().equalsIgnoreCase("completed")){
      
      OnTraining++;
      }
      if(emTraining.getStatus().equalsIgnoreCase("completed")){
      
      NotTrained++;
      }
      
   }
   
   capGraph.setOnNotice(capNotice);
      capGraph.setOpenPositions(capOpen);
      capGraph.setPlaced(capPlaced);
      capGraph.setTotal(capNotice+capOpen+capPlaced);
   
   List<Succession> SucPreAll = em.createNamedQuery(ProjectId, Succession.class).getResultList();
   List<Succession>SucNoSuccessor = em.createNamedQuery("",Succession.class).getResultList();
   int AllSuccessors = SucPreAll.size() - SucNoSuccessor.size();
   
   sucGraph.setNoSuccessors(SucNoSuccessor.size());
   sucGraph.setPredecessors(SucPreAll.size());
   sucGraph.setSuccessors(AllSuccessors);
   sucGraph.setTotal(SucPreAll.size());
   
   trainGraph.setNotTrained(NotTrained);
   trainGraph.setOnTraining(OnTraining);
   trainGraph.setTrained(Trained);
   
   return null;
           }
   
}
