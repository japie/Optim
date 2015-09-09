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
    @NamedQuery(name = "Teams.findByProjID", query = "SELECT DISTINCT t.levels FROM Teams t WHERE t.projectid.projectid = :proj"),
    @NamedQuery(name = "Teams.findEmployeesByProjID", query = "SELECT t.employeeid FROM Teams t WHERE t.projectid.projectid = :proj"),
    @NamedQuery(name = "Teams.findEmployeesByProjID2", query = "SELECT t FROM Teams t WHERE t.projectid.projectid = :proj AND t.employeeid.employeeId = :id"),
    @NamedQuery(name = "Teams.findRolesByProjID", query = "SELECT DISTINCT t.roleid.roleId FROM Teams t WHERE t.projectid.projectid = :proj"),
    @NamedQuery(name = "Teams.findRolesByProjIdAndRole", query = "SELECT  t.employeeid FROM Teams t WHERE t.projectid.projectid = :proj AND t.roleid.roleId = :roleId"),
    @NamedQuery(name = "Teams.findByProjID2", query = "SELECT t FROM Teams t WHERE t.projectid.projectid = :projId"),
    @NamedQuery(name = "Teams.findDistinctFunctions", query = "SELECT DISTINCT t.phases FROM Teams t WHERE t.levels =:level AND t.projectid.projectid = :proj"),
    @NamedQuery(name = "Teams.findProjectTeamByLevelsAndPhases", query = "SELECT t FROM Teams t WHERE t.levels= :levels AND t.phases =:phases"),
    @NamedQuery(name = "Teams.findByTeamsid", query = "SELECT t FROM Teams t WHERE t.teamsid = :teamsid"),
    @NamedQuery(name = "Teams.findSuccessorsByProject", query = "SELECT t.employeeid.employeeId FROM Teams t WHERE t.employeeid.employeeId IN :empId AND t.projectid.projectid = (SELECT t.projectid.projectid FROM Teams t WHERE t.employeeid.employeeId = :predessesorId)"),
    @NamedQuery(name = "Teams.findByTeamrecordid", query = "SELECT t FROM Teams t WHERE t.teamrecordid = :teamrecordid"),
    @NamedQuery(name = "Teams.findProjByEmployeeId", query = "SELECT t.projectid.projectName FROM Teams t WHERE t.employeeid.employeeId = :empId"),
    @NamedQuery(name = "Teams.findAMemberByEmployeeId", query = "SELECT t FROM Teams t WHERE t.employeeid.employeeId = :empId"),
    @NamedQuery(name = "Teams.findByDepartmentid", query = "SELECT t FROM Teams t WHERE t.departmentid = :departmentid"),
    @NamedQuery(name = "Teams.findByLevels", query = "SELECT t FROM Teams t WHERE t.levels = :levels"),
    @NamedQuery(name = "Teams.findByPhases", query = "SELECT t FROM Teams t WHERE t.phases = :phases")})
public class Teams implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Teams_id")
    private String teamsid;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Levels")
    private String levels;
    @Size(max = 30)
    @Column(name = "Phases")
    private String phases;
    @JoinColumn(name = "Role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Roles roleid;
    @JoinColumn(name = "Supervisor_id", referencedColumnName = "employee_id")
    @ManyToOne
    private Employees supervisorid;
    @JoinColumn(name = "Employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employees employeeid;
    @JoinColumn(name = "Project_id", referencedColumnName = "Project_id")
    @ManyToOne(optional = false)
    private Projects projectid;

    public Teams() {
    }

    public Teams(String teamsid) {
        this.teamsid = teamsid;
    }

    public Teams(String teamsid, String teamrecordid, String departmentid, String levels) {
        this.teamsid = teamsid;
        this.teamrecordid = teamrecordid;
        this.departmentid = departmentid;
        this.levels = levels;
    }

    public String getTeamsid() {
        return teamsid;
    }

    public void setTeamsid(String teamsid) {
        this.teamsid = teamsid;
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

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public String getPhases() {
        return phases;
    }

    public void setPhases(String phases) {
        this.phases = phases;
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
        hash += (teamsid != null ? teamsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teams)) {
            return false;
        }
        Teams other = (Teams) object;
        if ((this.teamsid == null && other.teamsid != null) || (this.teamsid != null && !this.teamsid.equals(other.teamsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Teams[ teamsid=" + teamsid + " ]";
    }
    
}
