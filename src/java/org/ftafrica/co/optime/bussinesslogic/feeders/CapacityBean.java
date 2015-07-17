/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic.feeders;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftafrica.co.optime.Helper.capacity.CapacityHelper;

/**
 *
 * @author Training 8
 */
@Stateless
public class CapacityBean {
@PersistenceContext
EntityManager em;
   
public List<CapacityHelper> GenerateCapacityForProjects(){

    


return null;
}


}
