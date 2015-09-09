/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftafrica.co.optime.Helper.employee.Employee;
import org.ftafrica.co.optime.Helper.employee.EmployeeListHelper;
import org.ftafrica.co.optime.model.Education;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Teams;
import org.ftafrica.co.optime.model.Work;

/**
 *
 * @author Training 8
 */
@Stateless
public class EmployeesFacade extends AbstractFacade<Employees>  {
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
    public boolean UpdateExistingEmployee(String employeeId,String MaritalStatus,String email,String AreaCode,int revelentExp,int generalExp,String surname,String name, String idNumber,String citizenship,String cellphoneNumber,String physicalAddress,String postalAddress,String Level, String Position,Date StartDate,Date EndDate,double Salary, String Status){
       boolean result = true;
       
        Work work = new Work();
      
        try{
        work = em.createNamedQuery("Work.findByWorkEmpId",Work.class).setParameter("id",employeeId).getSingleResult();
        }catch(Exception e){
        
        }
        
       try{
   Employees emp = em.find(Employees.class, employeeId);
   emp.setSurname(surname);
   emp.setName(name);
   emp.setIdUmber(idNumber);
   emp.setCitizenship(citizenship);
   emp.setCellphoneNumber(cellphoneNumber);
   emp.setPhysicalAddress(physicalAddress);
   emp.setPostalAddress(postalAddress);
  emp.setAreaCode(AreaCode);
  emp.setMaritalstatus(MaritalStatus);
  emp.setEmailAddress(email);
  
  work.setRelevantExperience(revelentExp);
  work.setGeneralExperience(generalExp);
  work.setLevel(Level);
  work.setSalaryRange(Salary);
  work.setStartDate(StartDate);
  work.setStatus(Status);
  work.setEndDate(EndDate);
  work.setPosition(Position);
 
  
  
       }
       catch(Exception e){
       result = false;
       
       }
    return result;
    }
    
    public Employee GetExistingEmployee(String EmployeeId){
        
        Employees employees = em.find(Employees.class, EmployeeId);
        Employee employee = new Employee();
        Work work = new Work();
        Education education = new Education();
        String teams = null ;
        try{
        work = em.createNamedQuery("Work.findByWorkEmpId",Work.class).setParameter("id",EmployeeId).getSingleResult();
        }
        
        catch(Exception e){
        }
        try{
        education = em.createNamedQuery("Education.findByEmployeeId",Education.class).setParameter("id", EmployeeId).getSingleResult();
        }
        
        catch(Exception d){
        }
        
        try{
        teams = em.createNamedQuery("Teams.findProjByEmployeeId",String.class).setParameter("empId", EmployeeId).getSingleResult();
        }
        
        catch(Exception d){
        }
        employee.setAreaCode(employees.getAreaCode());
        employee.setCellphoneNumber(employees.getCellphoneNumber());
        employee.setCitizenship(employees.getCitizenship());
        employee.setEmailAddress(employees.getEmailAddress());
        employee.setEmployeeID(employees.getEmployeeId());
        employee.setGeneralExpirience(work.getGeneralExperience());
        employee.setIdNumber(employees.getIdUmber());
        employee.setInstitution(education.getInstitution());
        employee.setLevel(work.getLevel());
        employee.setMaritalStatus(employees.getMaritalstatus());
        employee.setName(employees.getName());
        employee.setPhyisicalAddress(employees.getPhysicalAddress());
        employee.setPosition(work.getPosition());
        employee.setPostalAddress(employees.getPostalAddress());
        employee.setQualification(education.getQualification());
        employee.setRevelantExpirience(work.getRelevantExperience());
        employee.setSalaryRange(BigDecimal.valueOf(work.getSalaryRange()));
        employee.setStartDate(work.getStartDate().toString());
        employee.setSurname(employees.getSurname());
        employee.setProjectName(teams);
        
        
        
        
    return employee;
    
    }
    public List<EmployeeListHelper> GenerateAllEmployeesProfile(){
    List<Employees> Employeelist = em.createNamedQuery("Employees.findAll", Employees.class).getResultList();
    List<EmployeeListHelper> EmpList = new ArrayList();
    
    for(Employees emp: Employeelist){ 
        EmployeeListHelper empllist = new EmployeeListHelper();
        Teams empRole = new Teams();
        try{
        empRole = em.createNamedQuery("Teams.findAMemberByEmployeeId",Teams.class).setParameter("empId", emp.getEmployeeId()).getSingleResult();
        }catch(Exception s){}
          
        Education empEdu = new Education();
        try{
      empEdu = em.createNamedQuery("Education.findByEmployeeId",Education.class).setParameter("id", emp.getEmployeeId()).getSingleResult();
        }
        catch(Exception a){}
        try{
        empllist.setEmployeeID(emp.getEmployeeId());
        empllist.setSurname(emp.getSurname());
        empllist.setName(emp.getName());
        empllist.setRole(empRole.getRoleid().getRole());
        empllist.setProject(empRole.getProjectid().getProjectName());
        empllist.setQualification(empEdu.getQualification());
        }
        catch(Exception f){}
        
        EmpList.add(empllist);
        
    
    }
        
        
        
        return EmpList;
    }
    
    
    
    /*get employee data from db*/
   
    
    
    
}
