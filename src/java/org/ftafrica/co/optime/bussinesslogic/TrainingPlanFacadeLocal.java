/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic;

import java.util.List;
import javax.ejb.Local;
import org.ftafrica.co.optime.model.TrainingPlan;

/**
 *
 * @author Training 8
 */
@Local
public interface TrainingPlanFacadeLocal {

    void create(TrainingPlan trainingPlan);

    void edit(TrainingPlan trainingPlan);

    void remove(TrainingPlan trainingPlan);

    TrainingPlan find(Object id);

    List<TrainingPlan> findAll();

    List<TrainingPlan> findRange(int[] range);

    int count();
    
}
