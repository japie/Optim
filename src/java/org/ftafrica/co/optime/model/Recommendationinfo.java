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
@Table(name = "recommendationinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recommendationinfo.findAll", query = "SELECT r FROM Recommendationinfo r"),
    @NamedQuery(name = "Recommendationinfo.findByRecInfoId", query = "SELECT r FROM Recommendationinfo r WHERE r.recInfoId = :recInfoId"),
    @NamedQuery(name = "Recommendationinfo.findByRecItemName", query = "SELECT r FROM Recommendationinfo r WHERE r.recItemName = :recItemName")})
public class Recommendationinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RecInfoId")
    private Long recInfoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RecItemName")
    private String recItemName;

    public Recommendationinfo() {
    }

    public Recommendationinfo(Long recInfoId) {
        this.recInfoId = recInfoId;
    }

    public Recommendationinfo(Long recInfoId, String recItemName) {
        this.recInfoId = recInfoId;
        this.recItemName = recItemName;
    }

    public Long getRecInfoId() {
        return recInfoId;
    }

    public void setRecInfoId(Long recInfoId) {
        this.recInfoId = recInfoId;
    }

    public String getRecItemName() {
        return recItemName;
    }

    public void setRecItemName(String recItemName) {
        this.recItemName = recItemName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recInfoId != null ? recInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recommendationinfo)) {
            return false;
        }
        Recommendationinfo other = (Recommendationinfo) object;
        if ((this.recInfoId == null && other.recInfoId != null) || (this.recInfoId != null && !this.recInfoId.equals(other.recInfoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Recommendationinfo[ recInfoId=" + recInfoId + " ]";
    }
    
}
