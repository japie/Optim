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
import org.ftafrica.co.optime.model.Projects;

/**
 *
 * @author 8460p
 */
@Stateless
public class NewProjectBean {  
@PersistenceContext
EntityManager em;

    public void insertProjectData(Projects pro){ 
       
        
        em.persist(pro); 
       
    }
}
