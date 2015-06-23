/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic;

import java.util.List;
import javax.ejb.Local;
import org.ftafrica.co.optime.model.RoleTraining;

/**
 *
 * @author Training 8
 */
@Local
public interface RoleTrainingFacadeLocal {

    void create(RoleTraining roleTraining);

    void edit(RoleTraining roleTraining);

    void remove(RoleTraining roleTraining);

    RoleTraining find(Object id);

    List<RoleTraining> findAll();

    List<RoleTraining> findRange(int[] range);

    int count();
    
}
