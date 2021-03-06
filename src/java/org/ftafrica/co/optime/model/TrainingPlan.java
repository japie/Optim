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
@Table(name = "training_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrainingPlan.findAll", query = "SELECT t FROM TrainingPlan t"),
     @NamedQuery(name = "TrainingPlan.findAllEmployees", query = "SELECT t.employeeId FROM TrainingPlan t"),
    @NamedQuery(name = "TrainingPlan.findByTrainingEmpId", query = "SELECT t FROM TrainingPlan t WHERE t.employeeId.employeeId = :id"),
    @NamedQuery(name = "TrainingPlan.findSingleResult", query = "SELECT t FROM TrainingPlan t WHERE t.employeeId.employeeId = :empId AND t.courseId.coursesId = :course AND t.roleid.roleId = :roleId "),
    @NamedQuery(name = "TrainingPlan.findByTrainingId", query = "SELECT t FROM TrainingPlan t WHERE t.trainingId = :trainingId"),
    @NamedQuery(name = "TrainingPlan.findDistinctRoles", query = "SELECT DISTINCT t.roleid.roleId FROM TrainingPlan t"),
    @NamedQuery(name = "TrainingPlan.findTrainigList", query = "SELECT t FROM TrainingPlan t WHERE t.level = :lev AND t.status = :status"),
    @NamedQuery(name = "TrainingPlan.findTrainedList", query = "SELECT t FROM TrainingPlan t WHERE t.level = :lev AND t.status = :status"),
    @NamedQuery(name = "TrainingPlan.findNotTrainedList", query = "SELECT t FROM TrainingPlan t WHERE t.level = :lev AND t.status = :status"),
    @NamedQuery(name = "TrainingPlan.findByTrainingType", query = "SELECT t FROM TrainingPlan t WHERE t.trainingType = :trainingType"),
    @NamedQuery(name = "TrainingPlan.findByLevel", query = "SELECT t FROM TrainingPlan t WHERE t.level = :level"),
    @NamedQuery(name = "TrainingPlan.findByStatus", query = "SELECT t FROM TrainingPlan t WHERE t.status = :status")})
public class TrainingPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "training_id")
    private String trainingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "training_type")
    private String trainingType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Level")
    private String level;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Status")
    private String status;
    @JoinColumn(name = "Role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Roles roleid;
    @JoinColumn(name = "course_id", referencedColumnName = "courses_id")
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employees employeeId;

    public TrainingPlan() {
    }

    public TrainingPlan(String trainingId) {
        this.trainingId = trainingId;
    }

    public TrainingPlan(String trainingId, String trainingType, String level, String status) {
        this.trainingId = trainingId;
        this.trainingType = trainingType;
        this.level = level;
        this.status = status;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
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

    public Roles getRoleid() {
        return roleid;
    }

    public void setRoleid(Roles roleid) {
        this.roleid = roleid;
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
        hash += (trainingId != null ? trainingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingPlan)) {
            return false;
        }
        TrainingPlan other = (TrainingPlan) object;
        if ((this.trainingId == null && other.trainingId != null) || (this.trainingId != null && !this.trainingId.equals(other.trainingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.TrainingPlan[ trainingId=" + trainingId + " ]";
    }
    
}
