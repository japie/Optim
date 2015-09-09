/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.Helper.Succesion.recomendationengine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftafrica.co.optime.model.Recommendationdata;

/**
 *
 * @author Training 8
 */
@Stateless
public class SuccessionDB2CVSFile {
    @PersistenceContext
    EntityManager em;
    
    public void ConvertDB2CSVFile() throws IOException{
        List<Recommendationdata> recData = GetRecData();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\8460p\\Documents\\Optim Share\\project updated\\___Master____\\optim\\data",true))) {
            for(Recommendationdata rd: recData){
                
                bw.write(rd.getEmployeeId() + "," + rd.getRecItemId() +  "\n");
            }     }
    
    }
    
    public List<Recommendationdata> GetRecData(){
      
        return em.createNamedQuery("Recommendationdata.findAll").getResultList();
    }
    
    
    
    
}
