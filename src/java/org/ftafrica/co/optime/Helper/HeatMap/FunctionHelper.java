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
    String Function;
   List<HeatMapPersonHelper> Employees;

    public FunctionHelper() {
    }

    public String getFunction() {
        return Function;
    }

    public void setFunction(String Function) {
        this.Function = Function;
    }

    public List<HeatMapPersonHelper> getEmployees() {
        return Employees;
    }

    public void setEmployees(List<HeatMapPersonHelper> Employees) {
        this.Employees = Employees;
    }
   
   
    
}
