/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.Helper.capacity;

import java.util.List;

/**
 *
 * @author Training 8
 */
public class CapacityMainPhase {
    
    private String Projectid;
    private List<CapacityPhasesHelper> capacityMain;

    public CapacityMainPhase() {
    }

    public String getProjectid() {
        return Projectid;
    }

    public void setProjectid(String Projectid) {
        this.Projectid = Projectid;
    }

    public List<CapacityPhasesHelper> getCapacityMain() {
        return capacityMain;
    }

    public void setCapacityMain(List<CapacityPhasesHelper> capacityMain) {
        this.capacityMain = capacityMain;
    }
    
}
