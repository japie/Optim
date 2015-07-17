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
@Table(name = "teams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teams.findAll", query = "SELECT t FROM Teams t"),
    @NamedQuery(name = "Teams.findByTeamrecordid", query = "SELECT t FROM Teams t WHERE t.teamrecordid = :teamrecordid"),
    @NamedQuery(name = "Teams.findByProjID", query = "SELECT DISTINCT t.levels FROM Teams t WHERE t.projectid.projectid = :proj"),
    @NamedQuery(name = "Teams.findAllByProjID", query = "SELECT DISTINCT t FROM Teams t WHERE t.projectid.projectid = :proj"),
    @NamedQuery(name = "Teams.findByTeamsEmpId", query = "SELECT t FROM Teams t WHERE t.employeeid.employeeId = :id"),
    @NamedQuery(name = "Teams.findByDepartmentid", query = "SELECT t FROM Teams t WHERE t.departmentid = :departmentid")})
public class Teams implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Levels")
    private String levels;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Team_record_id")
    private String teamrecordid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Department_id")
    private String departmentid;
    @JoinColumn(name = "Role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Roles roleid;
    @JoinColumn(name = "Supervisor_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employees supervisorid;
    @JoinColumn(name = "Employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employees employeeid;
    @JoinColumn(name = "Project_id", referencedColumnName = "Project_id")
    @ManyToOne(optional = false)
    private Projects projectid;

    public Teams() {
    }

    public Teams(String teamrecordid) {
        this.teamrecordid = teamrecordid;
    }

    public Teams(String teamrecordid, String departmentid) {
        this.teamrecordid = teamrecordid;
        this.departmentid = departmentid;
    }

    public String getTeamrecordid() {
        return teamrecordid;
    }

    public void setTeamrecordid(String teamrecordid) {
        this.teamrecordid = teamrecordid;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public Roles getRoleid() {
        return roleid;
    }

    public void setRoleid(Roles roleid) {
        this.roleid = roleid;
    }

    public Employees getSupervisorid() {
        return supervisorid;
    }

    public void setSupervisorid(Employees supervisorid) {
        this.supervisorid = supervisorid;
    }

    public Employees getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employees employeeid) {
        this.employeeid = employeeid;
    }

    public Projects getProjectid() {
        return projectid;
    }

    public void setProjectid(Projects projectid) {
        this.projectid = projectid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamrecordid != null ? teamrecordid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teams)) {
            return false;
        }
        Teams other = (Teams) object;
        if ((this.teamrecordid == null && other.teamrecordid != null) || (this.teamrecordid != null && !this.teamrecordid.equals(other.teamrecordid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Teams[ teamrecordid=" + teamrecordid + " ]";
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }
    
}
