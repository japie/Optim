/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic.feeders;

import javax.ejb.Local;
import javax.ejb.Remote;
import org.ftafrica.co.optime.model.Employees;

/**
 *
 * @author Training 8
 */
@Local
public interface LoginSessionTrackerInterface {
    public String getSessionID();
    public boolean CreateSessionId(String username, String Password);  
     public Employees GetExistingUser(String employeeId);
    
}
