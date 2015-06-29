/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.controller;

/**
 *
 * @author Training 8
 */
public class LoginServletHelper {
    
   private String status;
    private String url;
  private String sessionTrackerID;

    public LoginServletHelper(String status, String url, String sessionTrackerID) {
        this.status = status;
        this.url = url;
        this.sessionTrackerID = sessionTrackerID;
    }

    public LoginServletHelper() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSessionTrackerID() {
        return sessionTrackerID;
    }

    public void setSessionTrackerID(String sessionTrackerID) {
        this.sessionTrackerID = sessionTrackerID;
    }
    
    
    
}
