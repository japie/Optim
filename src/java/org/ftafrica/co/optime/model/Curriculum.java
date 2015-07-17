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
@Table(name = "curriculum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curriculum.findAll", query = "SELECT c FROM Curriculum c"),
    @NamedQuery(name = "Curriculum.findByCurriculumid", query = "SELECT c FROM Curriculum c WHERE c.curriculumid = :curriculumid"),
    @NamedQuery(name = "Curriculum.findByCurriculummodules", query = "SELECT c FROM Curriculum c WHERE c.curriculummodules = :curriculummodules")})
public class Curriculum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Curriculum_id")
    private String curriculumid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Curriculum_modules")
    private String curriculummodules;

    public Curriculum() {
    }

    public Curriculum(String curriculumid) {
        this.curriculumid = curriculumid;
    }

    public Curriculum(String curriculumid, String curriculummodules) {
        this.curriculumid = curriculumid;
        this.curriculummodules = curriculummodules;
    }

    public String getCurriculumid() {
        return curriculumid;
    }

    public void setCurriculumid(String curriculumid) {
        this.curriculumid = curriculumid;
    }

    public String getCurriculummodules() {
        return curriculummodules;
    }

    public void setCurriculummodules(String curriculummodules) {
        this.curriculummodules = curriculummodules;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curriculumid != null ? curriculumid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curriculum)) {
            return false;
        }
        Curriculum other = (Curriculum) object;
        if ((this.curriculumid == null && other.curriculumid != null) || (this.curriculumid != null && !this.curriculumid.equals(other.curriculumid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Curriculum[ curriculumid=" + curriculumid + " ]";
    }
    
}
