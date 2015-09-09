/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.HeatMap;

import java.util.List;

/**
 *
 * @author Training 8
 */
public class HeatMapEmployeeSuccessionHelper {
    
    List<HeatMapPredecessor> Predessor;
   List<HeatMapSuccessor> Successor;

    public HeatMapEmployeeSuccessionHelper() {
    }

    public List<HeatMapPredecessor> getPredessor() {
        return Predessor;
    }

    public void setPredessor(List<HeatMapPredecessor> Predessor) {
        this.Predessor = Predessor;
    }

    public List<HeatMapSuccessor> getSuccessor() {
        return Successor;
    }

    public void setSuccessor(List<HeatMapSuccessor> Successor) {
        this.Successor = Successor;
    }

   

   
    
    
}
