/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anurag
 */
public class Send extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession ses=request.getSession();
            if(request.getParameterMap().containsKey("smtp")){
            
                String smtp=request.getParameter("smtp").trim();
                String from=request.getParameter("from").trim();
                String username=request.getParameter("username").trim();
                String password=request.getParameter("password").trim();
                String port=request.getParameter("port").trim();
                 GetProperty api=new GetProperty();
                 api.setFrom(from);
                api.setPassword(password);
                api.setSmtp(smtp);
                api.setUser(username);
                api.setPort(port);
                
                //
                ses.setAttribute("from", from);ses.setAttribute("smtp", smtp);ses.setAttribute("username", username);
                ses.setAttribute("password", password);
                //
            if(request.getParameterMap().containsKey("emails"))
            {
                
                String emails=request.getParameter("emails");
               
                String emailid[]=emails.split(",");
                String subject =request.getParameter("subject");
                String msg=request.getParameter("message");
               
                
                for(String email:emailid)
                {
                    if(isValidEmailAddress(email))
                    out.print(MailSend.email2(api, email, subject, msg)+"<br/>");
                    else
                        out.print("<br/> Invalid email id ="+email);
                    
                }
                
                
            }
            
            
            }
            
            
        }
    }
    
    public static boolean isValidEmailAddress(String email) {
   boolean result = true;
   try {
      InternetAddress emailAddr = new InternetAddress(email);
      emailAddr.validate();
   } catch (AddressException ex) {
      result = false;
   }
   return result;
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
