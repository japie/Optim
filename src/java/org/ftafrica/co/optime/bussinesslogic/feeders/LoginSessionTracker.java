/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.bussinesslogic.feeders;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.LoginDetails;
import org.ftafrica.co.optime.model.Projects;

/**
 *
 * @author Training 8
 */
@Stateful

public class LoginSessionTracker implements LoginSessionTrackerInterface{

    @PersistenceContext
    EntityManager em;
    String sessionID;
    private List<String> Proj;

    
    @Override
    public String getSessionID() {
        return sessionID;
    }

 private void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    @Override
    public boolean CreateSessionId(String username, String Password) {
        LoginDetails loginDetails = em.find(LoginDetails.class, username);
        boolean result = true;
        if (loginDetails != null) {
            try {
                if(loginDetails.getPassword().equals(Password)) {
                    Employees emp = loginDetails.getEmployeeId();
                    
                    setSessionID(emp.getEmployeeId());
                   List<Projects> projects= em.createNamedQuery("Projects.findByProjectmanager",Projects.class).setParameter("projectmanager", emp.getEmployeeId()).getResultList();
                   List<String> ProjectIdList = new ArrayList();
                    for(Projects p : projects){
                    ProjectIdList.add(p.getProjectid());
                    
                    }
                    setProj(ProjectIdList);

                }
                else{
                result = false;
                }
            } catch (Exception e) {

                result = false;
            }
        } else {
            result = false;
        }

        return result;
    }
    
    
    @Override
     public Employees GetExistingUser(String employeeId){
    
    return em.find(Employees.class, employeeId);
    }

    @Override
    public List<String> getProj() {
        return Proj;
    }

    private void setProj(List<String> Proj) {
        this.Proj = Proj;
    }
    @Remove
    @Override
    public void logOut(){
    
    }

}
