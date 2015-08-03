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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "succession")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Succession.findAll", query = "SELECT s FROM Succession s"),
    @NamedQuery(name = "Succession.findByPre", query = "SELECT s FROM Succession s WHERE s.predecessor.employeeId =:pre"),
    @NamedQuery(name = "Succession.FindNull", query = "SELECT s FROM Succession s WHERE s.successor IS NULL"),
    @NamedQuery(name = "Succession.findByPlanId", query = "SELECT s FROM Succession s WHERE s.planId = :planId"),
    @NamedQuery(name = "Succession.findByList", query = "SELECT s FROM Succession s WHERE s.level = :lev"),
    @NamedQuery(name = "Succession.findByPredEndDate", query = "SELECT s FROM Succession s WHERE s.predEndDate = :predEndDate"),
    @NamedQuery(name = "Succession.findBySuccessorStartDate", query = "SELECT s FROM Succession s WHERE s.successorStartDate = :successorStartDate"),
    @NamedQuery(name = "Succession.findByPlanStartDate", query = "SELECT s FROM Succession s WHERE s.planStartDate = :planStartDate"),
    @NamedQuery(name = "Succession.findByPlanEndDate", query = "SELECT s FROM Succession s WHERE s.planEndDate = :planEndDate"),
    @NamedQuery(name = "Succession.findByLastEditedBy", query = "SELECT s FROM Succession s WHERE s.lastEditedBy = :lastEditedBy"),
    @NamedQuery(name = "Succession.findByPlanDescription", query = "SELECT s FROM Succession s WHERE s.planDescription = :planDescription")})
public class Succession implements Serializable {
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
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "plan_id")
    private String planId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pred_end_date")
    @Temporal(TemporalType.DATE)
    private Date predEndDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "successor_start_date")
    @Temporal(TemporalType.DATE)
    private Date successorStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plan_start_date")
    @Temporal(TemporalType.DATE)
    private Date planStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plan_end_date")
    @Temporal(TemporalType.DATE)
    private Date planEndDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "last_edited_by")
    private String lastEditedBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "plan_description")
    private String planDescription;
    @JoinColumn(name = "successor", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employees successor;
    @JoinColumn(name = "predecessor", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employees predecessor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "successionPlanId")
    private Collection<SuccessionComments> successionCommentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planId")
    private Collection<SuccessionDetails> successionDetailsCollection;

    public Succession() {
    }

    public Succession(String planId) {
        this.planId = planId;
    }

    public Succession(String planId, Date predEndDate, Date successorStartDate, Date planStartDate, Date planEndDate, String lastEditedBy, String planDescription) {
        this.planId = planId;
        this.predEndDate = predEndDate;
        this.successorStartDate = successorStartDate;
        this.planStartDate = planStartDate;
        this.planEndDate = planEndDate;
        this.lastEditedBy = lastEditedBy;
        this.planDescription = planDescription;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public Date getPredEndDate() {
        return predEndDate;
    }

    public void setPredEndDate(Date predEndDate) {
        this.predEndDate = predEndDate;
    }

    public Date getSuccessorStartDate() {
        return successorStartDate;
    }

    public void setSuccessorStartDate(Date successorStartDate) {
        this.successorStartDate = successorStartDate;
    }

    public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    public String getLastEditedBy() {
        return lastEditedBy;
    }

    public void setLastEditedBy(String lastEditedBy) {
        this.lastEditedBy = lastEditedBy;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    public Employees getSuccessor() {
        return successor;
    }

    public void setSuccessor(Employees successor) {
        this.successor = successor;
    }

    public Employees getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Employees predecessor) {
        this.predecessor = predecessor;
    }

    @XmlTransient
    public Collection<SuccessionComments> getSuccessionCommentsCollection() {
        return successionCommentsCollection;
    }

    public void setSuccessionCommentsCollection(Collection<SuccessionComments> successionCommentsCollection) {
        this.successionCommentsCollection = successionCommentsCollection;
    }

    @XmlTransient
    public Collection<SuccessionDetails> getSuccessionDetailsCollection() {
        return successionDetailsCollection;
    }

    public void setSuccessionDetailsCollection(Collection<SuccessionDetails> successionDetailsCollection) {
        this.successionDetailsCollection = successionDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planId != null ? planId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Succession)) {
            return false;
        }
        Succession other = (Succession) object;
        if ((this.planId == null && other.planId != null) || (this.planId != null && !this.planId.equals(other.planId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Succession[ planId=" + planId + " ]";
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
    
}
