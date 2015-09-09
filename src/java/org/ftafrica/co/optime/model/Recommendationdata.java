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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "recommendationdata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recommendationdata.findAll", query = "SELECT r FROM Recommendationdata r"),
    @NamedQuery(name = "Recommendationdata.findByRecommendationId", query = "SELECT r FROM Recommendationdata r WHERE r.recommendationId = :recommendationId"),
    @NamedQuery(name = "Recommendationdata.findByEmployeeId", query = "SELECT r FROM Recommendationdata r WHERE r.employeeId = :employeeId"),
    @NamedQuery(name = "Recommendationdata.findByRecItemId", query = "SELECT r FROM Recommendationdata r WHERE r.recItemId = :recItemId")})
public class Recommendationdata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RecommendationId")
    private Long recommendationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EmployeeId")
    private String employeeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RecItemId")
    private long recItemId;

    public Recommendationdata() {
    }

    public Recommendationdata(Long recommendationId) {
        this.recommendationId = recommendationId;
    }

    public Recommendationdata(Long recommendationId, String employeeId, long recItemId) {
        this.recommendationId = recommendationId;
        this.employeeId = employeeId;
        this.recItemId = recItemId;
    }

    public Long getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(Long recommendationId) {
        this.recommendationId = recommendationId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public long getRecItemId() {
        return recItemId;
    }

    public void setRecItemId(long recItemId) {
        this.recItemId = recItemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recommendationId != null ? recommendationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recommendationdata)) {
            return false;
        }
        Recommendationdata other = (Recommendationdata) object;
        if ((this.recommendationId == null && other.recommendationId != null) || (this.recommendationId != null && !this.recommendationId.equals(other.recommendationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Recommendationdata[ recommendationId=" + recommendationId + " ]";
    }
    
}
