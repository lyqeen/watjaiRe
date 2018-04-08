/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author User
 */
public class ServletRegister extends HttpServlet {

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

        String name = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String bd = request.getParameter("birthDate");
        String Address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String bloodtype = request.getParameter("bloodtype");
        String doc = request.getParameter("docterId");
        String underly = request.getParameter("undl");
        String subdis = request.getParameter("subDis");
        String District = request.getParameter("district");
        String province = request.getParameter("province");
        String sex = request.getParameter("sex");
        String relativeName = request.getParameter("relativeName");
        String relativeTel = request.getParameter("relativeTel");

        if (name.isEmpty() || lname.isEmpty() || bd.isEmpty() || Address.isEmpty() || tel.isEmpty() || bloodtype.isEmpty()) {

            getServletContext().getRequestDispatcher("/RegisterPatient.jsp").include(request, response);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('User or password incorrect');");
            out.println("location='index.jsp';");
            out.println("</script>");

        } else {

            HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead 

            HttpPost requestq = new HttpPost("http://139.59.98.254:3000/patients");

            System.out.println(bd);

            StringEntity params
                    = new StringEntity(("{\"patFirstName\" : \""+name+"\","
                                        +"\"patLastName\" : \""+lname+"\","
                                        +"\"birthDay\" : \""+bd+"\","
                                        +"\"address\" : \""+Address+"\","
                                        +"\"subDistrict\" : \""+subdis+"\","
                                        +"\"district\" : \""+District+"\","
                                        +"\"province\" : \""+province+"\","
                                        +"\"patTel\" : \""+tel+"\","
                                        +"\"bloodType\" : \""+bloodtype+"\","
                                        +"\"docId\" : \"DO1803001\","
                                        +"\"underlyingDisease\" : \""+underly+"\","
                                        +"\"sex\" : \""+sex+"\","
                                        +"\"relativeName\" : \""+relativeName+"\","
                                        +"\"relativeTel\" : \""+relativeTel+"\","
                                        +"\"patPic\" : \"SLKDJFSI\"}"),
                        "UTF-8");

            requestq.setEntity(params);
            

            HttpResponse responseq = httpClient.execute(requestq);
            System.out.println(responseq);
            System.out.println("nonono");
            getServletContext().getRequestDispatcher("/ServletShowAllPatient").forward(request, response);
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
