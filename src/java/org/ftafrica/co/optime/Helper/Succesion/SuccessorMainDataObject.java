/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.Helper.Succesion;

import java.util.List;

/**
 *
 * @author Training 8
 */
public class SuccessorMainDataObject {
    
    private String PredeccessorNameAndSurname;
    private String JobTitle;
    private String NoticeDate;
    private String ExpirienceAndQualification;
    private List<SuccessorMainData> SuccessorsList;

    public SuccessorMainDataObject() {
       
        
    }

    public String getPredeccessorNameAndSurname() {
        return PredeccessorNameAndSurname;
    }

    public void setPredeccessorNameAndSurname(String PredeccessorNameAndSurname) {
        this.PredeccessorNameAndSurname = PredeccessorNameAndSurname;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String JobTitle) {
        this.JobTitle = JobTitle;
    }

    public String getNoticeDate() {
        return NoticeDate;
    }

    public void setNoticeDate(String NoticeDate) {
        this.NoticeDate = NoticeDate;
    }

    public String getExpirienceAndQualification() {
        return ExpirienceAndQualification;
    }

    public void setExpirienceAndQualification(String ExpirienceAndQualification) {
        this.ExpirienceAndQualification = ExpirienceAndQualification;
    }

    public List<SuccessorMainData> getSuccessorsList() {
        return SuccessorsList;
    }

    public void setSuccessorsList(List<SuccessorMainData> SuccessorsList) {
        this.SuccessorsList = SuccessorsList;
    }
    
    
    
}
