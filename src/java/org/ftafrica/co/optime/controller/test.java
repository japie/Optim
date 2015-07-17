/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.controller;

import static com.sun.faces.facelets.util.Path.context;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftafrica.co.optime.bussinesslogic.feeders.LoginSessionTracker;
import org.ftafrica.co.optime.bussinesslogic.feeders.LoginSessionTrackerInterface;

/**
 *
 * @author Training 8
 */
public class test extends HttpServlet {

    private static final String SESSION_TRACKER_BEAN_SESION_KEY  = "s_session tracker_t";
    
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
            
            if(loginSeesionTrackerBean == null){
      // EJB is not present in the HTTP session
      // so let's fetch a new one from the container
      try {
        InitialContext ic = new InitialContext();
        loginSeesionTrackerBean = (LoginSessionTrackerInterface)
         ic.lookup("java:app/LoginSessionTracker/[LoginSessionTrackerInterface]");
        
        // put EJB in HTTP session for future servlet calls
        request.getSession().setAttribute(SESSION_TRACKER_BEAN_SESION_KEY,loginSeesionTrackerBean);
        
      } catch (NamingException e) {
        throw new ServletException(e);
      }
    }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet test at " + loginSeesionTrackerBean.getSessionID() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
