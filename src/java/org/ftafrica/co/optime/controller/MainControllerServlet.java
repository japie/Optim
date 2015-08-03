/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftafrica.co.optime.Helper.DashBoard.DashboardMain;
import org.ftafrica.co.optime.Helper.HeatMap.HeatMapJsonObject;
import org.ftafrica.co.optime.bussinesslogic.feeders.DashboardBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.HeatMapBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.LoginSessionTrackerInterface;
import org.ftafrica.co.optime.model.Employees;

/**
 *
 * @author Training 8
 */
public class MainControllerServlet extends HttpServlet {
 private static final String SESSION_TRACKER_BEAN_SESION_KEY  = "s_session tracker_t";
 @EJB
 DashboardBean dashboardBean;
 @EJB
 HeatMapBean heatmapBean;
 Gson JsonConverter = new Gson();
 
    
    
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
        
        
        if(loginSeesionTrackerBean == null){
      // EJB is not present in the HTTP session
      // so let's fetch a new one from the container
     // response.setContentType("application/json;charset=UTF-8");
        
                
                
          }
        else{
            
         String check =  request.getParameter("check");
     Employees currentUser =   loginSeesionTrackerBean.GetExistingUser(loginSeesionTrackerBean.getSessionID());
     List<String> Projects = loginSeesionTrackerBean.getProj();
     String ManagerID = loginSeesionTrackerBean.getSessionID();
   String name =currentUser.getName()+" "+currentUser.getSurname();
             switch (check) {
                 case "Login":
                     // set UserName **** still to create for messages and notifications
                     response.setContentType("text/html;charset=UTF-8");
                     
                     out.write(name);
                     break;
                 case "DashBoard":
                    // List<String> my = new ArrayList();
                     // return dashboard json
                     DashboardMain dashboardMain = dashboardBean.GenerateDashBoardMain(Projects);
                     response.setContentType("application/json;charset=UTF-8");
                     out.write(JsonConverter.toJson(dashboardMain));
                     break;
                 case "HeatMap":
                     //return heatmap json
                     List<HeatMapJsonObject> mainHeatMap = heatmapBean.AutoGenarateHeatMapForProjects(Projects);
                     out.write(JsonConverter.toJson(mainHeatMap));
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
