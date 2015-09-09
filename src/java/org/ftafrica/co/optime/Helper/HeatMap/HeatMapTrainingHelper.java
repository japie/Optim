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
public class HeatMapTrainingHelper {
    
    List<HeatMapEmployeeTrainingHelper>  Training;
     List<HeatMapEmployeeTrainingHelper>  Trained;
      List<HeatMapEmployeeTrainingHelper>  NotTrained;

    public HeatMapTrainingHelper() {
    }

    public List<HeatMapEmployeeTrainingHelper> getTraining() {
        return Training;
    }

    public void setTraining(List<HeatMapEmployeeTrainingHelper> Training) {
        this.Training = Training;
    }

    public List<HeatMapEmployeeTrainingHelper> getTrained() {
        return Trained;
    }

    public void setTrained(List<HeatMapEmployeeTrainingHelper> Trained) {
        this.Trained = Trained;
    }

    public List<HeatMapEmployeeTrainingHelper> getNotTrained() {
        return NotTrained;
    }

    public void setNotTrained(List<HeatMapEmployeeTrainingHelper> NotTrained) {
        this.NotTrained = NotTrained;
    }
    
      
}
