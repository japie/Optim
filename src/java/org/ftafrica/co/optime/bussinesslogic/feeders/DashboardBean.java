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
import org.ftafrica.co.optime.Helper.DashBoard.DashboardFlags;
import org.ftafrica.co.optime.Helper.DashBoard.DashboardMain;
import org.ftafrica.co.optime.Helper.DashBoard.SuccessionGraph;
import org.ftafrica.co.optime.Helper.DashBoard.HiringGraph;
import org.ftafrica.co.optime.Helper.DashBoard.TrainingGraph;
import org.ftafrica.co.optime.model.Hiring;
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

    public DashboardMain GenerateDashBoardMain(List<String> Projects) {
        CapacityGraph capGraph = new CapacityGraph();
        SuccessionGraph sucGraph = new SuccessionGraph();
        HiringGraph HirGraph = new HiringGraph();
        TrainingGraph trainGraph = new TrainingGraph();
        DashboardFlags Flags = new DashboardFlags();
        DashboardMain dboardMain = new DashboardMain();
        
        int OuterCapOpen = 0, OuterCapPlaced = 0,OuterCapNotice = 0, OuterHiringNum = 0,OuterHiredNum=0,OuterNotHired=0 ;
        int OuterOnTraining = 0, OuterTrained = 0, OuterNotTrained = 0;
       for(String pr:Projects){
        List<Teams> ProjTeam = em.createNamedQuery("Teams.findByProjID2").setParameter("projId", pr).getResultList();
        

        int capOpen = 0, capPlaced = 0, capNotice = 0;
        int OnTraining = 0, Trained = 0, NotTrained = 0;

        int HiringNum = em.createNamedQuery("Hiring.findAllHiring", Hiring.class).setParameter("ProjId", pr).setParameter("status", "Hiring").getResultList().size();
        int HiredNum = em.createNamedQuery("Hiring.findAllHiring", Hiring.class).setParameter("ProjId", pr).setParameter("status", "Hired").getResultList().size();
        int NotHired = em.createNamedQuery("Hiring.findAllHiring", Hiring.class).setParameter("ProjId", pr).setParameter("status", "Hired").getResultList().size();

        

        for (Teams pt : ProjTeam) {

            Work empWork = em.createNamedQuery("Work.findByWorkEmpId", Work.class).setParameter("id", pt.getEmployeeid().getEmployeeId()).getSingleResult();
            TrainingPlan emTraining = new TrainingPlan();
            try {
                emTraining = em.createNamedQuery("TrainingPlan.findByTrainingEmpId", TrainingPlan.class).setParameter("id", pt.getEmployeeid().getEmployeeId()).getSingleResult();
            } catch (Exception e) {
            }
            if (empWork.getStatus().equalsIgnoreCase("Open")) {

                capOpen++;

            }
            if (empWork.getStatus().equalsIgnoreCase("Active")) {

                capPlaced++;

            }
            if (empWork.getStatus().equalsIgnoreCase("Notice")) {

                capNotice++;

            }
            try {
                if (emTraining.getStatus().equalsIgnoreCase("complete")) {
                    Trained++;

                }
                if (emTraining.getStatus().equalsIgnoreCase("In-training")) {

                    OnTraining++;
                }
                if (emTraining.getStatus().equalsIgnoreCase("not trained")) {

                    NotTrained++;
                }
            } catch (Exception e) {
            }
            
        }
        OuterCapOpen = OuterCapOpen + capOpen;
            OuterCapPlaced = OuterCapPlaced + capPlaced;
            OuterCapNotice = OuterCapNotice + capNotice;
            
            OuterNotTrained = OuterNotTrained + NotTrained;
            OuterTrained = OuterTrained + Trained;
            OuterOnTraining = OuterOnTraining + Trained;
            OuterHiringNum = OuterHiringNum + HiringNum;
            OuterHiredNum = OuterHiredNum + HiredNum;
            OuterNotHired = OuterNotHired + NotHired;
            
    }
       
       HirGraph.setHiring(OuterHiringNum);
        HirGraph.setHired(OuterHiredNum);
        HirGraph.setFailedApplicants(OuterNotHired);
        capGraph.setOnNotice(OuterCapNotice);
        capGraph.setOpenPositions(OuterCapOpen);
        capGraph.setPlaced(OuterCapPlaced);
        capGraph.setTotal(OuterCapNotice + OuterCapOpen + OuterCapPlaced);

        List<Succession> SucPreAll = em.createNamedQuery("Succession.findAll", Succession.class).getResultList();
        List<Succession> SucNoSuccessor = em.createNamedQuery("Succession.FindNull", Succession.class).getResultList();
        int AllSuccessors = SucPreAll.size() - SucNoSuccessor.size();

        sucGraph.setNoSuccessors(SucNoSuccessor.size());
        sucGraph.setPredecessors(SucPreAll.size());
        sucGraph.setSuccessors(AllSuccessors);
        sucGraph.setTotal(SucPreAll.size());

        trainGraph.setNotTrained(OuterNotTrained);
        trainGraph.setOnTraining(OuterOnTraining);
        trainGraph.setTrained(OuterTrained);

        Flags.setBookOfWork(Projects.size());
        Flags.setCapacity(OuterCapNotice + OuterCapPlaced);
        Flags.setLeavingSoon(OuterCapNotice);
        Flags.setOccupiedRoles(OuterCapPlaced);
        Flags.setOpenRoles(OuterCapOpen);

        dboardMain.setCapacityGraph(capGraph);
        dboardMain.setDashboardFlags(Flags);
        dboardMain.setSuccessorGrapg(sucGraph);
        dboardMain.setTrainingGraph(trainGraph);
        dboardMain.setHiringGraph(HirGraph);

        return dboardMain;
    }

}
