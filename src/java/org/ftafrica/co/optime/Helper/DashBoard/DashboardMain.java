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
    
    SuccessionGraph successorGrapg;
    HiringGraph trainingGraph;
    CapacityGraph capacityGraph;
    DashboardFlags dashboardFlags;

    public DashboardMain() {
    }

    public SuccessionGraph getSuccessorGrapg() {
        return successorGrapg;
    }

    public void setSuccessorGrapg(SuccessionGraph successorGrapg) {
        this.successorGrapg = successorGrapg;
    }

    public HiringGraph getTrainingGraph() {
        return trainingGraph;
    }

    public void setTrainingGraph(HiringGraph trainingGraph) {
        this.trainingGraph = trainingGraph;
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
    
    
    
    
}
