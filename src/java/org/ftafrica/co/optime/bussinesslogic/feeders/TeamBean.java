/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.bussinesslogic.feeders;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ftafrica.co.optime.Helper.projects.TeamsList;
import org.ftafrica.co.optime.model.Teams;

/**
 *
 * @author 8460p
 */
@Stateless
public class TeamBean {
  @PersistenceContext
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public List<Teams> GetTeams(String ProjId){
           List<Teams> tmlist = em.createNamedQuery("Teams.findByProjID3",Teams.class).setParameter("projId", ProjId).getResultList();
              TeamsList tl = new TeamsList();
              Teams ts = new Teams();
              tl.setTeamId(ts.getTeamsid());
              tl.setTeamN(ts.getTeamrecordid());
              tmlist.add(ts);
             
           return tmlist;
    } 
}
