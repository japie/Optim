/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Training 8
 */
@Entity
@Table(name = "hiring")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hiring.findAll", query = "SELECT h FROM Hiring h"),
    @NamedQuery(name = "Hiring.findByRoleid", query = "SELECT h FROM Hiring h WHERE h.roleid = :roleid"),
    @NamedQuery(name = "Hiring.findAllHiring", query = "SELECT h FROM Hiring h WHERE h.projectId.projectid = :ProjId AND h.status = :status "),
    @NamedQuery(name = "Hiring.findByLevel", query = "SELECT h FROM Hiring h WHERE h.level = :level"),
    @NamedQuery(name = "Hiring.findByStatus", query = "SELECT h FROM Hiring h WHERE h.status = :status"),
    @NamedQuery(name = "Hiring.findByHiringid", query = "SELECT h FROM Hiring h WHERE h.hiringid = :hiringid"),
    @NamedQuery(name = "Hiring.findByExperience", query = "SELECT h FROM Hiring h WHERE h.experience = :experience"),
    @NamedQuery(name = "Hiring.findByPosition", query = "SELECT h FROM Hiring h WHERE h.position = :position")})
public class Hiring implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Role_id")
    private String roleid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Level")
    private String level;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Status")
    private String status;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Hiring_id")
    private Integer hiringid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Experience")
    private String experience;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Position")
    private String position;
    @JoinColumn(name = "Employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employees employeeid;
    @JoinColumn(name = "project_id", referencedColumnName = "Project_id")
    @ManyToOne(optional = false)
    private Projects projectId;

    public Hiring() {
    }

    public Hiring(Integer hiringid) {
        this.hiringid = hiringid;
    }

    public Hiring(Integer hiringid, String roleid, String level, String status, String experience, String position) {
        this.hiringid = hiringid;
        this.roleid = roleid;
        this.level = level;
        this.status = status;
        this.experience = experience;
        this.position = position;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getHiringid() {
        return hiringid;
    }

    public void setHiringid(Integer hiringid) {
        this.hiringid = hiringid;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employees getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employees employeeid) {
        this.employeeid = employeeid;
    }

    public Projects getProjectId() {
        return projectId;
    }

    public void setProjectId(Projects projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hiringid != null ? hiringid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hiring)) {
            return false;
        }
        Hiring other = (Hiring) object;
        if ((this.hiringid == null && other.hiringid != null) || (this.hiringid != null && !this.hiringid.equals(other.hiringid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Hiring[ hiringid=" + hiringid + " ]";
    }
    
}
