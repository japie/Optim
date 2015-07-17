/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.bussinesslogic.feeders;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.LoginDetails;

/**
 *
 * @author Training 8
 */
@Stateful

public class LoginSessionTracker implements LoginSessionTrackerInterface{

    @PersistenceContext
    EntityManager em;
    String sessionID;

    public String getSessionID() {
        return sessionID;
    }

 private void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public boolean CreateSessionId(String username, String Password) {
        LoginDetails loginDetails = em.find(LoginDetails.class, username);
        boolean result = true;
        if (loginDetails != null) {
            try {
                if (loginDetails.getPassword() == null ? Password == null : loginDetails.getPassword().equals(Password)) {
                    Employees emp = loginDetails.getEmployeeId();
                    setSessionID(emp.getEmployeeId());

                }
            } catch (Exception e) {

                result = false;
            }
        } else {
            result = false;
        }

        return result;
    }
    
    
     public Employees GetExistingUser(String employeeId){
    
    return em.find(Employees.class, employeeId);
    }

}
