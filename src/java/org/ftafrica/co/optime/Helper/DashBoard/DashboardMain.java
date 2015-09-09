/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.DashBoard;

/**
 *
 * @author Training 8
 */
public class DashboardMain {
    
    private SuccessionGraph successorGrapg;
     private HiringGraph HiringGraph;
     private CapacityGraph capacityGraph;
   private  DashboardFlags dashboardFlags;
    private TrainingGraph trainingGraph;

    public DashboardMain() {
    }

    public SuccessionGraph getSuccessorGrapg() {
        return successorGrapg;
    }

    public void setSuccessorGrapg(SuccessionGraph successorGrapg) {
        this.successorGrapg = successorGrapg;
    }

    public HiringGraph getHiringGraph() {
        return HiringGraph;
    }

    public void setHiringGraph(HiringGraph HiringGraph) {
        this.HiringGraph = HiringGraph;
    }

    public CapacityGraph getCapacityGraph() {
        return capacityGraph;
    }

    public void setCapacityGraph(CapacityGraph capacityGraph) {
        this.capacityGraph = capacityGraph;
    }

    public DashboardFlags getDashboardFlags() {
        return dashboardFlags;
    }

    public void setDashboardFlags(DashboardFlags dashboardFlags) {
        this.dashboardFlags = dashboardFlags;
    }

    public TrainingGraph getTrainingGraph() {
        return trainingGraph;
    }

    public void setTrainingGraph(TrainingGraph trainingGraph) {
        this.trainingGraph = trainingGraph;
    }
    
    
    
    
}
