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
        import org.ftafrica.co.optime.Helper.HeatMap.CapacityOpenHelper;
import org.ftafrica.co.optime.Helper.HeatMap.FunctionHelper;
        import org.ftafrica.co.optime.Helper.HeatMap.HeatMapCapacityHelper;
        import org.ftafrica.co.optime.Helper.HeatMap.HeatMapEmployeeCapacityHelper;
        import org.ftafrica.co.optime.Helper.HeatMap.HeatMapEmployeeHiringHelper;
        import org.ftafrica.co.optime.Helper.HeatMap.HeatMapEmployeeTrainingHelper;
        import org.ftafrica.co.optime.Helper.HeatMap.HeatMapHiringHelper;
        import org.ftafrica.co.optime.Helper.HeatMap.HeatMapMainHelper;
import org.ftafrica.co.optime.Helper.HeatMap.HeatMapPersonHelper;
        import org.ftafrica.co.optime.Helper.HeatMap.HeatMapPredecessor;
        import org.ftafrica.co.optime.Helper.HeatMap.HeatMapSuccessionHelper;
        import org.ftafrica.co.optime.Helper.HeatMap.HeatMapSuccessor;
        import org.ftafrica.co.optime.Helper.HeatMap.HeatMapTrainingHelper;
        import org.ftafrica.co.optime.Helper.HeatMap.MainHeatMap;
        import org.ftafrica.co.optime.model.Employees;
        import org.ftafrica.co.optime.model.Hiring;
        import org.ftafrica.co.optime.model.Roles;
        import org.ftafrica.co.optime.model.Succession;
        import org.ftafrica.co.optime.model.Teams;
        import org.ftafrica.co.optime.model.TrainingPlan;
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
            public List<HeatMapMainHelper> GenerateHeatMapForDepartmetData(String Department,String EmployeeID){
                List<HeatMapMainHelper> HeatMap = new ArrayList();
                List<Work> levels = GetLevelsForDepartments(Department);
               HeatMapMainHelper hmmHelper = new HeatMapMainHelper();

               HeatMapHiringHelper hmhHelper = new HeatMapHiringHelper();
               List<HeatMapEmployeeHiringHelper> HiringList = new ArrayList();
               List<HeatMapEmployeeHiringHelper> HiredList = new ArrayList();
               List<HeatMapEmployeeHiringHelper> NotHiredList = new ArrayList();
               HeatMapEmployeeTrainingHelper empTrainHelper = new HeatMapEmployeeTrainingHelper();
               HeatMapTrainingHelper TrainHelper = new HeatMapTrainingHelper();
               List<HeatMapEmployeeTrainingHelper> TrainingList = new ArrayList();
               List<HeatMapEmployeeTrainingHelper> TrainedList = new ArrayList();
               List<HeatMapEmployeeTrainingHelper> NotTrainedList = new ArrayList();
               HeatMapEmployeeCapacityHelper emp_cap_helper = new HeatMapEmployeeCapacityHelper();
               HeatMapCapacityHelper capHelper = new HeatMapCapacityHelper();
               List<HeatMapEmployeeCapacityHelper> NoticeList = new ArrayList();
               List<HeatMapEmployeeCapacityHelper> PlacedList = new ArrayList();
               List<CapacityOpenHelper> OpenList = new ArrayList();
               CapacityOpenHelper CapOpenHelper = new CapacityOpenHelper();
               HeatMapSuccessor Successor = new HeatMapSuccessor();
               HeatMapPredecessor Predecessor = new HeatMapPredecessor();
               List<HeatMapSuccessor> SuccessorList = new ArrayList();
               List<HeatMapPredecessor> PredecessorList = new ArrayList();
               HeatMapSuccessionHelper  heatMapSuccessionhelper =  new HeatMapSuccessionHelper();



                for(Work l: levels){
                    //hiring
                   List<Hiring> QueryHiringList = em.createNamedQuery("Hiring.findAllHiringList",Hiring.class).setParameter(l.getLevel(), "lev").setParameter("status", "Hiring").getResultList();
                   List<Hiring> QueryHiredList = em.createNamedQuery("Hiring.findAllHiredList",Hiring.class).setParameter(l.getLevel(), "lev").setParameter("status", "Hired").getResultList();
                   List<Hiring> QueryNotHiredList = em.createNamedQuery("Hiring.findAllNotHiredList",Hiring.class).setParameter(l.getLevel(), "lev").setParameter("Not Hired", "status").getResultList();



                   //training
                   List<TrainingPlan> QueryTrainingList = em.createNamedQuery("TrainingPlan.findTrainigList",TrainingPlan.class).setParameter(l.getLevel(), "lev").setParameter("In-training", "status").getResultList();
                   List<TrainingPlan> QueryTrainedList = em.createNamedQuery("TrainingPlan.findTrainedList",TrainingPlan.class).setParameter(l.getLevel(), "lev").setParameter("complete", "status").getResultList();
                   List<TrainingPlan> QueryNotTrainedList = em.createNamedQuery("TrainingPlan.findNotTrainedList",TrainingPlan.class).setParameter(l.getLevel(), "lev").setParameter("not trained", "status").getResultList();

                   List<Work> QueryNoticeList = em.createNamedQuery("Work.findByNotice", Work.class).setParameter(l.getLevel(), "lev").setParameter("In-training", "status").setParameter(Department, "dep").getResultList();
                   List<Work> QueryOccupiedList = em.createNamedQuery("Work.findByOccupied", Work.class).setParameter(l.getLevel(), "lev").setParameter("complete", "status").setParameter(Department, "dep").getResultList();
                   List<Work> QueryOpenList = em.createNamedQuery("Work.findByOpen", Work.class).setParameter(l.getLevel(), "lev").setParameter("not trained", "status").setParameter(Department, "dep").getResultList();

                   List<Succession> QuerySuccesionList = em.createNamedQuery("Succession.findByList",Succession.class).setParameter(l.getLevel(), "lev").getResultList();



                                for(Hiring h: QueryHiringList){
                                    HeatMapEmployeeHiringHelper hmehHelper = new HeatMapEmployeeHiringHelper();
                                    Employees emp_hir = em.find(Employees.class,h.getEmployeeid());
                                    Work workData = (Work)em.createNamedQuery("Work.findByWorkEmpId").setParameter(h.getEmployeeid(), "id").getSingleResult();

                                   if(workData.getDepartment().equalsIgnoreCase(Department)){
                                    /* label: hiring */
                                 // Employees emp_hir = em.find(Employees.class,h.getEmployeeid());
                                  Roles roles = em.find(Roles.class,h.getRoleid());

                                hmehHelper.setName(emp_hir.getName());
                                hmehHelper.setSurnamme(emp_hir.getSurname());
                                hmehHelper.setEmployeeId(h.getEmployeeid());
                                hmehHelper.setRole(roles.getRole());

                                 HiringList.add(hmehHelper);
                                }
                               }
                                for(Hiring h: QueryHiredList){
                                    HeatMapEmployeeHiringHelper hmehHelper = new HeatMapEmployeeHiringHelper();
                                    /* label: hiring */
                                  Employees emp_hir = em.find(Employees.class,h.getEmployeeid());
                                Work workData = (Work)em.createNamedQuery("Work.findByWorkEmpId").setParameter(h.getEmployeeid(), "id").getSingleResult();


                                   if(workData.getDepartment().equalsIgnoreCase(Department)){

                                  Roles roles = em.find(Roles.class,h.getRoleid());

                                hmehHelper.setName(emp_hir.getName());
                                hmehHelper.setSurnamme(emp_hir.getSurname());
                                hmehHelper.setEmployeeId(h.getEmployeeid());
                                hmehHelper.setRole(roles.getRole());

                                 HiredList.add(hmehHelper);
                               }
                                }
                                for(Hiring h: QueryNotHiredList){
                                   HeatMapEmployeeHiringHelper hmehHelper = new HeatMapEmployeeHiringHelper();
                                  Employees emp_hir = em.find(Employees.class,h.getEmployeeid());
                                 Work workData = (Work)em.createNamedQuery("Work.findByWorkEmpId").setParameter(h.getEmployeeid(), "id").getSingleResult();

                                   if(workData.getDepartment().equalsIgnoreCase(Department)){

                                  Roles roles = em.find(Roles.class,h.getRoleid());

                                hmehHelper.setName(emp_hir.getName());
                                hmehHelper.setSurnamme(emp_hir.getSurname());
                                hmehHelper.setEmployeeId(h.getEmployeeid());
                                hmehHelper.setRole(roles.getRole());

                                 NotHiredList.add(hmehHelper);
                               }
                                }

                   hmhHelper.setHired(HiredList);
                   hmhHelper.setHiring(HiringList);
                   hmhHelper.setNotHired(NotHiredList);



                   /*  do similar processing for capacity planning as of hiring Plannning also do processing for succesion and training */

                    for(TrainingPlan tp: QueryTrainingList ){

                        Employees emp_Tr_plan = em.find(Employees.class,tp.getEmployeeId());
                      Work workData = (Work)em.createNamedQuery("Work.findByWorkEmpId").setParameter(tp.getEmployeeId().getEmployeeId(), "id").getSingleResult();

                                   if(workData.getDepartment().equalsIgnoreCase(Department)){

                        empTrainHelper.setName(emp_Tr_plan.getName());
                       empTrainHelper.setSurname(emp_Tr_plan.getName());
                        empTrainHelper.setEmployeeId(tp.getEmployeeId().getEmployeeId());

                        TrainingList.add(empTrainHelper);


                                   }

                    }
                    for(TrainingPlan tp: QueryTrainedList ){
                        Work workData = (Work)em.createNamedQuery("Work.findByWorkEmpId").setParameter(tp.getEmployeeId().getEmployeeId(), "id").getSingleResult();

                                   if(workData.getDepartment().equalsIgnoreCase(Department)){

                        Employees emp_Tr_plan = em.find(Employees.class,tp.getEmployeeId());
                        empTrainHelper.setName(emp_Tr_plan.getName());
                       empTrainHelper.setSurname(emp_Tr_plan.getName());
                        empTrainHelper.setEmployeeId(tp.getEmployeeId().getEmployeeId());

                        TrainedList.add(empTrainHelper);


                                   }

                    }
                    for(TrainingPlan tp: QueryNotTrainedList ){

                        Work workData = (Work)em.createNamedQuery("Work.findByWorkEmpId").setParameter(tp.getEmployeeId().getEmployeeId(), "id").getSingleResult();

                                   if(workData.getDepartment().equalsIgnoreCase(Department)){

                        Employees emp_Tr_plan = em.find(Employees.class,tp.getEmployeeId());
                        empTrainHelper.setName(emp_Tr_plan.getName());
                       empTrainHelper.setSurname(emp_Tr_plan.getName());
                        empTrainHelper.setEmployeeId(tp.getEmployeeId().getEmployeeId());

                        NotTrainedList.add(empTrainHelper);


                                   }

                    }

                TrainHelper.setNotTrained(NotTrainedList);
                TrainHelper.setTrained(TrainedList);
                TrainHelper.setTraining(TrainingList);

                for(Work w: QueryNoticeList){

                       Employees emp_wrk_plan = em.find(Employees.class,w.getEmployeeId());
                       emp_cap_helper.setEmployeeId(w.getEmployeeId().getEmployeeId());
                       emp_cap_helper.setName(emp_wrk_plan.getName());
                       emp_cap_helper.setSurname(emp_wrk_plan.getSurname());
                       emp_cap_helper.setRole(w.getPosition());

                       NoticeList.add(emp_cap_helper);

                }
                for(Work w: QueryOccupiedList){


                       Employees emp_wrk_plan = em.find(Employees.class,w.getEmployeeId());
                       emp_cap_helper.setEmployeeId(w.getEmployeeId().getEmployeeId());
                       emp_cap_helper.setName(emp_wrk_plan.getName());
                       emp_cap_helper.setSurname(emp_wrk_plan.getSurname());
                       emp_cap_helper.setRole(w.getPosition());

                       PlacedList.add(emp_cap_helper);

                }

                for(Work w: QueryOpenList){

                     CapOpenHelper.setPosition(w.getPosition());
                     OpenList.add(CapOpenHelper);

                }
                capHelper.setOcupiedList(PlacedList);
                capHelper.setOpenList(OpenList);
                capHelper.setNoticeList(NoticeList);

                 for(Succession s: QuerySuccesionList ){

                    Employees emp_Suc = em.find(Employees.class,s.getSuccessor());
                    Employees emp_Pre = em.find(Employees.class,s.getPredecessor());
                    Work workData = (Work)em.createNamedQuery("Work.findByWorkEmpId").setParameter(s.getPredecessor().getEmployeeId(), "id").getSingleResult();//Need to set Predecessor_id ID


                    Successor.setName(emp_Suc.getName());
                    Predecessor.setName(emp_Pre.getName());
                    Successor.setSurname(emp_Suc.getName());
                    Predecessor.setSurname(emp_Pre.getSurname());
                    Successor.setEmployeeID(emp_Suc.getEmployeeId());
                    Predecessor.setEmployeeId(emp_Suc.getEmployeeId());
                    Predecessor.setRole(workData.getPosition());


                    PredecessorList.add(Predecessor);
                    SuccessorList.add(Successor);



                }
               heatMapSuccessionhelper.setPredecessorList(PredecessorList);
               heatMapSuccessionhelper.setSuccessor(SuccessorList);


                hmmHelper.setHeatMapCapacity(capHelper);
                hmmHelper.setHeatMapHiring(hmhHelper);
                hmmHelper.setHeatMapSuccession(heatMapSuccessionhelper);
                hmmHelper.setHeatMapTraining(TrainHelper);

                HeatMap.add(hmmHelper);
                }



           return HeatMap;
        } 

           // @Override
            public List<HeatMapMainHelper> GenerateHeatForProjectsMapData(String Project, String EmployeeID) {

                 List<HeatMapMainHelper> HeatMap = new ArrayList();
                List<String> levels = GetLevelsForProjects(Project);
               // HeatMapEmployeeHiringHelper hmehHelper = new HeatMapEmployeeHiringHelper();






                int x=0;
                for(String l: levels){
                    HeatMapSuccessionHelper  heatMapSuccessionhelper =  new HeatMapSuccessionHelper();
                    HeatMapCapacityHelper capHelper = new HeatMapCapacityHelper();
                    HeatMapTrainingHelper TrainHelper = new HeatMapTrainingHelper();
                    HeatMapHiringHelper hmhHelper = new HeatMapHiringHelper();
                   HeatMapMainHelper hmmHelper = new HeatMapMainHelper();
                   List<HeatMapEmployeeHiringHelper> HiringList = new ArrayList();
               List<HeatMapEmployeeHiringHelper> HiredList = new ArrayList();
               List<HeatMapEmployeeHiringHelper> NotHiredList = new ArrayList();


               List<HeatMapEmployeeTrainingHelper> TrainingList = new ArrayList();
               List<HeatMapEmployeeTrainingHelper> TrainedList = new ArrayList();
               List<HeatMapEmployeeTrainingHelper> NotTrainedList = new ArrayList();


               List<HeatMapEmployeeCapacityHelper> NoticeList = new ArrayList();
               List<HeatMapEmployeeCapacityHelper> PlacedList = new ArrayList();
               List<CapacityOpenHelper> OpenList = new ArrayList();


               List<HeatMapSuccessor> SuccessorList = new ArrayList();
               List<HeatMapPredecessor> PredecessorList = new ArrayList();

                   List<Hiring> QueryHiringList = em.createNamedQuery("Hiring.findAllHiringList",Hiring.class).setParameter("lev", l).setParameter("status", "Hiring").getResultList();
                   List<Hiring> QueryHiredList = em.createNamedQuery("Hiring.findAllHiredList",Hiring.class).setParameter("lev",l).setParameter("status" ,"Hired").getResultList();
                   List<Hiring> QueryNotHiredList = em.createNamedQuery("Hiring.findAllNotHiredList",Hiring.class).setParameter("lev", l).setParameter("status", "Not Hired").getResultList();



                   //training
                   List<TrainingPlan> QueryTrainingList = em.createNamedQuery("TrainingPlan.findTrainigList",TrainingPlan.class).setParameter("lev", l).setParameter("status", "In-training").getResultList();
                   List<TrainingPlan> QueryTrainedList = em.createNamedQuery("TrainingPlan.findTrainedList",TrainingPlan.class).setParameter("lev", l).setParameter("status", "complete").getResultList();
                   List<TrainingPlan> QueryNotTrainedList = em.createNamedQuery("TrainingPlan.findNotTrainedList",TrainingPlan.class).setParameter("lev", l).setParameter("status", "not trained").getResultList();

                   List<Work> QueryNoticeList = em.createNamedQuery("Work.findByNoticePro", Work.class).setParameter("lev", l).setParameter("status", "Notice").getResultList();
                   List<Work> QueryOccupiedList = em.createNamedQuery("Work.findByOccupiedPro", Work.class).setParameter("lev", l).setParameter("status", "Working").getResultList();
                   List<Work> QueryOpenList = em.createNamedQuery("Work.findByOpenPro", Work.class).setParameter("lev", l).setParameter("status", "In-Active").getResultList();

                   List<Succession> QuerySuccesionList = em.createNamedQuery("Succession.findByList",Succession.class).setParameter("lev", l).getResultList();



                                for(Hiring h: QueryHiringList){
                                    HeatMapEmployeeHiringHelper hmehHelper = new HeatMapEmployeeHiringHelper();
                                    Employees emp_hir = em.find(Employees.class,h.getEmployeeid());
                                    Teams TeamsData = (Teams)em.createNamedQuery("Teams.findByTeamsEmpId").setParameter("id", h.getEmployeeid()).getSingleResult();

                                  if(TeamsData.getProjectid().getProjectid().equalsIgnoreCase(Project)){
                                    /* label: hiring */
                                 // Employees emp_hir = em.find(Employees.class,h.getEmployeeid());
                                  Roles roles = em.find(Roles.class,h.getRoleid());

                                hmehHelper.setName(emp_hir.getName());
                                hmehHelper.setSurnamme(emp_hir.getSurname());
                                hmehHelper.setEmployeeId(h.getEmployeeid());
                                hmehHelper.setRole(roles.getRole());

                                 HiringList.add(hmehHelper);
                                }
                               }
                                for(Hiring h: QueryHiredList){
                                    HeatMapEmployeeHiringHelper hmehHelper = new HeatMapEmployeeHiringHelper();
                                    /* label: hiring */
                                  Employees emp_hir = em.find(Employees.class,h.getEmployeeid());
                               Teams TeamsData = (Teams)em.createNamedQuery("Teams.findByTeamsEmpId").setParameter("id", h.getEmployeeid()).getSingleResult();
                                       if(TeamsData.getProjectid().getProjectid().equalsIgnoreCase(Project)){

                                  Roles roles = em.find(Roles.class,h.getRoleid());

                                hmehHelper.setName(emp_hir.getName());
                                hmehHelper.setSurnamme(emp_hir.getSurname());
                                hmehHelper.setEmployeeId(h.getEmployeeid());
                                hmehHelper.setRole(roles.getRole());

                                 HiredList.add(hmehHelper);
                               }
                                }
                                for(Hiring h: QueryNotHiredList){
                                    HeatMapEmployeeHiringHelper hmehHelper = new HeatMapEmployeeHiringHelper();
                                    /* label: hiring */
                                  Employees emp_hir = em.find(Employees.class,h.getEmployeeid());
                                  Teams TeamsData = (Teams)em.createNamedQuery("Teams.findByTeamsEmpId").setParameter("id", h.getEmployeeid()).getSingleResult();
                                       if(TeamsData.getProjectid().getProjectid().equalsIgnoreCase(Project)){

                                  Roles roles = em.find(Roles.class,h.getRoleid());

                                hmehHelper.setName(emp_hir.getName());
                                hmehHelper.setSurnamme(emp_hir.getSurname());
                                hmehHelper.setEmployeeId(h.getEmployeeid());
                                hmehHelper.setRole(roles.getRoleId());

                                 NotHiredList.add(hmehHelper);
                               }
                                }

                   hmhHelper.setHired(HiredList);
                   hmhHelper.setHiring(HiringList);
                   hmhHelper.setNotHired(NotHiredList);



                   /*  do similar processing for capacity planning as of hiring Plannning also do processing for succesion and training */

                    for(TrainingPlan tp: QueryTrainingList ){
                       HeatMapEmployeeTrainingHelper empTrainHelper = new HeatMapEmployeeTrainingHelper();
                        Employees emp_Tr_plan = em.find(Employees.class,tp.getEmployeeId().getEmployeeId());
                       Teams TeamsData = (Teams)em.createNamedQuery("Teams.findByTeamsEmpId").setParameter("id", tp.getEmployeeId().getEmployeeId()).getSingleResult();
                                       if(TeamsData.getProjectid().getProjectid().equalsIgnoreCase(Project)){

                        empTrainHelper.setName(emp_Tr_plan.getName());
                       empTrainHelper.setSurname(emp_Tr_plan.getSurname());
                        empTrainHelper.setEmployeeId(tp.getEmployeeId().getEmployeeId());

                        TrainingList.add(empTrainHelper);


                                   }

                    }
                    for(TrainingPlan tp: QueryTrainedList ){
                        HeatMapEmployeeTrainingHelper empTrainHelper = new HeatMapEmployeeTrainingHelper();
                        Teams TeamsData = (Teams)em.createNamedQuery("Teams.findByTeamsEmpId").setParameter("id", tp.getEmployeeId().getEmployeeId()).getSingleResult();
                                       if(TeamsData.getProjectid().getProjectid().equalsIgnoreCase(Project)){

                        Employees emp_Tr_plan = em.find(Employees.class,tp.getEmployeeId().getEmployeeId());
                        empTrainHelper.setName(emp_Tr_plan.getName());
                       empTrainHelper.setSurname(emp_Tr_plan.getSurname());
                        empTrainHelper.setEmployeeId(tp.getEmployeeId().getEmployeeId());

                        TrainedList.add(empTrainHelper);


                                   }

                    }
                    for(TrainingPlan tp: QueryNotTrainedList ){
                      HeatMapEmployeeTrainingHelper empTrainHelper = new HeatMapEmployeeTrainingHelper();
                         Teams TeamsData = (Teams)em.createNamedQuery("Teams.findByTeamsEmpId").setParameter("id", tp.getEmployeeId().getEmployeeId()).getSingleResult();
                                       if(TeamsData.getProjectid().getProjectid().equalsIgnoreCase(Project)){

                        Employees emp_Tr_plan = em.find(Employees.class,tp.getEmployeeId().getEmployeeId());
                        empTrainHelper.setName(emp_Tr_plan.getName());
                       empTrainHelper.setSurname(emp_Tr_plan.getSurname());
                        empTrainHelper.setEmployeeId(tp.getEmployeeId().getEmployeeId());

                        NotTrainedList.add(empTrainHelper);


                                   }

                    }

                TrainHelper.setNotTrained(NotTrainedList);
                TrainHelper.setTrained(TrainedList);
                TrainHelper.setTraining(TrainingList);

                for(Work w: QueryNoticeList){

                   HeatMapEmployeeCapacityHelper emp_cap_helper = new HeatMapEmployeeCapacityHelper();
                    Teams TeamsData = (Teams)em.createNamedQuery("Teams.findByTeamsEmpId").setParameter("id", w.getEmployeeId().getEmployeeId()).getSingleResult();
                                       if(TeamsData.getProjectid().getProjectid().equalsIgnoreCase(Project)){


                       Employees emp_wrk_plan = em.find(Employees.class,w.getEmployeeId().getEmployeeId());
                       emp_cap_helper.setEmployeeId(w.getEmployeeId().getEmployeeId());
                       emp_cap_helper.setName(emp_wrk_plan.getName());
                       emp_cap_helper.setSurname(emp_wrk_plan.getSurname());
                       emp_cap_helper.setRole(w.getPosition());

                       NoticeList.add(emp_cap_helper);
                                       }
                }
                for(Work w: QueryOccupiedList){

                  HeatMapEmployeeCapacityHelper emp_cap_helper = new HeatMapEmployeeCapacityHelper();
                    Teams TeamsData = (Teams)em.createNamedQuery("Teams.findByTeamsEmpId").setParameter("id", w.getEmployeeId().getEmployeeId()).getSingleResult();
                                       if(TeamsData.getProjectid().getProjectid().equalsIgnoreCase(Project)){


                       Employees emp_wrk_plan = em.find(Employees.class,w.getEmployeeId().getEmployeeId());
                       emp_cap_helper.setEmployeeId(w.getEmployeeId().getEmployeeId());
                       emp_cap_helper.setName(emp_wrk_plan.getName());
                       emp_cap_helper.setSurname(emp_wrk_plan.getSurname());
                       emp_cap_helper.setRole(w.getPosition());

                       PlacedList.add(emp_cap_helper);
                }
                }

                for(Work w: QueryOpenList){
                  CapacityOpenHelper CapOpenHelper = new CapacityOpenHelper();
                    Teams TeamsData = (Teams)em.createNamedQuery("Teams.findByTeamsEmpId").setParameter("id", w.getEmployeeId().getEmployeeId()).getSingleResult();
                                       if(TeamsData.getProjectid().getProjectid().equalsIgnoreCase(Project)){
                     CapOpenHelper.setPosition(w.getPosition());
                     OpenList.add(CapOpenHelper);
                                       } 
                }
                capHelper.setOcupiedList(PlacedList);
                capHelper.setOpenList(OpenList);
                capHelper.setNoticeList(NoticeList);

                 for(Succession s: QuerySuccesionList ){
                HeatMapSuccessor Successor = new HeatMapSuccessor();
               HeatMapPredecessor Predecessor = new HeatMapPredecessor();
                    Employees emp_Suc = em.find(Employees.class,s.getSuccessor().getEmployeeId());
                    Employees emp_Pre = em.find(Employees.class,s.getPredecessor().getEmployeeId());
                    Teams TeamsData = (Teams)em.createNamedQuery("Teams.findByTeamsEmpId").setParameter("id", s.getPredecessor().getEmployeeId()).getSingleResult();//Need to set Predecessor_id ID
                    Work workData = (Work)em.createNamedQuery("Work.findByWorkEmpId").setParameter("id", s.getPredecessor().getEmployeeId()).getSingleResult();

                    Successor.setName(emp_Suc.getName());
                    Predecessor.setName(emp_Pre.getName());
                    Successor.setSurname(emp_Suc.getSurname());
                    Predecessor.setSurname(emp_Pre.getSurname());
                    Successor.setEmployeeID(emp_Suc.getEmployeeId());
                    Predecessor.setEmployeeId(emp_Pre.getEmployeeId());
                    Predecessor.setRole(workData.getPosition());


                    PredecessorList.add(Predecessor);
                    SuccessorList.add(Successor);



                }
               heatMapSuccessionhelper.setPredecessorList(PredecessorList);
               heatMapSuccessionhelper.setSuccessor(SuccessorList);


                hmmHelper.setHeatMapCapacity(capHelper);
                hmmHelper.setHeatMapHiring(hmhHelper);
                hmmHelper.setHeatMapSuccession(heatMapSuccessionhelper);
                hmmHelper.setHeatMapTraining(TrainHelper);
               // String level = l;
                hmmHelper.setTitle(l);
                x++;
               // level = null;
                HeatMap.add(hmmHelper);
                }



           return HeatMap;


            }
           public List<MainHeatMap> AutoGenarateHeatMapForProjects(String Project){
          List<String> Levels = GetLevelsForProjects(Project);
          List<MainHeatMap> heatMap = new ArrayList();
           for(String l : Levels){
               
               List<String> FunctionsDB = GetPhasesForProjects(l,Project);
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
                                functionHelper.setFunction(f);
                                HeatMapFunctionList.add(functionHelper);
                                
                        }
                       mainHeatMap.setLevel(l);
                       mainHeatMap.setFunnction(HeatMapFunctionList);
                       heatMap.add(mainHeatMap);

           }


           return heatMap;
           }


        }





