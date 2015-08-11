/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Training 8
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCoursesId", query = "SELECT c FROM Course c WHERE c.coursesId = :coursesId"),
    @NamedQuery(name = "Course.findByRoleId", query = "SELECT c FROM Course c WHERE c.roleid.roleId = :roleId"),
    @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName"),
    @NamedQuery(name = "Course.findByCourseDuration", query = "SELECT c FROM Course c WHERE c.courseDuration = :courseDuration"),
    @NamedQuery(name = "Course.findByCourseCost", query = "SELECT c FROM Course c WHERE c.courseCost = :courseCost")})
public class Course implements Serializable {
    @JoinColumn(name = "Role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Roles roleid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<TrainingPlan> trainingPlanCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "courses_id")
    private String coursesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "course_name")
    private String courseName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "course_duration")
    private int courseDuration;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "course_cost")
    private Double courseCost;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "courseId")
    private RoleTraining roleTraining;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "courseId")
    private TrainingPlan trainingPlan;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "courseId")
    private SuccessionDetails successionDetails;

    public Course() {
    }

    public Course(String coursesId) {
        this.coursesId = coursesId;
    }

    public Course(String coursesId, String courseName, int courseDuration) {
        this.coursesId = coursesId;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
    }

    public String getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(String coursesId) {
        this.coursesId = coursesId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Double courseCost) {
        this.courseCost = courseCost;
    }

    public RoleTraining getRoleTraining() {
        return roleTraining;
    }

    public void setRoleTraining(RoleTraining roleTraining) {
        this.roleTraining = roleTraining;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public SuccessionDetails getSuccessionDetails() {
        return successionDetails;
    }

    public void setSuccessionDetails(SuccessionDetails successionDetails) {
        this.successionDetails = successionDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coursesId != null ? coursesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.coursesId == null && other.coursesId != null) || (this.coursesId != null && !this.coursesId.equals(other.coursesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Course[ coursesId=" + coursesId + " ]";
    }

    @XmlTransient
    public Collection<TrainingPlan> getTrainingPlanCollection() {
        return trainingPlanCollection;
    }

    public void setTrainingPlanCollection(Collection<TrainingPlan> trainingPlanCollection) {
        this.trainingPlanCollection = trainingPlanCollection;
    }

    public Roles getRoleid() {
        return roleid;
    }

    public void setRoleid(Roles roleid) {
        this.roleid = roleid;
    }
    
}
