/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic;

import java.util.List;
import javax.ejb.Local;
import org.ftafrica.co.optime.model.SuccessionDetails;

/**
 *
 * @author Training 8
 */
@Local
public interface SuccessionDetailsFacadeLocal {

    void create(SuccessionDetails successionDetails);

    void edit(SuccessionDetails successionDetails);

    void remove(SuccessionDetails successionDetails);

    SuccessionDetails find(Object id);

    List<SuccessionDetails> findAll();

    List<SuccessionDetails> findRange(int[] range);

    int count();
    
}
