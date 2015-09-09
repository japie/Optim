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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftafrica.co.optime.Helper.HeatMap.HeatMapJsonObject;
import org.ftafrica.co.optime.Helper.Succesion.SuccessorMainDataObject;
import org.ftafrica.co.optime.Helper.Succesion.recomendationengine.SuccessionDB2CVSFile;
import org.ftafrica.co.optime.Helper.Succesion.recomendationengine.SuccessionRecommendation;
import org.ftafrica.co.optime.Helper.employee.EmployeeListHelper;
import org.ftafrica.co.optime.Helper.hiring.HiringPlanHelper;
import org.ftafrica.co.optime.Helper.projects.Project;
import org.ftafrica.co.optime.Helper.projects.ProjectHelper;
import org.ftafrica.co.optime.Helper.projects.ProjectsHelper;
import org.ftafrica.co.optime.bussinesslogic.EmployeesFacade;
import org.ftafrica.co.optime.bussinesslogic.ProjectsFacade;
import org.ftafrica.co.optime.bussinesslogic.feeders.CapacityPhases;
import org.ftafrica.co.optime.bussinesslogic.feeders.CapacityProjectBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.HeatMapBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.HiringPlanBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.ProjectOverviewBean;
import org.ftafrica.co.optime.bussinesslogic.feeders.SuccessionBean;


@WebServlet(name = "TestingServlet", urlPatterns = {"/TestingServlet"})
public class TestingServlet extends HttpServlet {

    @EJB
    HiringPlanBean dbb;
    @EJB
    SuccessionDB2CVSFile cvx;
    @EJB
    SuccessionRecommendation sss;
    @EJB
    EmployeesFacade emp;
    @EJB
    ProjectsFacade proj;
    @EJB
    SuccessionBean sbb;
    @EJB
    CapacityProjectBean cpb;
    @EJB
    ProjectOverviewBean prj;
    @EJB
    CapacityPhases cph;
    @EJB
    HeatMapBean heatMapBean;

    Gson gson = new Gson();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<String> my = new ArrayList();
        my.add("Proj06");

        // cvx.ConvertDB2CSVFile();
        List<EmployeeListHelper> hmh = emp.GenerateAllEmployeesProfile();

        out.write(gson.toJson(hmh));

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
