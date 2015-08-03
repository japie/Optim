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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid")
    private Collection<Hiring> hiringCollection;
    
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
    private Collection<Work> workCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "successor")
    private Collection<Succession> successionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predecessor")
    private Collection<Succession> successionCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<LoginDetails> loginDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<Education> educationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<RoleTraining> roleTrainingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supervisorid")
    private Collection<Teams> teamsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid")
    private Collection<Teams> teamsCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<TrainingPlan> trainingPlanCollection;

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
    public Collection<Work> getWorkCollection() {
        return workCollection;
    }

    public void setWorkCollection(Collection<Work> workCollection) {
        this.workCollection = workCollection;
    }

    @XmlTransient
    public Collection<Succession> getSuccessionCollection() {
        return successionCollection;
    }

    public void setSuccessionCollection(Collection<Succession> successionCollection) {
        this.successionCollection = successionCollection;
    }

    @XmlTransient
    public Collection<Succession> getSuccessionCollection1() {
        return successionCollection1;
    }

    public void setSuccessionCollection1(Collection<Succession> successionCollection1) {
        this.successionCollection1 = successionCollection1;
    }

    @XmlTransient
    public Collection<LoginDetails> getLoginDetailsCollection() {
        return loginDetailsCollection;
    }

    public void setLoginDetailsCollection(Collection<LoginDetails> loginDetailsCollection) {
        this.loginDetailsCollection = loginDetailsCollection;
    }

    @XmlTransient
    public Collection<Education> getEducationCollection() {
        return educationCollection;
    }

    public void setEducationCollection(Collection<Education> educationCollection) {
        this.educationCollection = educationCollection;
    }

    @XmlTransient
    public Collection<RoleTraining> getRoleTrainingCollection() {
        return roleTrainingCollection;
    }

    public void setRoleTrainingCollection(Collection<RoleTraining> roleTrainingCollection) {
        this.roleTrainingCollection = roleTrainingCollection;
    }

    @XmlTransient
    public Collection<Teams> getTeamsCollection() {
        return teamsCollection;
    }

    public void setTeamsCollection(Collection<Teams> teamsCollection) {
        this.teamsCollection = teamsCollection;
    }

    @XmlTransient
    public Collection<Teams> getTeamsCollection1() {
        return teamsCollection1;
    }

    public void setTeamsCollection1(Collection<Teams> teamsCollection1) {
        this.teamsCollection1 = teamsCollection1;
    }

    @XmlTransient
    public Collection<TrainingPlan> getTrainingPlanCollection() {
        return trainingPlanCollection;
    }

    public void setTrainingPlanCollection(Collection<TrainingPlan> trainingPlanCollection) {
        this.trainingPlanCollection = trainingPlanCollection;
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

    @XmlTransient
    public Collection<Hiring> getHiringCollection() {
        return hiringCollection;
    }

    public void setHiringCollection(Collection<Hiring> hiringCollection) {
        this.hiringCollection = hiringCollection;
    }

    
    
}
