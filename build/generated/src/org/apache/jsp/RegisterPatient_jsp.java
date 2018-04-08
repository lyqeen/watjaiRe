package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegisterPatient_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <script src=js/jquery-3.2.0.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--style-->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/wjRegisterStyle.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!--font -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Open+Sans|Prompt\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <title>ลงทะเบียนผู้ป่วย</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- header -->\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#sidebar-collapse\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">\n");
      out.write("                        <img alt=\"WATJAI\" src=\"image/logoweb02.png\" width=\"150\" style=\"margin-top: -0.2em;\">\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"pull-right logout\">\n");
      out.write("                        <span style=\"color: #00939a;font-size: 12pt;\">\n");
      out.write("                            นพ.รักชาติ ยิ่งชีพ </span>\n");
      out.write("                        <a href=\"Login.jsp\" style=\"color: white\"> ลงชื่อออก </a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div><!-- /.container-fluid -->\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- side bar -->\n");
      out.write("\n");
      out.write("        <div id=\"sidebar-collapse\" class=\"col-sm-3 col-lg-2 sidebar\">\n");
      out.write("\n");
      out.write("            <ul class=\"nav menu\">\n");
      out.write("                <li class=\"customWH\"><a href=\"/Watjai/ServletShowAllPatient\" > รายชื่อผู้ป่วยทั้งหมด</a></li>\n");
      out.write("                <li class=\"customWH\"><a href=\"/Watjai/ServletShowDiaPatient\"> รายชื่อผู้ป่วยรอการวินิจฉัย</a></li>\n");
      out.write("                <li class=\"active customWH\"><a href=\"/Watjai/RegisterPatient.jsp\"> ลงทะเบียนผู้ป่วย</a></li>\n");
      out.write("                <li class=\"customWH\"><a href=\"#\"> จัดการผู้ป่วย </a></li>\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("        </div><!--/.sidebar-->\n");
      out.write("\n");
      out.write("        <!-- content-->\n");
      out.write("        <div class=\"col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main\">\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <ol class=\"breadcrumb\">\n");
      out.write("                    <li class=\"active\">ลงทะเบียนผู้ป่วย</a></li>\n");
      out.write("\n");
      out.write("                </ol>\n");
      out.write("            </div><!--/.row-->\n");
      out.write("\n");
      out.write("            <!-- title main -->\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <h1 class=\"page-header\">ลงทะเบียนผู้ป่วย</h1>\n");
      out.write("                </div>\n");
      out.write("            </div><!--/.row-->\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <div class=\"panel panel-default di\">\n");
      out.write("                        <form action=\"ServletRegister\" method=\"post\">\n");
      out.write("                            <table>\n");
      out.write("                                <tr height=\"75px\"> \n");
      out.write("                                    <td width=\"110px\" >ชื่อ</td>\n");
      out.write("                                    <td ><input type=\"text\" name=\"fname\" placeholder=\"ชื่อ\" class=\"info-pat\"  pattern=\".{2,50}\"/></td>\n");
      out.write("                                    <td width=\"110px\" >นามสกุล</td>\n");
      out.write("                                    <td><input type=\"text\" name=\"lname\" placeholder=\"นามสกุล\" class=\"info-pat\" pattern=\".{2,50}\" /></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr height=\"75px\">\n");
      out.write("                                    <td >วันเกิด</td>\n");
      out.write("                                    <td><input type=\"date\" name=\"birthDate\"  class=\"info-pat\" required/></td>\n");
      out.write("                                    <td >เพศ</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <!--<input type=\"text\" name=\"sex\"  class=\"info-pat\" required/>-->\n");
      out.write("                                        <select name=\"sex\"  class=\"info-pat\" >\n");
      out.write("                                            <option value=\"ชาย\">ชาย</option>\n");
      out.write("                                            <option value=\"หญิง\">หญิง</option>\n");
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr height=\"75px\">\n");
      out.write("                                    <td >กรุ๊ปเลือด</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <!-- <input type=\"text\" name=\"bloodtype\"  class=\"info-pat\" required/>-->\n");
      out.write("                                        <select name=\"bloodtype\"  class=\"info-pat\" >\n");
      out.write("                                            <option value=\"A\">A</option>\n");
      out.write("                                            <option value=\"AB\">AB</option>\n");
      out.write("                                            <option value=\"B\">B</option>\n");
      out.write("                                            <option value=\"O\">O</option>\n");
      out.write("                                        </select>\n");
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                    <td >โรคประจำตัว</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" name=\"undl\" class=\"info-pat\" placeholder=\"โรคประจำตัว\" required style=\"\n");
      out.write("                                               margin-right: 0px;\">\n");
      out.write("                                        <span style=\"font-size: 9pt;\">(หากไม่มี ให้ระบุว่า \"ไม่มี\" )</span>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr height=\"75px\" >\n");
      out.write("                                    <td >ที่อยู่</td>\n");
      out.write("                                    <td><input type=\"text\" name=\"address\"   class=\"info-pat\" placeholder=\"บ้านเลขที่/หมู่บ้าน\" required/></td>\n");
      out.write("                                    <td >ตำบล</td>\n");
      out.write("                                    <td><input type=\"text\" name=\"subDis\"  class=\"info-pat\"placeholder=\"ตำบล\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr height=\"75px\" >\n");
      out.write("                                    <td >อำเภอ</td>\n");
      out.write("                                    <td><input type=\"text\" name=\"district\"  class=\"info-pat\" placeholder=\"อำเภอ\" required/></td>\n");
      out.write("                                    <td>จังหวัด</td>\n");
      out.write("                                    <td><input type=\"text\" name=\"province\"  class=\"info-pat\" placeholder=\"จังหวัด\" required /></td>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("                                <tr  height=\"75px\">\n");
      out.write("                                    <td >เบอร์โทรศัพท์</td>\n");
      out.write("                                    <td><input type=\"text\" name=\"tel\"   class=\"info-pat\" placeholder=\"เบอร์โทรศัพท์\" required /></td>\n");
      out.write("                                    <td >แพทย์ที่ดูแล</td>\n");
      out.write("\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" name=\"docterId\" class=\"info-pat\" readonly  value=\"นพ.รักชาติ ยิ่งชีพ\"/></td>       \n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                \n");
      out.write("                                <tr  height=\"75px\">\n");
      out.write("                                    <td >ชื่อญาติของผู้ป่วย</td>\n");
      out.write("                                    <td><input type=\"text\" name=\"relativeName\"   class=\"info-pat\" placeholder=\"ชื่อญาติของผู้ป่วย\" required /></td>\n");
      out.write("                                    <td >เบอร์โทรศัพท์ญาติของผู้ป่วย</td>\n");
      out.write("\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" name=\"relativeTel\" class=\"info-pat\" placeholder=\"เบอร์โทรศัพท์ญาติของผู้ป่วย\" required /></td>       \n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("                            </table><br>\n");
      out.write("                            <div class=\"submit-btn\">\n");
      out.write("                                <input  type=\"submit\" value=\"register\"  />\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
