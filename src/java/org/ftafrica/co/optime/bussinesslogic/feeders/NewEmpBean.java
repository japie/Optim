/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic.feeders;

import java.util.Set;
import javax.ejb.Stateless;
import javax.faces.validator.Validator;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.ftafrica.co.optime.model.Education;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Projects;
import org.ftafrica.co.optime.model.Work;

/**
 *
 * @author 8460p
 */
@Stateless
public class NewEmpBean {  
@PersistenceContext
EntityManager em;

    public void insertEmpData(Employees emp){ 
   
        em.persist(emp); 
       
    }
     public void insertEdu(Education edu){ 
       
        
        em.persist(edu); 
       
    }
     public  Employees  emp(String emp){
      
     return em.find(Employees.class, emp);}
     
     public void Current_pos(Work wek){
      em.persist(wek);
     }
     
      public void Proj(Projects proj){
      em.persist(proj);
     }
      
      public void updateCapProj(String projid)
      {
      int x= Integer.parseInt(em.find(Projects.class, projid).getCapacity());
       int y = x +1;
       em.find(Projects.class, projid).setCapacity(String.valueOf(y));
      }
}

