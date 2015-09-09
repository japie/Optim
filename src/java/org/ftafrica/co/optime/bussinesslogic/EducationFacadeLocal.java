/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic;

import java.util.List;
import javax.ejb.Local;
import org.ftafrica.co.optime.model.Education;

/**
 *
 * @author Training 8
 */
@Local
public interface EducationFacadeLocal {

    void create(Education education);

    void edit(Education education);

    void remove(Education education);

    Education find(Object id);

    List<Education> findAll();

    List<Education> findRange(int[] range);

    int count();
    
}
