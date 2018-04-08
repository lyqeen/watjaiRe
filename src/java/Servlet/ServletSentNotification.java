/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author User
 */
public class ServletSentNotification extends HttpServlet {

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
         request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String comment = request.getParameter("comment");
        String idmea = request.getParameter("id");
        String idPat = request.getParameter("idPat");

        System.out.println(idmea);
        System.out.println("cOMMENT : " + comment);
         HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 
        System.out.println("Print patch" + httpClient);
        HttpPatch requestu = new HttpPatch("http://139.59.98.254:3000/watjaimeasure/comment/" + idmea);
        System.out.println("Print patch" + requestu);

        try {
            
            TimeZone tz = TimeZone.getTimeZone("UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
            df.setTimeZone(tz);
            String nowAsISO = df.format(new Date());
        
        StringEntity params
                = new StringEntity(("{\"measuringTime\":\""+nowAsISO+"\","
                        + "\"comment\":\"" + comment + "\"}"),
                        "UTF-8");

            
         
            System.out.println("param : " + params);
            //params.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

            requestu.setEntity(params);
            HttpResponse responseq = httpClient.execute(requestu);
            System.out.println("Complete");
            System.out.println("rsponce" + responseq);
        } catch (Exception e) {
            System.out.println("exception01" + e);
        }
          

        getServletContext().getRequestDispatcher("/ServletShowDataOfPatient?idPat="+idPat).forward(request, response);
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
