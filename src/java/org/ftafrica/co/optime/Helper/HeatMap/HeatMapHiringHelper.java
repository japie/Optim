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
public class HeatMapHiringHelper {
    
    List<HeatMapEmployeeHiringHelper> Hiring;
    List<HeatMapEmployeeHiringHelper> NotHired;
    List<HeatMapEmployeeHiringHelper> Hired;

    public HeatMapHiringHelper() {
    }

    public List getHiring() {
        return Hiring;
    }

    public void setHiring(List<HeatMapEmployeeHiringHelper> Hiring) {
        this.Hiring = Hiring;
    }

    public List<HeatMapEmployeeHiringHelper> getNotHired() {
        return NotHired;
    }

    public void setNotHired(List<HeatMapEmployeeHiringHelper> NotHired) {
        this.NotHired = NotHired;
    }

    public List<HeatMapEmployeeHiringHelper> getHired() {
        return Hired;
    }

    public void setHired(List<HeatMapEmployeeHiringHelper> Hired) {
        this.Hired = Hired;
    }
    
    
    
}
