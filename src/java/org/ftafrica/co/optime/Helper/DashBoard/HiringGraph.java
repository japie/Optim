/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.DashBoard;

/**
 *
 * @author Training 8
 */
public class HiringGraph {
    
    int Hiring; //shortlisted
    int Hired;
    int FailedApplicants;

    public HiringGraph() {
    }

    public int getHiring() {
        return Hiring;
    }

    public void setHiring(int Hiring) {
        this.Hiring = Hiring;
    }

    public int getHired() {
        return Hired;
    }

    public void setHired(int Hired) {
        this.Hired = Hired;
    }

    public int getFailedApplicants() {
        return FailedApplicants;
    }

    public void setFailedApplicants(int FailedApplicants) {
        this.FailedApplicants = FailedApplicants;
    }
    
    
    
}
