/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftafrica.co.optime.Helper.DashBoard.DashboardMain;
import org.ftafrica.co.optime.Helper.HeatMap.HeatMapJsonObject;
import org.ftafrica.co.optime.Helper.HeatMap.sideview.MainSideView;
import org.ftafrica.co.optime.bussinesslogic.EmployeesFacade;
import org.ftafrica.co.optime.bussinesslogic.ProjectsFacade;
import org.ftafrica.co.optime.bussinesslogic.feeders.CapacityPhases;
import org.ftafrica.co.optime.bussinesslogic.feeders.CapacityProjectBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.DashboardBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.HeatMapBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.HiringPlanBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.LoginSessionTrackerInterface;
import org.ftafrica.co.optime.bussinesslogic.feeders.ProjectOverviewBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.SideViewBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.SuccessionBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.TrainingBean;
import org.ftafrica.co.optime.model.Employees;

/**
 *
 * @author Training 8
 */
public class MainControllerServlet extends HttpServlet {

    Gson JsonConverter = new Gson();
    private static final String SESSION_TRACKER_BEAN_SESION_KEY = "s_session tracker_t";
    @EJB
    DashboardBean dashboardBean;
    @EJB
    HeatMapBean heatmapBean;
    @EJB
    SideViewBean sideViewBean;
    @EJB
    CapacityProjectBean capacityProjectBean;
    @EJB
    ProjectsFacade projectBean;
    @EJB
    SuccessionBean successionBean;
    @EJB
    ProjectOverviewBean projectOverView;
    @EJB
    HiringPlanBean hiringPlanBean;
    @EJB
    TrainingBean trainingBean;
    @EJB
    EmployeesFacade employeeBean;
    @EJB
    CapacityPhases capacityPhases;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginSessionTrackerInterface loginSeesionTrackerBean = (LoginSessionTrackerInterface) request.getSession()
                .getAttribute(SESSION_TRACKER_BEAN_SESION_KEY);

        PrintWriter out = response.getWriter();

        if (loginSeesionTrackerBean == null) {
            // EJB is not present in the HTTP session
            // so let's fetch a new one from the container
            // response.setContentType("application/json;charset=UTF-8");

        } else {

            String check = request.getParameter("check");
            Employees currentUser = loginSeesionTrackerBean.GetExistingUser(loginSeesionTrackerBean.getSessionID());
            List<String> Projects = loginSeesionTrackerBean.getProj();
            String ManagerID = loginSeesionTrackerBean.getSessionID();
            String name = currentUser.getName() + " " + currentUser.getSurname();
            switch (check) {
                case "Login":
                    // set UserName **** still to create for messages and notifications
                    response.setContentType("text/html;charset=UTF-8");

                    out.write(name);
                    break;
                case "DashBoard":
                    // List<String> my = new ArrayList();
                    // return dashboard json
                    response.setContentType("text/html;charset=UTF-8");
                    DashboardMain dashboardMain = dashboardBean.GenerateDashBoardMain(Projects);
                    //  response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(dashboardMain));
                    break;
                case "HeatMap":
                    //return heatmap json
                    List<HeatMapJsonObject> mainHeatMap = heatmapBean.AutoGenarateHeatMapForProjects(Projects);
                    //  response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(mainHeatMap));
                    break;
                case "SideView":
                    //return heatmap json
                    List<MainSideView> side_view = new ArrayList();
                    MainSideView mainSideView = sideViewBean.GenarateHeatMapSideView(request.getParameter("accessId"));
                    side_view.add(mainSideView);
                    // response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(side_view));
                    break;
                case "BookOfWork": //projects frm the book of click...
                    //return projects json

                    // response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(capacityProjectBean.GenerateCapacityProjectHelperByProject(ManagerID)));
                    break;

                case "ProjectProfileView": //projects from the project overview page where red tabs to capacity plan...
                    //return heatmap json
                    String ProjProjectId = request.getParameter("accessId");
                    //response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(projectBean.getProjectProfile("Proj06")));
                    break;

                case "OpenRolesAndNoticeSuc": // from the red projects to successionplan
                    //return heatmap json
                    String projectIdSuc = request.getParameter("accessId");
                    // response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(successionBean.GenerateSuccessionPlan(projectIdSuc)));
                    break;

                case "Successors": // from successionplan to SuccessorList
                    //return heatmap json
                    String SuccessorId = request.getParameter("accessId");
                    // response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(successionBean.SuggestSuccessorsObject(SuccessorId)));
                    break;
                case "ProjectChooser": // choose Project And send info with projectId as accessId
                    //return heatmap json

                    //response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(projectOverView.GenerateProjectOverView(ManagerID)));
                    break;
                case "HiringPlan": // choose Project And send info with projectId as accessId
                    //return heatmap json
                    String HiringProjectId = request.getParameter("accessId");
                    //response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(hiringPlanBean.GenerateHiringPlanJsonObject(HiringProjectId)));
                    break;
                case "TrainingPlan": // choose Project And send info with projectId as accessId
                    //return heatmap json
                    String TrainingProjectId = request.getParameter("accessId");
                    //response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(trainingBean.GenerateTrainingPlanObject(TrainingProjectId)));
                    break;
                case "EmployeeProfile": // choose Project And send info with projectId as accessId
                    //return heatmap json
                    String EmployeeId = request.getParameter("accessId");
                    //response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(employeeBean.GetExistingEmployee(EmployeeId)));
                    break;
                case "MainCapacity": // choose Project And send info with projectId as accessId
                    //return heatmap json
                    //response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(capacityPhases.GenerateCapacityPhasesB(ManagerID)));
                    break;
                     case "EmployeeList": // choose Project And send info with projectId as accessId
                    //return heatmap json
                    //response.setContentType("application/json;charset=UTF-8");
                    out.write(JsonConverter.toJson(employeeBean.GenerateAllEmployeesProfile()));
                    break;
            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
