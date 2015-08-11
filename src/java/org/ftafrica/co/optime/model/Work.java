/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Training 8
 */
@Entity
@Table(name = "work")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Work.findAll", query = "SELECT w FROM Work w"),
    @NamedQuery(name = "Work.findSpecificLevels", query = "SELECT DISTINCT w.level FROM Work w WHERE w.department =:departmen"),
    @NamedQuery(name = "Work.findByWorkId", query = "SELECT w FROM Work w WHERE w.workId = :workId"),
    @NamedQuery(name = "Work.findByNotice", query = "SELECT w FROM Work w WHERE w.level = :lev AND w.status = :status AND w.department = :dep"),
    @NamedQuery(name = "Work.findByOccupied", query = "SELECT w FROM Work w WHERE w.level = :lev AND w.status = :status AND w.department = :dep"),
    @NamedQuery(name = "Work.findByOpen", query = "SELECT w FROM Work w WHERE w.level = :lev AND w.status = :status AND w.department = :dep"),
    
    
    @NamedQuery(name = "Work.findByNoticePro", query = "SELECT w FROM Work w WHERE w.level = :lev AND w.status = :status "),
    @NamedQuery(name = "Work.findByOccupiedPro", query = "SELECT w FROM Work w WHERE w.level = :lev AND w.status = :status "),
    @NamedQuery(name = "Work.findByOpenPro", query = "SELECT w FROM Work w WHERE w.level = :lev AND w.status = :status"),
    
    @NamedQuery(name = "Work.FindTeamEmployessById", query = "SELECT w.employeeId FROM Work w WHERE w.status = :status2 OR w.status = :status"),//
    
    @NamedQuery(name = "Work.findByOpenPro", query = "SELECT w FROM Work w WHERE w.level = :lev AND w.status = :status"),
    
    
    @NamedQuery(name = "Work.findByCompany", query = "SELECT w FROM Work w WHERE w.company = :company"),
    @NamedQuery(name = "Work.findByWorkEmpId", query = "SELECT w FROM Work w WHERE w.employeeId.employeeId = :id"),
    @NamedQuery(name = "Work.findByDepartment", query = "SELECT w FROM Work w WHERE w.department = :department"),
    @NamedQuery(name = "Work.findByPosition", query = "SELECT w FROM Work w WHERE w.position = :position"),
    @NamedQuery(name = "Work.findByContract", query = "SELECT w FROM Work w WHERE w.contract = :contract"),
    @NamedQuery(name = "Work.findByRelevantExperience", query = "SELECT w FROM Work w WHERE w.relevantExperience = :relevantExperience"),
    @NamedQuery(name = "Work.findByGeneralExperience", query = "SELECT w FROM Work w WHERE w.generalExperience = :generalExperience"),
    @NamedQuery(name = "Work.findByStatus", query = "SELECT w FROM Work w WHERE w.status = :status"),
    @NamedQuery(name = "Work.findByStartDate", query = "SELECT w FROM Work w WHERE w.startDate = :startDate"),
    @NamedQuery(name = "Work.findByEndDate", query = "SELECT w FROM Work w WHERE w.endDate = :endDate")})
public class Work implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Notice_Date")
    @Temporal(TemporalType.DATE)
    private Date noticeDate;
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "status")
    private String status;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "work_id")
    private String workId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "department")
    private String department;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "position")
    private String position;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contract")
    private String contract;
    @Basic(optional = false)
    @NotNull
    @Column(name = "relevant_experience")
    private int relevantExperience;
    @Basic(optional = false)
    @NotNull
    @Column(name = "general_experience")
    private int generalExperience;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "level")
    private String level;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employees employeeId;

    public Work() {
    }

    public Work(String workId) {
        this.workId = workId;
    }

    public Work(String workId, String company, String department, String position, String contract, int relevantExperience, int generalExperience, String level, String status, Date startDate, Date endDate) {
        this.workId = workId;
        this.company = company;
        this.department = department;
        this.position = position;
        this.contract = contract;
        this.relevantExperience = relevantExperience;
        this.generalExperience = generalExperience;
        this.level = level;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public int getRelevantExperience() {
        return relevantExperience;
    }

    public void setRelevantExperience(int relevantExperience) {
        this.relevantExperience = relevantExperience;
    }

    public int getGeneralExperience() {
        return generalExperience;
    }

    public void setGeneralExperience(int generalExperience) {
        this.generalExperience = generalExperience;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Employees getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employees employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workId != null ? workId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Work)) {
            return false;
        }
        Work other = (Work) object;
        if ((this.workId == null && other.workId != null) || (this.workId != null && !this.workId.equals(other.workId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Work[ workId=" + workId + " ]";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

   
    
}
