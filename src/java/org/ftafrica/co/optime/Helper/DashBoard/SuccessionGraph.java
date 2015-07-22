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
public class SuccessionGraph {
    int Predecessors;
    int Successors;
    int NoSuccessors;
    int Total;

    public SuccessionGraph() {
    }

    public int getPredecessors() {
        return Predecessors;
    }

    public void setPredecessors(int Predecessors) {
        this.Predecessors = Predecessors;
    }

    public int getSuccessors() {
        return Successors;
    }

    public void setSuccessors(int Successors) {
        this.Successors = Successors;
    }

    public int getNoSuccessors() {
        return NoSuccessors;
    }

    public void setNoSuccessors(int NoSuccessors) {
        this.NoSuccessors = NoSuccessors;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    
    
    
    
    
    
}
