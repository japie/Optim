/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic;

import java.util.List;
import javax.ejb.Local;
import org.ftafrica.co.optime.model.TrainingComments;

/**
 *
 * @author Training 8
 */
@Local
public interface TrainingCommentsFacadeLocal {

    void create(TrainingComments trainingComments);

    void edit(TrainingComments trainingComments);

    void remove(TrainingComments trainingComments);

    TrainingComments find(Object id);

    List<TrainingComments> findAll();

    List<TrainingComments> findRange(int[] range);

    int count();
    
}
