            /*
             * To change this license header, choose License Headers in Project Properties.
             * To change this template file, choose Tools | Templates
             * and open the template in the editor.
             */

            package org.ftafrica.co.optime.bussinesslogic.feeders;

            import java.util.ArrayList;
            import java.util.List;
            import javax.ejb.Stateless;
            import javax.persistence.EntityManager;
            import javax.persistence.PersistenceContext;
            import org.ftafrica.co.optime.Helper.HeatMap.FunctionHelper;
            import org.ftafrica.co.optime.Helper.HeatMap.HeatMapJsonObject;
            import org.ftafrica.co.optime.Helper.HeatMap.HeatMapPersonHelper;
            import org.ftafrica.co.optime.Helper.HeatMap.MainHeatMap;
            import org.ftafrica.co.optime.model.Employees;
            import org.ftafrica.co.optime.model.Projects;
            import org.ftafrica.co.optime.model.Succession;
            import org.ftafrica.co.optime.model.Teams;
            import org.ftafrica.co.optime.model.Work;


            /**
             *
             * @author Training 8
             */
            @Stateless
            public class HeatMapBean  {
                @PersistenceContext
                EntityManager em;
               // HeatMapMainHelper hmmHelper = new HeatMapMainHelper();

               // @Override
                public List<Work> GetLevelsForDepartments(String Department) {

                    return em.createNamedQuery("Work.findSpecificLevels",Work.class).setParameter(Department, "departmen").getResultList();
                 }
               // @Override
                public List GetLevelsForProjects(String Project) {

                    return em.createNamedQuery("Teams.findByProjID",Teams.class).setParameter("proj", Project).getResultList();
                 }
                public List GetPhasesForProjects(String level,String Project) {

                    return em.createNamedQuery("Teams.findDistinctFunctions",Teams.class).setParameter("level", level).setParameter("proj", Project).getResultList();
                 }




               // @Override
                public List<HeatMapJsonObject> AutoGenarateHeatMapForProjects(List<String> projects){
                   List<HeatMapJsonObject> heatMapJsonObject = new ArrayList();

                   for(String p:projects){
                  HeatMapJsonObject HeatMapJson = new HeatMapJsonObject();
              List<String> Levels = GetLevelsForProjects(p);
              List<MainHeatMap> heatMap = new ArrayList();
               for(String l : Levels){

                   List<String> FunctionsDB = GetPhasesForProjects(l,p);
                   List<FunctionHelper> HeatMapFunctionList = new ArrayList();
                   MainHeatMap mainHeatMap = new MainHeatMap();

                           for(String f: FunctionsDB){
                               List<HeatMapPersonHelper> heatMapPersonList = new ArrayList();
                               FunctionHelper functionHelper = new FunctionHelper();
                               List<Teams> ProjectTeam = em.createNamedQuery("Teams.findProjectTeamByLevelsAndPhases", Teams.class).setParameter("levels", l).setParameter("phases", f).getResultList();

                               for(Teams pt: ProjectTeam){
                                   String Status="Green";
                                   HeatMapPersonHelper heatMapPerson =new HeatMapPersonHelper();
                                   Employees HeatMapEmployee =  pt.getEmployeeid();
                                   Work EmpWork = em.createNamedQuery("Work.findByWorkEmpId",Work.class).setParameter("id", pt.getEmployeeid().getEmployeeId()).getSingleResult();
                                   Succession EmpSuc = new Succession();
                                   
                                   try{
                                   EmpSuc = em.createNamedQuery("Succession.findByPre",Succession.class).setParameter("pre", pt.getEmployeeid().getEmployeeId()).getSingleResult();
                                   }
                                   catch(Exception e){


                                   }
                                      heatMapPerson.setEmployeeId(HeatMapEmployee.getEmployeeId());
                                      heatMapPerson.setName(HeatMapEmployee.getName());
                                      heatMapPerson.setSurname(HeatMapEmployee.getSurname());

                                      if(EmpWork.getStatus().equals("Notice")){
                                      Status= "Amber";

                                      }
                                      if(EmpWork.getStatus().equals("Open")){
                                      Status="Red";

                                      }
                                      if(EmpSuc.getSuccessor() == null){

                                      Status= "Red";

                                      }
                                      heatMapPerson.setStatus(Status);

                                     heatMapPersonList.add(heatMapPerson);

                               }

                                    functionHelper.setEmployees(heatMapPersonList);
                                    functionHelper.setPhase(f);
                                    HeatMapFunctionList.add(functionHelper);

                            }
                           mainHeatMap.setLevel(l);
                           mainHeatMap.setRolesCol(HeatMapFunctionList);
                           heatMap.add(mainHeatMap);

               }


                       Projects ManagerProj = em.find(Projects.class,p);
                       HeatMapJson.setProjectName(ManagerProj.getProjectName());
                       HeatMapJson.setMainHeatMap(heatMap);

                       heatMapJsonObject.add(HeatMapJson);

               }
               return heatMapJsonObject;
            }

            }





