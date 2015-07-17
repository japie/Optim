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
@Table(name = "succession_comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuccessionComments.findAll", query = "SELECT s FROM SuccessionComments s"),
    @NamedQuery(name = "SuccessionComments.findBySuccCommId", query = "SELECT s FROM SuccessionComments s WHERE s.succCommId = :succCommId"),
    @NamedQuery(name = "SuccessionComments.findByPlanProgress", query = "SELECT s FROM SuccessionComments s WHERE s.planProgress = :planProgress"),
    @NamedQuery(name = "SuccessionComments.findByComment", query = "SELECT s FROM SuccessionComments s WHERE s.comment = :comment"),
    @NamedQuery(name = "SuccessionComments.findByCommentDate", query = "SELECT s FROM SuccessionComments s WHERE s.commentDate = :commentDate"),
    @NamedQuery(name = "SuccessionComments.findByCommentBy", query = "SELECT s FROM SuccessionComments s WHERE s.commentBy = :commentBy")})
public class SuccessionComments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "succ_comm_id")
    private String succCommId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "plan_progress")
    private String planProgress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_date")
    @Temporal(TemporalType.DATE)
    private Date commentDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "comment_by")
    private String commentBy;
    @JoinColumn(name = "succession_plan_id", referencedColumnName = "plan_id")
    @ManyToOne(optional = false)
    private Succession successionPlanId;

    public SuccessionComments() {
    }

    public SuccessionComments(String succCommId) {
        this.succCommId = succCommId;
    }

    public SuccessionComments(String succCommId, String planProgress, String comment, Date commentDate, String commentBy) {
        this.succCommId = succCommId;
        this.planProgress = planProgress;
        this.comment = comment;
        this.commentDate = commentDate;
        this.commentBy = commentBy;
    }

    public String getSuccCommId() {
        return succCommId;
    }

    public void setSuccCommId(String succCommId) {
        this.succCommId = succCommId;
    }

    public String getPlanProgress() {
        return planProgress;
    }

    public void setPlanProgress(String planProgress) {
        this.planProgress = planProgress;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(String commentBy) {
        this.commentBy = commentBy;
    }

    public Succession getSuccessionPlanId() {
        return successionPlanId;
    }

    public void setSuccessionPlanId(Succession successionPlanId) {
        this.successionPlanId = successionPlanId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (succCommId != null ? succCommId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuccessionComments)) {
            return false;
        }
        SuccessionComments other = (SuccessionComments) object;
        if ((this.succCommId == null && other.succCommId != null) || (this.succCommId != null && !this.succCommId.equals(other.succCommId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.SuccessionComments[ succCommId=" + succCommId + " ]";
    }
    
}
