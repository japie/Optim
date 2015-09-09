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
@Table(name = "succession_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuccessionDetails.findAll", query = "SELECT s FROM SuccessionDetails s"),
    @NamedQuery(name = "SuccessionDetails.findBySuccessionId", query = "SELECT s FROM SuccessionDetails s WHERE s.successionId = :successionId"),
    @NamedQuery(name = "SuccessionDetails.findByStatus", query = "SELECT s FROM SuccessionDetails s WHERE s.status = :status")})
public class SuccessionDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "succession_id")
    private String successionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "course_id", referencedColumnName = "courses_id")
    @OneToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "plan_id", referencedColumnName = "plan_id")
    @ManyToOne(optional = false)
    private Succession planId;

    public SuccessionDetails() {
    }

    public SuccessionDetails(String successionId) {
        this.successionId = successionId;
    }

    public SuccessionDetails(String successionId, boolean status) {
        this.successionId = successionId;
        this.status = status;
    }

    public String getSuccessionId() {
        return successionId;
    }

    public void setSuccessionId(String successionId) {
        this.successionId = successionId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Succession getPlanId() {
        return planId;
    }

    public void setPlanId(Succession planId) {
        this.planId = planId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (successionId != null ? successionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuccessionDetails)) {
            return false;
        }
        SuccessionDetails other = (SuccessionDetails) object;
        if ((this.successionId == null && other.successionId != null) || (this.successionId != null && !this.successionId.equals(other.successionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.SuccessionDetails[ successionId=" + successionId + " ]";
    }
    
}
