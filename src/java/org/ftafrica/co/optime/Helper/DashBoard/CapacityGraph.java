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
public class CapacityGraph {
    
    int OpenPositions; // Vacant
    int Placed; // Active 
    int OnNotice; 
    int Total;

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    
    

    public CapacityGraph() {
    }

    public int getOpenPositions() {
        return OpenPositions;
    }

    public void setOpenPositions(int OpenPositions) {
        this.OpenPositions = OpenPositions;
    }

    public int getPlaced() {
        return Placed;
    }

    public void setPlaced(int Placed) {
        this.Placed = Placed;
    }

    public int getOnNotice() {
        return OnNotice;
    }

    public void setOnNotice(int OnNotice) {
        this.OnNotice = OnNotice;
    }
    
    
    
}
