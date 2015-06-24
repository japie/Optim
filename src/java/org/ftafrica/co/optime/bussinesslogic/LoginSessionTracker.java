/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import javax.ejb.Stateful;

/**
 *
 * @author Training 8
 */
@Stateful
public class LoginSessionTracker {
    @PersistenceContext
    EntityManager em;
    
    public String SetSessionId(){
        //List<Employee> = em.
        
    
    return null;
    }
    
    private class SessionTracker{
    
        String generatedIdTracker;
        
    
    
    }

}
