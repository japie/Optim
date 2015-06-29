/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftafrica.co.optime.bussinesslogic.LoginSessionTracker;
import com.google.gson.Gson;



/**
 *
 * @author Training 8
 */

public class LoginServlet extends HttpServlet {
    @EJB
    LoginSessionTracker lsTracker;
    

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
        try{
          String username = request.getParameter("user");
          String password = request.getParameter("password");
          Gson loginGson = new Gson();
          LoginServletHelper helper = new  LoginServletHelper();
          
          
          
        boolean loginValidated =  lsTracker.CreateSessionId(username, password);
        
        if(loginValidated){
            
            helper.setSessionTrackerID(lsTracker.getSessionID());
            helper.setUrl("dashb.html");
            helper.setStatus("success");
           
           
           response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
  // response.getWriter().write(loginGson.toJson(helper));
            System.out.println(loginGson.toJson(helper));
      
        }
         
        else if(!loginValidated){
              
           response.setContentType("text/plain"); 
  response.setCharacterEncoding("UTF-8"); 
  response.getWriter().write("invalid login details");   
              
              } 
            
        
        }catch(Exception e){
        
            // Set response content type
      response.setContentType("text/html");

      // New location to be redirected
      String site = new String("err.html");

      response.setStatus(response.SC_MOVED_TEMPORARILY);
      response.setHeader("Location", site); 
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
