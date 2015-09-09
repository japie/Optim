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
@Table(name = "companydata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Companydata.findAll", query = "SELECT c FROM Companydata c"),
    @NamedQuery(name = "Companydata.findByStaffNo", query = "SELECT c FROM Companydata c WHERE c.staffNo = :staffNo"),
    @NamedQuery(name = "Companydata.findByEmail", query = "SELECT c FROM Companydata c WHERE c.email = :email"),
    @NamedQuery(name = "Companydata.findById", query = "SELECT c FROM Companydata c WHERE c.id = :id"),
    @NamedQuery(name = "Companydata.findByCellphone", query = "SELECT c FROM Companydata c WHERE c.cellphone = :cellphone")})
public class Companydata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "StaffNo")
    private String staffNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Cellphone")
    private String cellphone;

    public Companydata() {
    }

    public Companydata(String staffNo) {
        this.staffNo = staffNo;
    }

    public Companydata(String staffNo, String email, long id, String cellphone) {
        this.staffNo = staffNo;
        this.email = email;
        this.id = id;
        this.cellphone = cellphone;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffNo != null ? staffNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Companydata)) {
            return false;
        }
        Companydata other = (Companydata) object;
        if ((this.staffNo == null && other.staffNo != null) || (this.staffNo != null && !this.staffNo.equals(other.staffNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Companydata[ staffNo=" + staffNo + " ]";
    }
    
}
