/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.HeatMap;

/**
 *
 * @author Training 8
 */
public class HeatMapMainHelper {
    String Title;
    HeatMapHiringHelper HeatMapHiring;
    HeatMapCapacityHelper HeatMapCapacity;
    HeatMapSuccessionHelper HeatMapSuccession;
    HeatMapTrainingHelper HeatMapTraining;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
    
    
    
    public HeatMapMainHelper() {
    }

    public HeatMapHiringHelper getHeatMapHiring() {
        return HeatMapHiring;
    }

    public void setHeatMapHiring(HeatMapHiringHelper HeatMapHiring) {
        this.HeatMapHiring = HeatMapHiring;
    }

    public HeatMapCapacityHelper getHeatMapCapacity() {
        return HeatMapCapacity;
    }

    public void setHeatMapCapacity(HeatMapCapacityHelper HeatMapCapacity) {
        this.HeatMapCapacity = HeatMapCapacity;
    }

    public HeatMapSuccessionHelper getHeatMapSuccession() {
        return HeatMapSuccession;
    }

    public void setHeatMapSuccession(HeatMapSuccessionHelper HeatMapSuccession) {
        this.HeatMapSuccession = HeatMapSuccession;
    }

    public HeatMapTrainingHelper getHeatMapTraining() {
        return HeatMapTraining;
    }

    public void setHeatMapTraining(HeatMapTrainingHelper HeatMapTraining) {
        this.HeatMapTraining = HeatMapTraining;
    }
            
}
