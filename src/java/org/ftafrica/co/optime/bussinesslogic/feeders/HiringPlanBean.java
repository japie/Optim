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
import org.ftafrica.co.optime.Helper.hiring.HiringPlanHelper;
import org.ftafrica.co.optime.model.Hiring;

/**
 *
 * @author Training 8
 */
@Stateless
public class HiringPlanBean {

    @PersistenceContext
    EntityManager em;

    public java.util.List<HiringPlanHelper> GenerateHiringPlanJsonObject(String Project) {
        List<String> roles = HiringPlanBean.this.GetDistinctRolesFromTeams(Project);
        java.util.List<HiringPlanHelper> hiringPlan = new java.util.ArrayList<>();
        for (String r : roles) {
            HiringPlanHelper Hiring_Class = new HiringPlanHelper();

            List<Hiring> HiringList = em.createNamedQuery("Hiring.findAllHiring2", Hiring.class).setParameter("status", "Hiring").setParameter("RoleId", r).setParameter("ProjId", Project).getResultList();

            List<Hiring> HiredList = em.createNamedQuery("Hiring.findAllHiring2", Hiring.class).setParameter("status", "Hired").setParameter("RoleId", r).setParameter("ProjId", Project).getResultList();

            List<Hiring> RejectedList = em.createNamedQuery("Hiring.findAllHiring2", Hiring.class).setParameter("status", "Not Hired").setParameter("RoleId", r).setParameter("ProjId", Project).getResultList();
            
           List<Hiring> allList;
            
            allList = em.createNamedQuery("Hiring.findAllHired",Hiring.class).setParameter("RoleId", r).getResultList();
            
            Hiring_Class.setRoleName(allList.get(0).getRoleid().getRole());
            Hiring_Class.setRoleId(r);
            Hiring_Class.setLevel(allList.get(0).getLevel());
            Hiring_Class.setEmploymentType(allList.get(0).getRoleid().getEmploymentType());
            Hiring_Class.setProjectName(allList.get(0).getProjectId().getProjectName());
            Hiring_Class.setExpirience(allList.get(0).getExperience());
            Hiring_Class.setNumberOfHired(HiredList.size());
            Hiring_Class.setNumberOfHiring(HiringList.size());
            Hiring_Class.setNumberOfRejected(RejectedList.size());
            hiringPlan.add(Hiring_Class);
            
           
            
        }

        return hiringPlan;
    }

    private List<String> GetDistinctRolesFromTeams(String Project) {

        List<String> teamRoleList = em.createNamedQuery("Hiring.findRolesByProjID").setParameter("proj", Project).getResultList();

        return teamRoleList;

    }

}
