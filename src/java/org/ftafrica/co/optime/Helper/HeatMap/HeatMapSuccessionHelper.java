/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.HeatMap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Training 8
 */
public class HeatMapSuccessionHelper {
    
    List<HeatMapPredecessor> PredecessorList = new ArrayList();
    List<HeatMapSuccessor> Successor = new ArrayList();

    public HeatMapSuccessionHelper() {
    }

    public List<HeatMapPredecessor> getPredecessorList() {
        return PredecessorList;
    }

    public void setPredecessorList(List<HeatMapPredecessor> PredecessorList) {
        this.PredecessorList = PredecessorList;
    }

    public List<HeatMapSuccessor> getSuccessor() {
        return Successor;
    }

    public void setSuccessor(List<HeatMapSuccessor> Successor) {
        this.Successor = Successor;
    }
    
    
    
}
