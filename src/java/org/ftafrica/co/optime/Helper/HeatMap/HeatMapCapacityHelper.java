/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.HeatMap;

import java.util.List;
import org.ftafrica.co.optime.model.Work;

/**
 *
 * @author Training 8
 */
public class HeatMapCapacityHelper {
    
    List<HeatMapEmployeeCapacityHelper> OcupiedList;
    List<CapacityOpenHelper> OpenList;
    List<HeatMapEmployeeCapacityHelper> NoticeList;

   
    

    public HeatMapCapacityHelper() {
    }

    public List<HeatMapEmployeeCapacityHelper> getOcupiedList() {
        return OcupiedList;
    }

    public void setOcupiedList(List<HeatMapEmployeeCapacityHelper> OcupiedList) {
        this.OcupiedList = OcupiedList;
    }

    public List<CapacityOpenHelper> getOpenList() {
        return OpenList;
    }

    public void setOpenList(List<CapacityOpenHelper> OpenList) {
        this.OpenList = OpenList;
    }

    public List<HeatMapEmployeeCapacityHelper> getNoticeList() {
        return NoticeList;
    }

    public void setNoticeList(List<HeatMapEmployeeCapacityHelper> NoticeList) {
        this.NoticeList = NoticeList;
    }

    
    
     
    
}
