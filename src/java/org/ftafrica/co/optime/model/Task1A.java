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
 * @author 8460p
 */
@Entity
@Table(name = "task1_a")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task1A.findAll", query = "SELECT t FROM Task1A t"),
    @NamedQuery(name = "Task1A.findByTaskid", query = "SELECT t FROM Task1A t WHERE t.taskid = :taskid"),
    @NamedQuery(name = "Task1A.findByPhase", query = "SELECT t FROM Task1A t WHERE t.phase = :phase"),
        @NamedQuery(name = "Task1A.findByPPj", query = "SELECT t FROM Task1A t WHERE t.phase = :phase AND t.projid.projectid = :projid"),
    @NamedQuery(name = "Task1A.findByEmployeeid", query = "SELECT t FROM Task1A t WHERE t.employeeid.employeeId = :employeeid"),
    @NamedQuery(name = "Task1A.findByStartdate", query = "SELECT t FROM Task1A t WHERE t.startdate = :startdate"),
    @NamedQuery(name = "Task1A.findByEnddate", query = "SELECT t FROM Task1A t WHERE t.enddate = :enddate"),
   
    @NamedQuery(name = "Task1A.findByNumberofEmployees", query = "SELECT t FROM Task1A t WHERE t.numberofEmployees = :numberofEmployees")})
public class Task1A implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Task_id")
    private String taskid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Phase")
    private String phase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Start_date")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "End_date")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Estimate_man_days")
    private String estimatemandays;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Actual_man_days")
    private String actualmandays;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Number_of_Employees")
    private String numberofEmployees;
    @JoinColumn(name = "Employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employees employeeid;
    @JoinColumn(name = "Proj_id", referencedColumnName = "Project_id")
    @ManyToOne(optional = false)
    private Projects projid;
    
    
    

    public Task1A() {
    }

    public Task1A(String taskid) {
        this.taskid = taskid;
    }

    public Task1A(String taskid, String phase, Date startdate, Date enddate, String estimatemandays, String actualmandays, String numberofEmployees) {
        this.taskid = taskid;
        this.phase = phase;
        this.startdate = startdate;
        this.enddate = enddate;
        this.estimatemandays = estimatemandays;
        this.actualmandays = actualmandays;
        this.numberofEmployees = numberofEmployees;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    
    


    public String getEstimatemandays() {
        return estimatemandays;
    }

    public void setEstimatemandays(String estimatemandays) {
        this.estimatemandays = estimatemandays;
    }

    public String getActualmandays() {
        return actualmandays;
    }

    public void setActualmandays(String actualmandays) {
        this.actualmandays = actualmandays;
    }

    public String getNumberofEmployees() {
        return numberofEmployees;
    }

    public void setNumberofEmployees(String numberofEmployees) {
        this.numberofEmployees = numberofEmployees;
    }

    public Employees getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employees employeeid) {
        this.employeeid = employeeid;
    }

    public Projects getProjid() {
        return projid;
    }

    public void setProjid(Projects projid) {
        this.projid = projid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskid != null ? taskid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task1A)) {
            return false;
        }
        Task1A other = (Task1A) object;
        if ((this.taskid == null && other.taskid != null) || (this.taskid != null && !this.taskid.equals(other.taskid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Task1A[ taskid=" + taskid + " ]";
    }
    
}
