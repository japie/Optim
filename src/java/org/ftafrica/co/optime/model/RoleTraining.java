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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Training 8
 */
@Entity
@Table(name = "role_training")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleTraining.findAll", query = "SELECT r FROM RoleTraining r"),
    @NamedQuery(name = "RoleTraining.findByRoleTrainingId", query = "SELECT r FROM RoleTraining r WHERE r.roleTrainingId = :roleTrainingId"),
    @NamedQuery(name = "RoleTraining.findByCourseRequirements", query = "SELECT r FROM RoleTraining r WHERE r.courseRequirements = :courseRequirements")})
public class RoleTraining implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "role_training_id")
    private String roleTrainingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 140)
    @Column(name = "course_requirements")
    private String courseRequirements;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @OneToOne(optional = false)
    private Roles roleId;
    @JoinColumn(name = "course_id", referencedColumnName = "courses_id")
    @OneToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employees employeeId;

    public RoleTraining() {
    }

    public RoleTraining(String roleTrainingId) {
        this.roleTrainingId = roleTrainingId;
    }

    public RoleTraining(String roleTrainingId, String courseRequirements) {
        this.roleTrainingId = roleTrainingId;
        this.courseRequirements = courseRequirements;
    }

    public String getRoleTrainingId() {
        return roleTrainingId;
    }

    public void setRoleTrainingId(String roleTrainingId) {
        this.roleTrainingId = roleTrainingId;
    }

    public String getCourseRequirements() {
        return courseRequirements;
    }

    public void setCourseRequirements(String courseRequirements) {
        this.courseRequirements = courseRequirements;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
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
        hash += (roleTrainingId != null ? roleTrainingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleTraining)) {
            return false;
        }
        RoleTraining other = (RoleTraining) object;
        if ((this.roleTrainingId == null && other.roleTrainingId != null) || (this.roleTrainingId != null && !this.roleTrainingId.equals(other.roleTrainingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.RoleTraining[ roleTrainingId=" + roleTrainingId + " ]";
    }
    
}
