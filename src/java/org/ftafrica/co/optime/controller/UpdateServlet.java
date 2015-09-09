/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ftafrica.co.optime.controller;

import java.io.IOException;
import java.sql.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftafrica.co.optime.bussinesslogic.EmployeesFacade;

/**
 *
 * @author Training 8
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {
    @EJB
    EmployeesFacade employeeFac;

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
        
      String Name = request.getParameter("names");
      String Surname = request.getParameter("lastnames");
      String Position = request.getParameter("role_name");
      String email = request.getParameter("email");
      String MaritalStatus = request.getParameter("maritalstatus");
      String Status = request.getParameter("role_status");
      String CellNumber = request.getParameter("cellnumber");
      String postalAddress = request.getParameter("postal_address");
      String PhysicalAdress = request.getParameter("physical_address");
      String AreaCode = request.getParameter("area_code");
      String ReleventExp = request.getParameter("r_expirience");
      String GeneralExp = request.getParameter("g_expirience");
      String Level = request.getParameter("level");
      String Salary = request.getParameter("salary_range");
      String startDate = request.getParameter("start_date");
      String EndDate = request.getParameter("end_date");
      String IdNumber = request.getParameter("id_numb");
      String Citizenship = request.getParameter("citizen");
      String EmployeeId ="53";
      
      boolean checker = employeeFac.UpdateExistingEmployee(EmployeeId, MaritalStatus, email, AreaCode, Integer.parseInt(ReleventExp), Integer.parseInt(GeneralExp), Surname, Name, IdNumber, Citizenship, CellNumber, PhysicalAdress, postalAddress, Level, Position, Date.valueOf("2010-01-01"), Date.valueOf("2011-01-01"), Double.parseDouble(Salary), Status);
      
      if(checker){
      
      response.getWriter().write("success");
      
      }
      else{
          
      response.getWriter().write("fail");
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
