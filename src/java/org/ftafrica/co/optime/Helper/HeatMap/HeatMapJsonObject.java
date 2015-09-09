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
public class HeatMapJsonObject {
    private String ProjectName;
    private List<MainHeatMap> mainHeatMap;

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public List<MainHeatMap> getMainHeatMap() {
        return mainHeatMap;
    }

    public void setMainHeatMap(List<MainHeatMap> mainHeatMap) {
        this.mainHeatMap = mainHeatMap;
    }
    
    
}
