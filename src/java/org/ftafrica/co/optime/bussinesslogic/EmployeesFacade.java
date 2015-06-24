/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftafrica.co.optime.model.Employees;

/**
 *
 * @author Training 8
 */
@Stateless
public class EmployeesFacade extends AbstractFacade<Employees> implements EmployeesFacadeLocal {
    @PersistenceContext(unitName = "OptimPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeesFacade() {
        super(Employees.class);
    }
    
    /*  this method is for creating a new employee that did not exist before*/
    public boolean CreateNewEmployeeProfile(Employees employee){
    boolean result= true;
       try{ em.persist(employee);
       
       }
       catch(Exception e){
       result = false;
       }
    
    return result;
    }
    /*update info for existing user*/
    public boolean UpdateExistingEmployee(String employeeId,String surname,String name, String idNumber,String citizenship,String cellphoneNumber,String physicalAddress,String postalAddress){
       boolean result = true;
       try{
   Employees emp = em.find(Employees.class, employeeId);
   emp.setSurname(surname);
   emp.setName(name);
   emp.setIdUmber(idNumber);
   emp.setCitizenship(citizenship);
   emp.setCellphoneNumber(cellphoneNumber);
   emp.setPhysicalAddress(physicalAddress);
   emp.setPostalAddress(postalAddress);
       }
       catch(Exception e){
       result = false;
       
       }
    return result;
    }
    
    /*get employee data from db*/
    public Employees GetExistingUser(String employeeId){
    
    return em.find(Employees.class, employeeId);
    }
    
    
    
}
