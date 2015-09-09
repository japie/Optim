/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ftafrica.co.optime.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ftafrica.co.optime.bussinesslogic.feeders.NewEmpBean;
import org.ftafrica.co.optime.model.Education;
import org.ftafrica.co.optime.model.Employees;
import org.ftafrica.co.optime.model.Projects;
import org.ftafrica.co.optime.model.Work;

/**
 *
 * @author 8460p
 */
@WebServlet(name = "Reg_servlet", urlPatterns = {"/Reg_servlet"})
public class Reg_servlet extends HttpServlet {

    @EJB
    NewEmpBean eb;
    
    Employees emp = new Employees();
    Work wrk = new Work();
    Education edu = new Education();
    Projects proj = new Projects();
    
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
        
        //Add employee information
         Random gen = new Random();
             int f = gen.nextInt(999999);
             String a = String.valueOf(f);
               try{ 
        emp.setName(request.getParameter("fname"));
               }catch(Exception e){
                 System.out.println(e+"_name has a prob");
               }
            try{
        emp.setSurname(request.getParameter("lname"));
            }catch(Exception e){
            System.out.println(e+"_lname has a prob");
            
            }
            try{
                
                // not good 
       emp.setAreaCode(request.getParameter("areacode"));
            }catch(Exception e){
            System.out.println(e+"_areaCode has a prob");
            }
            try{
                //good
        emp.setCellphoneNumber(request.getParameter("cellNum"));
            }catch(Exception e){
               System.out.println(e+"_cellNum has a prob");
            }
            try{
                
                //good
        emp.setCitizenship(request.getParameter("citizen"));
            }catch(Exception e){
            System.out.println(e+"_citizen has a prob");
            }
            try{
                //good
        emp.setEmailAddress(request.getParameter("email"));
            }catch(Exception e){
            System.out.println(e+"_email has a prob");
            }
            try{
            
       emp.setEmployeeId(a);
            }catch(Exception e){
            System.out.println(e+"_empId has a prob");
            }
            try{
                //solved
        emp.setIdUmber(request.getParameter("id"));
            }catch(Exception e ){
            System.out.println(e+"_idNumber has a prob");
            }
            try{
        emp.setMaritalstatus(request.getParameter("mstatus"));
            }catch(Exception e){
            System.out.println(e+"_marital has a prob");
            }
            try{
        emp.setPhysicalAddress(request.getParameter("phaddress"));
            }catch(Exception e){
            System.out.println(e+"_phAddress has a prob");
            }
            try{
        emp.setPostalAddress(request.getParameter("paddress"));
            }catch(Exception e){
            System.out.println(e+"_postal has a prob");
            }
        eb.insertEmpData(emp);
       //insert education data     
          Random genX = new Random();
             int n = genX.nextInt(999999);
             String x = "edu"+n;
             
       
            edu.setYearCompleted(Date.valueOf(request.getParameter("completedY"))); 
       edu.setEducationId(x);
       edu.setInstitution(request.getParameter("varsity"));
       edu.setQualification(request.getParameter("qual"));
       edu.setFile(null);
       edu.setEmployeeId(eb.emp(a));
        try {
            Thread.sleep(1000);
            eb.insertEdu(edu);
        } catch (InterruptedException ex) {
            Logger.getLogger(Reg_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        wrk.setCompany(request.getParameter("Cmp"));
        wrk.setContract(request.getParameter("contract"));
        wrk.setDepartment(request.getParameter("dpt"));
        wrk.setEmployeeId(eb.emp(a));
        wrk.setEndDate(Date.valueOf(request.getParameter("endD")));
        wrk.setGeneralExperience(Integer.parseInt(request.getParameter("genE")));
        wrk.setLevel(request.getParameter("levl"));
        wrk.setNoticeDate(Date.valueOf("2015-01-01"));
        wrk.setPosition(request.getParameter("pos"));
        wrk.setRelevantExperience(Integer.parseInt(request.getParameter("relE")));
        wrk.setStartDate(Date.valueOf(request.getParameter("startD")));
        wrk.setStatus("Active");
        wrk.setSalaryRange(Double.parseDouble(request.getParameter("salary")));
        Random genW = new Random();
             int w = genW.nextInt(999999);
             String st = String.valueOf(w);
        wrk.setWorkId(st);
       try {
            Thread.sleep(1000); 
        eb.Current_pos(wrk);
       }catch(InterruptedException i ){
          Logger.getLogger(Reg_servlet.class.getName()).log(Level.SEVERE, null, i);
       }
       
        
        eb.updateCapProj(request.getParameter("hidden_id"));
        response.sendRedirect("profiles.html");
        
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
