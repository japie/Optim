    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    package org.ftafrica.co.optime.controller;

    import java.io.IOException;
    import javax.ejb.EJB;
    import javax.naming.InitialContext;
    import javax.naming.NamingException;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import org.ftafrica.co.optime.bussinesslogic.feeders.LoginSessionTrackerInterface;



    /**
     *
     * @author Training 8
     */
    @EJB(name="tracker", beanInterface=LoginSessionTrackerInterface.class)
    public class LoginServlet extends HttpServlet {



        private static final String SESSION_TRACKER_BEAN_SESION_KEY  = "s_session tracker_t";





        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            try{
              String username = request.getParameter("username");
              String password = request.getParameter("password");


                LoginSessionTrackerInterface loginSeesionTrackerBean = (LoginSessionTrackerInterface) request.getSession().getAttribute(SESSION_TRACKER_BEAN_SESION_KEY);

                
          // EJB is not present in the HTTP session
          // so let's fetch a new one from the container
          try {
            InitialContext ic = new InitialContext();
            loginSeesionTrackerBean = (LoginSessionTrackerInterface)
             ic.lookup("java:comp/env/tracker");

            // java:global/Optim/LoginSessionTracker
            request.getSession().setAttribute(
              SESSION_TRACKER_BEAN_SESION_KEY, 
              loginSeesionTrackerBean);

          } catch (NamingException e) {
            throw new ServletException(e);
          }
        

               boolean loginValidated =  loginSeesionTrackerBean.CreateSessionId(username, password); 

               if(loginValidated){






                /*  Employees emp = loginSeesionTrackerBean.GetExistingUser(loginSeesionTrackerBean.getSessionID());
                  CurrentUser cur= new CurrentUser();
                  cur.setName(emp.getName());
                  cur.setSurname(emp.getSurname());
                  //request.getSession().setAttribute("current_user", cur);*/



         //request.getRequestDispatcher("Dashboard.jsp"); 
         String site = new String("Dashboard.html");


         response.sendRedirect(site);



            }

            else if(!loginValidated){

              response.setContentType("text/html");

          // New location to be redirected
          String site = new String("err.html");

          response.setStatus(response.SC_MOVED_TEMPORARILY);
          response.setHeader("Location", site);  


                  } 



            }catch(Exception e){
            e.printStackTrace();
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
