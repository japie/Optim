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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByRoleId", query = "SELECT r FROM Roles r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "Roles.findByRole", query = "SELECT r FROM Roles r WHERE r.role = :role"),
    @NamedQuery(name = "Roles.findByRequiredQualification", query = "SELECT r FROM Roles r WHERE r.requiredQualification = :requiredQualification"),
    @NamedQuery(name = "Roles.findByEmploymentType", query = "SELECT r FROM Roles r WHERE r.employmentType = :employmentType"),
    @NamedQuery(name = "Roles.findByCertificate", query = "SELECT r FROM Roles r WHERE r.certificate = :certificate")})
public class Roles implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleid")
    private Collection<Hiring> hiringCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleid")
    private Collection<Course> courseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleid")
    private Collection<TrainingPlan> trainingPlanCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "role_id")
    private String roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "required_qualification")
    private String requiredQualification;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "experience_required")
    private String experienceRequired;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "employment_type")
    private String employmentType;
    @Size(max = 50)
    @Column(name = "Certificate")
    private String certificate;

    public Roles() {
    }

    public Roles(String roleId) {
        this.roleId = roleId;
    }

    public Roles(String roleId, String role, String requiredQualification, String experienceRequired, String employmentType) {
        this.roleId = roleId;
        this.role = role;
        this.requiredQualification = requiredQualification;
        this.experienceRequired = experienceRequired;
        this.employmentType = employmentType;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRequiredQualification() {
        return requiredQualification;
    }

    public void setRequiredQualification(String requiredQualification) {
        this.requiredQualification = requiredQualification;
    }

    public String getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(String experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Roles[ roleId=" + roleId + " ]";
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @XmlTransient
    public Collection<TrainingPlan> getTrainingPlanCollection() {
        return trainingPlanCollection;
    }

    public void setTrainingPlanCollection(Collection<TrainingPlan> trainingPlanCollection) {
        this.trainingPlanCollection = trainingPlanCollection;
    }

    @XmlTransient
    public Collection<Hiring> getHiringCollection() {
        return hiringCollection;
    }

    public void setHiringCollection(Collection<Hiring> hiringCollection) {
        this.hiringCollection = hiringCollection;
    }
    
}
