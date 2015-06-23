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
import javax.persistence.OneToOne;
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
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByEmployeeId", query = "SELECT e FROM Employees e WHERE e.employeeId = :employeeId"),
    @NamedQuery(name = "Employees.findBySurname", query = "SELECT e FROM Employees e WHERE e.surname = :surname"),
    @NamedQuery(name = "Employees.findByName", query = "SELECT e FROM Employees e WHERE e.name = :name"),
    @NamedQuery(name = "Employees.findByCitizenship", query = "SELECT e FROM Employees e WHERE e.citizenship = :citizenship"),
    @NamedQuery(name = "Employees.findByPhysicalAddress", query = "SELECT e FROM Employees e WHERE e.physicalAddress = :physicalAddress"),
    @NamedQuery(name = "Employees.findByPostalAddress", query = "SELECT e FROM Employees e WHERE e.postalAddress = :postalAddress")})
public class Employees implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "employee_id")
    private String employeeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "id_umber")
    private String idUmber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "citizenship")
    private String citizenship;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "cellphone_number")
    private String cellphoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "physical_address")
    private String physicalAddress;
    @Size(max = 100)
    @Column(name = "postal_address")
    private String postalAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<RoleTraining> roleTrainingCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "successor")
    private Succession succession;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "predecessor")
    private Succession succession1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private TrainingPlan trainingPlan;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Education education;

    public Employees() {
    }

    public Employees(String employeeId) {
        this.employeeId = employeeId;
    }

    public Employees(String employeeId, String surname, String name, String idUmber, String citizenship, String cellphoneNumber, String physicalAddress) {
        this.employeeId = employeeId;
        this.surname = surname;
        this.name = name;
        this.idUmber = idUmber;
        this.citizenship = citizenship;
        this.cellphoneNumber = cellphoneNumber;
        this.physicalAddress = physicalAddress;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdUmber() {
        return idUmber;
    }

    public void setIdUmber(String idUmber) {
        this.idUmber = idUmber;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    @XmlTransient
    public Collection<RoleTraining> getRoleTrainingCollection() {
        return roleTrainingCollection;
    }

    public void setRoleTrainingCollection(Collection<RoleTraining> roleTrainingCollection) {
        this.roleTrainingCollection = roleTrainingCollection;
    }

    public Succession getSuccession() {
        return succession;
    }

    public void setSuccession(Succession succession) {
        this.succession = succession;
    }

    public Succession getSuccession1() {
        return succession1;
    }

    public void setSuccession1(Succession succession1) {
        this.succession1 = succession1;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ftafrica.co.optime.model.Employees[ employeeId=" + employeeId + " ]";
    }
    
}
