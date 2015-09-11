/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.Helper.projects;

/**
 *
 * @author 8460p
 */
public class TeamsList {
     
    String TeamN;
    String TeamId;
   
    
    public void setTeamN(String tm){  
       this.TeamN = tm;
    }
    public void setTeamId(String id){
    this.TeamId = id;
    }
    public String getTeamN(){
       return TeamN;
    }
    public String getTeamId(){
    return TeamId;
    }
}
