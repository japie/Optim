/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.capacity;

import java.util.List;
import org.ftafrica.co.optime.Helper.HeatMap.FunctionHelper;

/**
 *
 * @author Training 10
 */
public class CapacityTeamHelper {
    
    
     private String Level;
     private List<FunctionHelper> Funnction;

    public List<FunctionHelper> getFunnction() {
        return Funnction;
    }

    public void setFunnction(List<FunctionHelper> Funnction) {
        this.Funnction = Funnction;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }
}