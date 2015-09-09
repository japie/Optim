/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic;

import java.util.List;
import javax.ejb.Local;
import org.ftafrica.co.optime.model.Succession;

/**
 *
 * @author Training 8
 */
@Local
public interface SuccessionFacadeLocal {

    void create(Succession succession);

    void edit(Succession succession);

    void remove(Succession succession);

    Succession find(Object id);

    List<Succession> findAll();

    List<Succession> findRange(int[] range);

    int count();
    
}
