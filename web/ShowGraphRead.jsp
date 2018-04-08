<%-- 
    Document   : ShowGraphRead
    Created on : Apr 6, 2018, 12:29:26 AM
    Author     : User
--%>

<%@page import="Model.DataHealth"%>
<%@page import="Model.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="canvasjs-1.9.10-stable/canvasjs.min.js"></script>


        <!--style-->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/wjRegisterStyle.css" rel="stylesheet">

        <!--font -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans|Prompt" rel="stylesheet">
        <title>ข้อมูล ECG</title>
        <style>
            .opu{
                overflow-x: auto;
            }
        </style>
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

        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">

            <ul class="nav menu">
                <li class="customWH"><a href="/Watjai02/ServletShowAllPatient" > รายชื่อผู้ป่วยทั้งหมด</a></li>
                <li class="active customWH"><a href="/Watjai02/ServletShowDiaPatient"> รายชื่อผู้ป่วยรอการวินิจฉัย</a></li>
                <li class="customWH"><a href="/Watjai02/RegisterPatient.jsp"> ลงทะเบียนผู้ป่วย</a></li>
                <li class="customWH"><a href="#"> จัดการผู้ป่วย </a></li>
            </ul>

        </div><!--/.sidebar-->

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <%
                    Patient p = (Patient) request.getAttribute("patObj");
                %>
                <ol class="breadcrumb">
                    <li><a href="/Watjai/ServletShowAllPatient">รายชื่อผู้ป่วย</a></li>
                    <li><a href="/Watjai/ServletShowDataOfPatient?idPat=<%=p.getPatId()%>"><%=p.getFname()%> <%=p.getLname()%></a></li>
                    <!-- onclick='window.history.back()-->
                    <li class="active">ข้อมูล</li>
                </ol>
            </div><!--/.row-->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">ข้อมูล</h1>
                    <div class="panel panel-default di">
                        <%
                            DataHealth dh = (DataHealth) request.getAttribute("dataObj");
                        %>
                        <table border="0">
                            <tr>
                                <td valign="bottom" style="padding-left: 2em;">
                                    วันที่
                                </td>
                                <td>    
                                    <input type="text" class="info-pat" placeholder="วันที่" value="<%=dh.getMeasureTime()%>">
                                </td>

                                <td valign="bottom" style="padding-left: 3.8em;">    
                                    ID DataHealth
                                </td>
                                <td> 
                                    <input type="text" class="info-pat" placeholder="ID" value="<%=dh.getMeasureId()%>">
                                </td>
                            </tr>
                            <tr>
                                <td valign="bottom" style="padding-left: 2em;">
                                    ตรวจพบความผิดปกติทาง
                                </td>
                                <td>    
                                    <input type="text" class="info-pat" placeholder="อาการ" value="<%=dh.getAbnormalDetail()%>">
                                </td>
                            </tr>
                        </table><br><br>
                        <!--ID = <%=dh.getMeasureId()%> <br>
                        TIME =<%=dh.getMeasureTime()%> <br>
                        DATA = <%=dh.getMeasureData()%><br>-->
                    </div>
                    <div class="panel panel-default di opu">
                        <div id="chartContainer" style="height: 400px; width: 15000px;"></div>
                        <script type="text/javascript">
                            var xAxisStripLinesArray = [];
                            var yAxisStripLinesArray = [];
                            var dps = [];
                            var dataPointsArray = <%=dh.getMeasureData()%>;


                            var chart = new CanvasJS.Chart("chartContainer",
                                    {

                                        axisY: {
                                            stripLines: yAxisStripLinesArray,
                                            gridThickness: 2,
                                            gridColor: "#DC74A5",
                                            lineColor: "#DC74A5",
                                            tickColor: "#DC74A5",
                                            labelFontColor: "#DC74A5",
                                            maximum: 5
                                        },
                                        axisX: {
                                            stripLines: xAxisStripLinesArray,
                                            gridThickness: 2,
                                            gridColor: "#DC74A5",
                                            lineColor: "#DC74A5",
                                            tickColor: "#DC74A5",
                                            labelFontColor: "#DC74A5",
                                            
                                        },
                                        data: [
                                            {
                                                type: "spline",
                                                color: "black",
                                                dataPoints: dps
                                            }
                                        ]
                                    });

                            addDataPointsAndStripLines();
                            chart.render();

                            function addDataPointsAndStripLines() {
                                //dataPoints
                                for (var i = 0; i < dataPointsArray.length; i++) {
                                    dps.push({y: dataPointsArray[i]});
                                }
                                //StripLines
                                for (var i = 0; i < 3000; i = i + 0.1) {
                                    if (i % 1000 !== 0)
                                        yAxisStripLinesArray.push({value: i, thickness: 0.7, color: "#DC74A5"});
                                }
                                for (var i = 0; i < 10000; i = i + 1) {
                                    if (i % 1 === 0)
                                        xAxisStripLinesArray.push({value: i, thickness: 0.7, color: "#DC74A5"});
                                }
                            }
                        </script>
                    </div>


                    <div class="panel panel-default di">

                        <form>

                            <div class="form-group">
                                <label for="comment"> <h3> Comment</h3></label>
                                <textarea class="form-control" rows="6" id="comment" name="comment" readonly>
                                    <%=dh.getComment()%>
                                </textarea>
                            </div>

                        </form>
                    </div>





                </div>
            </div><!--/.row-->
        </div>

    </body>
</html>
