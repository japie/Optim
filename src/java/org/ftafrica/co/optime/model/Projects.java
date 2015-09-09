/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Training 8
 */
@Entity
@Table(name = "projects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projects.findAll", query = "SELECT p FROM Projects p"),
    @NamedQuery(name = "Projects.findByProjectid", query = "SELECT p FROM Projects p WHERE p.projectid = :projectid"),
    @NamedQuery(name = "Projects.findByProjectName", query = "SELECT p FROM Projects p WHERE p.projectName = :projectName"),
    @NamedQuery(name = "Projects.findByCapacity", query = "SELECT p FROM Projects p WHERE p.capacity = :capacity"),
    @NamedQuery(name = "Projects.findByProjectbudget", query = "SELECT p FROM Projects p WHERE p.projectbudget = :projectbudget"),
    @NamedQuery(name = "Projects.findByProjectActualExpense", query = "SELECT p FROM Projects p WHERE p.projectActualExpense = :projectActualExpense"),
    @NamedQuery(name = "Projects.findByStartdate", query = "SELECT p FROM Projects p WHERE p.startdate = :startdate"),
    @NamedQuery(name = "Projects.findByEnddate", query = "SELECT p FROM Projects p WHERE p.enddate = :enddate"),
    @NamedQuery(name = "Projects.findByProjectTeam", query = "SELECT p FROM Projects p WHERE p.projectTeam = :projectTeam"),
    @NamedQuery(name = "Projects.findByProjectphases", query = "SELECT p FROM Projects p WHERE p.projectphases = :projectphases"),
    @NamedQuery(name = "Projects.findByStatus", query = "SELECT p FROM Projects p WHERE p.status = :status"),
    @NamedQuery(name = "Projects.findByContractperiod", query = "SELECT p FROM Projects p WHERE p.contractperiod = :contractperiod"),
    @NamedQuery(name = "Projects.findByProjectmanager", query = "SELECT p FROM Projects p WHERE p.projectmanager = :projectmanager"),
    @NamedQuery(name = "Projects.findDistinctByProjectmanager", query = "SELECT p.projectid FROM Projects p WHERE p.projectmanager = :projectmanager"),
    @NamedQuery(name = "Projects.findByDuration", query = "SELECT p FROM Projects p WHERE p.duration = :duration"),
    @NamedQuery(name = "Projects.findByDepartment", query = "SELECT p FROM Projects p WHERE p.department = :department")})
public class Projects implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projid")
    private Collection<Task1A> task1ACollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Project_id")
    private String projectid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Project_Name")
    private String projectName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Capacity")
    private String capacity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Project_budget")
    private Double projectbudget;
    @Column(name = "Project_Actual_Expense")
    private Double projectActualExpense;
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
    @Size(min = 1, max = 50)
    @Column(name = "Project_Team")
    private String projectTeam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Project_phases")
    private long projectphases;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Contract_period")
    private long contractperiod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Project_manager")
    private String projectmanager;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Duration")
    private String duration;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Department")
    private String department;

    public Projects() {
    }

    public Projects(String projectid) {
        this.projectid = projectid;
    }

    public Projects(String projectid, String projectName, String capacity, Date startdate, Date enddate, String projectTeam, long projectphases, String status, long contractperiod, String projectmanager, String duration, String department) {
        this.projectid = projectid;
        this.projectName = projectName;
        this.capacity = capacity;
        this.startdate = startdate;
        this.enddate = enddate;
        this.projectTeam = projectTeam;
        this.projectphases = projectphases;
        this.status = status;
        this.contractperiod = contractperiod;
        this.projectmanager = projectmanager;
        this.duration = duration;
        this.department = department;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Double getProjectbudget() {
        return projectbudget;
    }

    public void setProjectbudget(Double projectbudget) {
        this.projectbudget = projectbudget;
    }

    public Double getProjectActualExpense() {
        return projectActualExpense;
    }

    public void setProjectActualExpense(Double projectActualExpense) {
        this.projectActualExpense = projectActualExpense;
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

    public String getProjectTeam() {
        return projectTeam;
    }

    public void setProjectTeam(String projectTeam) {
        this.projectTeam = projectTeam;
    }

    public long getProjectphases() {
        return projectphases;
    }

    public void setProjectphases(long projectphases) {
        this.projectphases = projectphases;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getContractperiod() {
        return contractperiod;
    }

    public void setContractperiod(long contractperiod) {
        this.contractperiod = contractperiod;
    }

    public String getProjectmanager() {
        return projectmanager;
    }

    public void setProjectmanager(String projectmanager) {
        this.projectmanager = projectmanager;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectid != null ? projectid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projects)) {
            return false;
        }
        Projects other = (Projects) object;
        if ((this.projectid == null && other.projectid != null) || (this.projectid != null && !this.projectid.equals(other.projectid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Projects[ projectid=" + projectid + " ]";
    }

    @XmlTransient
    public Collection<Task1A> getTask1ACollection() {
        return task1ACollection;
    }

    public void setTask1ACollection(Collection<Task1A> task1ACollection) {
        this.task1ACollection = task1ACollection;
    }
    
}
