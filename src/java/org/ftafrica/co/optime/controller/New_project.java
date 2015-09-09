/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftafrica.co.optime.bussinesslogic.feeders.NewProjectBean;
import org.ftafrica.co.optime.model.Projects;

/**
 *
 * @author Training 10
 */

public class New_project extends HttpServlet {

    @EJB
    NewProjectBean eb;
    Projects pro = new Projects();
    
    
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
        response.setContentType("text/html;charset=UTF-8");
        
        //Add project information
     
        
            pro.setProjectName(request.getParameter("projectname"));
            
            Random gen = new Random();
            int f = gen.nextInt(999999);
            String a = "proj" +f;
            pro.setProjectid(a);
            pro.setDepartment(request.getParameter("department"));             
            pro.setDuration(request.getParameter("duration"));                        
            pro.setProjectbudget(Double.parseDouble(request.getParameter("projectbudget")));
            pro.setStartdate(Date.valueOf(request.getParameter("startdate")));            
            pro.setProjectActualExpense(Double.parseDouble(request.getParameter("projectactualex")));        
            pro.setEnddate(Date.valueOf(request.getParameter("enddate")));        
            pro.setContractperiod(Long.parseLong(request.getParameter("contractperiod")));                        
            pro.setCapacity(request.getParameter("capacity"));     
            pro.setProjectphases(Long.parseLong(request.getParameter("numberofphases")));
            pro.setProjectTeam(request.getParameter("projectteam"));
            pro.setStatus(request.getParameter("projectstatus"));
            pro.setProjectmanager(request.getParameter("projectmanager"));
            
        
        eb.insertProjectData(pro);
        
        
        
    
        
        response.sendRedirect("ProjectView.html");
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
