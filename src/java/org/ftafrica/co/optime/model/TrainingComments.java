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
@Table(name = "training_comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrainingComments.findAll", query = "SELECT t FROM TrainingComments t"),
    @NamedQuery(name = "TrainingComments.findByTrainingCommId", query = "SELECT t FROM TrainingComments t WHERE t.trainingCommId = :trainingCommId"),
    @NamedQuery(name = "TrainingComments.findByComment", query = "SELECT t FROM TrainingComments t WHERE t.comment = :comment"),
    @NamedQuery(name = "TrainingComments.findByCommentDate", query = "SELECT t FROM TrainingComments t WHERE t.commentDate = :commentDate"),
    @NamedQuery(name = "TrainingComments.findByCommentBy", query = "SELECT t FROM TrainingComments t WHERE t.commentBy = :commentBy")})
public class TrainingComments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "training_comm_id")
    private String trainingCommId;
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
    @JoinColumn(name = "training_id", referencedColumnName = "training_id")
    @ManyToOne(optional = false)
    private TrainingPlan trainingId;

    public TrainingComments() {
    }

    public TrainingComments(String trainingCommId) {
        this.trainingCommId = trainingCommId;
    }

    public TrainingComments(String trainingCommId, String comment, Date commentDate, String commentBy) {
        this.trainingCommId = trainingCommId;
        this.comment = comment;
        this.commentDate = commentDate;
        this.commentBy = commentBy;
    }

    public String getTrainingCommId() {
        return trainingCommId;
    }

    public void setTrainingCommId(String trainingCommId) {
        this.trainingCommId = trainingCommId;
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

    public TrainingPlan getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(TrainingPlan trainingId) {
        this.trainingId = trainingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainingCommId != null ? trainingCommId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrainingComments)) {
            return false;
        }
        TrainingComments other = (TrainingComments) object;
        if ((this.trainingCommId == null && other.trainingCommId != null) || (this.trainingCommId != null && !this.trainingCommId.equals(other.trainingCommId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.TrainingComments[ trainingCommId=" + trainingCommId + " ]";
    }
    
}
