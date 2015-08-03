/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic.feeders;

import java.util.List;
import javax.ejb.Local;
import org.ftafrica.co.optime.model.Employees;

/**
 *
 * @author Training 8
 */
@Local
public interface LoginSessionTrackerInterface {
    public String getSessionID();
    public List<String> getProj();
    public boolean CreateSessionId(String username, String Password);  
     public Employees GetExistingUser(String employeeId);
     public void logOut();
    
}
