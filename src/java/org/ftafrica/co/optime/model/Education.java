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
@Table(name = "education")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e"),
    @NamedQuery(name = "Education.findByEducationId", query = "SELECT e FROM Education e WHERE e.educationId = :educationId"),
    @NamedQuery(name = "Education.findByQualifiaction", query = "SELECT e FROM Education e WHERE e.qualifiaction = :qualifiaction"),
    @NamedQuery(name = "Education.findByInstitution", query = "SELECT e FROM Education e WHERE e.institution = :institution"),
    @NamedQuery(name = "Education.findByYearCompleted", query = "SELECT e FROM Education e WHERE e.yearCompleted = :yearCompleted")})
public class Education implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "file")
    private byte[] file;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "qualification")
    private String qualification;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "education_id")
    private String educationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "qualifiaction")
    private String qualifiaction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "institution")
    private String institution;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year_completed")
    @Temporal(TemporalType.DATE)
    private Date yearCompleted;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employees employeeId;

    public Education() {
    }

    public Education(String educationId) {
        this.educationId = educationId;
    }

    public Education(String educationId, String qualifiaction, String institution, Date yearCompleted, byte[] file) {
        this.educationId = educationId;
        this.qualifiaction = qualifiaction;
        this.institution = institution;
        this.yearCompleted = yearCompleted;
        this.file = file;
    }

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public String getQualifiaction() {
        return qualifiaction;
    }

    public void setQualifiaction(String qualifiaction) {
        this.qualifiaction = qualifiaction;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Date getYearCompleted() {
        return yearCompleted;
    }

    public void setYearCompleted(Date yearCompleted) {
        this.yearCompleted = yearCompleted;
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
        hash += (educationId != null ? educationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
        if ((this.educationId == null && other.educationId != null) || (this.educationId != null && !this.educationId.equals(other.educationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Education[ educationId=" + educationId + " ]";
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
    
}
