/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic;

import java.util.List;
import javax.ejb.Local;
import org.ftafrica.co.optime.model.SuccessionComments;

/**
 *
 * @author Training 8
 */
@Local
public interface SuccessionCommentsFacadeLocal {

    void create(SuccessionComments successionComments);

    void edit(SuccessionComments successionComments);

    void remove(SuccessionComments successionComments);

    SuccessionComments find(Object id);

    List<SuccessionComments> findAll();

    List<SuccessionComments> findRange(int[] range);

    int count();
    
}
