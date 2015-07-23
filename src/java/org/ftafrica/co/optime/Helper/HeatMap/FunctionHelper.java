/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.HeatMap;

import java.util.List;

/**
 *
 * @author Training 8
 */
public class FunctionHelper {
    String Phase;
   List<HeatMapPersonHelper> Employees;

    public FunctionHelper() {
    }

    public String getPhase() {
        return Phase;
    }

    public void setPhase(String Phase) {
        this.Phase = Phase;
    }

    public List<HeatMapPersonHelper> getEmployees() {
        return Employees;
    }

    public void setEmployees(List<HeatMapPersonHelper> Employees) {
        this.Employees = Employees;
    }
   
   
    
}
