/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftafrica.co.optime.model.SuccessionComments;

/**
 *
 * @author Training 8
 */
@Stateless
public class SuccessionCommentsFacade extends AbstractFacade<SuccessionComments> implements SuccessionCommentsFacadeLocal {
    @PersistenceContext(unitName = "OptimPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SuccessionCommentsFacade() {
        super(SuccessionComments.class);
    }
    
}
