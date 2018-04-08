/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DataHealth;
import Model.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ServletShowDataOfPatient extends HttpServlet {

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
         String idPat = (String)request.getParameter("idPat");
        
        DataHealth dh = new DataHealth();
        List<DataHealth> dhList = null;
        List<DataHealth> dhListMea = null;
        List<DataHealth> dhListMeaUnread = null; 
        Patient p = null;
         try {
           System.out.println("idPAt:"+idPat);
             dhList = DataHealth.doReadListData(idPat);
             dhListMea = DataHealth.ReciveURL("http://139.59.98.254:3000/patients/",idPat,"/watjaimeasure/commented");
             dhListMeaUnread = DataHealth.ReciveURL("http://139.59.98.254:3000/patients/",idPat,"/watjaimeasure/uncomment");
          
             p = p.showInfo(idPat);
        System.out.println("showList"+dhList);
        System.out.println("dhListMea"+dhListMea);
          
        } catch (Exception e) {
        }
        
       
        request.setAttribute("dataList", dhList);
        request.setAttribute("patObj", p);
        request.setAttribute("dataMea", dhListMea);
        request.setAttribute("dataUnread", dhListMeaUnread);
        getServletContext().getRequestDispatcher("/ShowListDataOfPatient.jsp").forward(request, response);
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
