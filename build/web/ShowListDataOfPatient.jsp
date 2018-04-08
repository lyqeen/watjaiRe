<%-- 
    Document   : ShowListDataOfPatient
    Created on : Apr 6, 2018, 12:03:57 AM
    Author     : User
--%>

<%@page import="Model.DataHealth"%>
<%@page import="java.util.List"%>
<%@page import="Model.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>ข้อมูลประจำตัวผู้ป่วย</title>

        <!--style-->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/wjdiapatStyle.css" rel="stylesheet">

        <!--font -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans|Prompt" rel="stylesheet">


        <!--Script-->

        <script src="js/jquery-3.2.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <!-- header -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">
                        <img alt="WATJAI" src="image/logoweb02.png" width="150" style="margin-top: -0.2em;">
                    </a>
                    <div class="pull-right logout">
                        <span style="color: #00939a;font-size: 12pt;">
                            นพ.รักชาติ ยิ่งชีพ</span>
                        <a href="Login.jsp" style="color: white"> ลงชื่อออก </a>
                    </div>

                </div>

            </div><!-- /.container-fluid -->
        </nav>


        <!-- side bar -->

        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">

            <ul class="nav menu">
                <li class="active customWH"><a href="/Watjai/ServletShowAllPatient" > รายชื่อผู้ป่วยทั้งหมด</a></li>
                <li class="customWH"><a href="/Watjai/ServletShowDiaPatient"> รายชื่อผู้ป่วยรอการวินิจฉัย</a></li>
                <li class="customWH"><a href="/Watjai/RegisterPatient.jsp"> ลงทะเบียนผู้ป่วย</a></li>
                <li class="customWH"><a href="#"> จัดการผู้ป่วย </a></li>
            </ul>

        </div><!--/.sidebar-->

        <!-- content-->
        <%
            Patient p = (Patient) request.getAttribute("patObj");
        %>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">

            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="/Watjai/ServletShowAllPatient">รายชื่อผู้ป่วย</a></li>
                    <li class="active"><%=p.getFname()%> <%=p.getLname()%></li>
                </ol>
            </div><!--/.row-->

            <!-- title main -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">ประวัติผู้ป่วย</h1>
                </div>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12 ">
                    <div class="panel panel-default di">
                        <div class="panel-body ti">
                            <form method="post">
                                <table  border="0">
                                    <tr>
                                        <td rowspan="4"  width="180px"><img src="image/uesr_image.png" class="img-circle "  width="150" height="150"></td>

                                        <td width="90px" valign="bottom" >
                                            ชื่อ-นามสกุล
                                        </td>
                                        <td >    
                                            <input type="text" class="info-pat" value="<%=p.getFname()%> <%=p.getLname()%>" readonly>
                                        </td>

                                        <td  width="90px" valign="bottom">
                                            อายุ  
                                        </td>
                                        <td> 
                                            <input type="text" class="info-pat" placeholder="อายุ" value="<%=p.getBirthdate()%>">
                                        </td>

                                    </tr>
                                    <tr>
                                        <td class="" valign="bottom" class="text-right mdtext">
                                            เพศ
                                        </td>
                                        <td> 
                                            <input type="text" class="info-pat" placeholder="เพศ" value="<%=p.getSex()%>">
                                        </td>
                                        <td valign="bottom"> 
                                            โรคประจำตัว
                                        </td>
                                        <td>     
                                            <input type="text" class="info-pat" placeholder="โรคประจำตัว" value="<%=p.getUnderlyingDisease()%>" readonly></td>

                                    </tr>
                                    <tr>
                                        <td class="" valign="bottom" class="text-right mdtext">
                                            กรุ๊ปเลือด
                                        </td>
                                        <td> 
                                            <input type="text" class="info-pat" placeholder="กรุ๊ปเลือด" value="<%=p.getBloodType()%>">
                                        </td>
                                        <td valign="bottom"> 
                                            เบอร์โทร
                                        </td>
                                        <td>     
                                            <input type="text" class="info-pat"
                                                   placeholder="เบอร์โทร" value="<%=p.getPatTel()%>" readonly></td>

                                    </tr>
                                    <tr >
                                        <td valign="bottom"> 
                                            ที่อยู่
                                        </td>
                                        <td colspan="3">     
                                            <input type="text" class="info-pat" placeholder="ที่อยู่"
                                                   value="<%=p.getAddress()%> <%=p.getSubDistrict()%> <%=p.getDistrict()%> <%=p.getProvince()%>"></td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                        <div class="panel-body si">
                            <ul id="myTab" class="nav nav-tabs">
                                <li class="active">
                                    <a href="#home" data-toggle="tab">ข้อมูลทั้งหมด</a>
                                </li>
                                <li><a href="#unread" data-toggle="tab">ข้อมูลการเต้นผิดปกติของหัวใจ ยังไม่ได้ตรวจสอบ</a></li>
                                <li><a href="#all" data-toggle="tab">ข้อมูลการเต้นผิดปกติของหัวใจ</a></li>

                            </ul>
                            <script type="text/javascript">
                                $(document).on('click', '#refresh', function () {
                                    var $link = $('li.active a[data-toggle="tab"]');
                                    $link.parent().removeClass('active');
                                    var tabLink = $link.attr('href');
                                    $('#myTab a[href="' + tabLink + '"]').tab('show');
                                });

                                $('a[data-toggle="tab"]').on('shown.bs.tab', function () {
                                    $('.show-time').html(new Date().toLocaleTimeString());
                                });
                            </script>


                            <div id="myTabContent" class="tab-content">
                                
                                <div class="tab-pane fade in active" id="home">
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <thead>

                                                <!--title header-->
                                                <tr class="" height="40px">
                                                    <th class="col-xs-4 text-center">ID </th>
                                                    <th class="col-xs-8 text-center">วันที่ส่ง</th>
                                                </tr>
                                            </thead>



                                            <tbody>
                                                <%
                                                    List<DataHealth> dhlist = (List) request.getAttribute("dataList");
                                                    int i = 1;
                                                    if (dhlist != null) {
                                                        for (DataHealth d : dhlist) {
                                                %>
                                                <tr  onclick="window.document.location = 'ServletShowGraph?idMea=<%=d.getMeasureId()%>&idPat=<%=p.getPatId()%>';">
                                                    <td class="text-center"><%=d.getMeasureId()%></td>

                                                    <td class="text-center"><%=d.getMeasureTime()%></td>
                                                </tr>
                                                <%}
                                                    }%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div class="tab-pane fade" id="unread">
                                  
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <thead>

                                                <!--title header-->
                                                <tr class="" height="40px">
                                                    <th class="col-xs-4 text-center">ID </th>
                                                    <th class="col-xs-8 text-center">วันที่และเวลาที่แจ้งเตือน</th>
                                                </tr>
                                            </thead>



                                            <tbody>
                                                <%
                                                    List<DataHealth> listUnread = (List) request.getAttribute("dataUnread");

                                                    if (listUnread != null) {
                                                        for (DataHealth unread : listUnread) {
                                                %>

                                                <tr  onclick="window.document.location = 'ServletShowGraphAbnormal?idPat=<%=p.getPatId()%>&idMea=<%=unread.getMeasureId()%>';">
                                                    <td class="text-center"><%=unread.getMeasureId()%></td>

                                                    <td class="text-center"><%=unread.getMeasureTime()%></td>
                                                </tr>
                                                <%}
                                                    }%>
                                            </tbody>
                                        </table>
                                    </div> 
                                </div>

                                <div class="tab-pane fade" id="all">
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <thead>

                                                <!--title header-->
                                                <tr class="" height="40px">
                                                    <th class="col-xs-4 text-center">ID </th>
                                                    <th class="col-xs-8 text-center">วันที่และเวลาที่แจ้งเตือน</th>
                                                </tr>
                                            </thead>



                                            <tbody>
                                                <%
                                                    List<DataHealth> dhm = (List) request.getAttribute("dataMea");

                                                    if (dhm != null) {
                                                        for (DataHealth dm : dhm) {
                                                %>

                                                <tr  onclick="window.document.location = 'ServletShowGraphRead?idPat=<%=p.getPatId()%>&idMea=<%=dm.getMeasureId()%>';">
                                                    <td class="text-center"><%=dm.getMeasureId()%></td>

                                                    <td class="text-center"><%=dm.getMeasureTime()%></td>
                                                </tr>
                                                <%}
                                                    }%>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </div>


        </div>

    </body>
</html>
