<%-- 
    Document   : ShowDiaPatient
    Created on : Apr 5, 2018, 11:55:59 PM
    Author     : User
--%>

<%@page import="Model.Patient"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <!--style-->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/styleShowDiaPatient.css" rel="stylesheet">

        <!--font -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans|Prompt" rel="stylesheet">


        <title>WATJAI - รายชื่อผู้ป่วยรอการวินิจฉัย</title>

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
                           นพ.รักชาติ ยิ่งชีพ </span>
                        <a href="Login.jsp" style="color: white"> ลงชื่อออก </a>
                    </div>

                </div>

            </div><!-- /.container-fluid -->
        </nav>


        <!-- side bar -->

        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">

            <ul class="nav menu">
                <li class="customWH"><a href="/Watjai/ServletShowAllPatient"> รายชื่อผู้ป่วยทั้งหมด</a></li>
                <li class="active customWH"><a href="/Watjai/ServletShowDiaPatient"> รายชื่อผู้ป่วยรอการวินิจฉัย</a></li>
                <li class="customWH"><a href="/Watjai/RegisterPatient.jsp"> ลงทะเบียนผู้ป่วย</a></li>
                <li class="customWH"><a href="#"> จัดการผู้ป่วย </a></li>


            </ul>

        </div><!--/.sidebar-->


        <!-- content-->
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">

            <div class="row">
                <ol class="breadcrumb">
                    <li class="active">รายชื่อผู้ป่วยรอการวินิจฉัย</li>

                </ol>
            </div><!--/.row-->

            <!-- title main -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">รายชื่อผู้ป่วยรอการวินิจฉัย</h1>
                </div>
            </div><!--/.row-->

            <!--table-->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <table class="table table-hover order-table">
                            <thead>

                                <!--Search-->
                                <tr style="height: 3.5em;">
                                    <!--search image-->
                                    <td class="textcenter" >
                                         <img src="image/search.png" style="
                                             height: 18px;
                                             margin-top: 8px;"/>
                                    </td>
                                    <!--filter search-->
                                    <td style="padding-top: 1em;">
                                        <div class="inputSearch">
                                            <input type="search" class="light-table-filter" data-table="order-table" placeholder="Search">
                                        </div>
                                    </td>
                                </tr>

                                <!--title header-->
                                <tr class="title-head">
                                    <th class="col-xs-1 text-center">#</th>
                                    <th class="col-xs-5">ชื่อ-นามสกุล</th>
                                    <th class="col-xs-2 text-center">สภานะ</th>
                                    <th class="col-xs-2 text-center">รหัสผู้ป่วย</th>
                                    <th class="col-xs-2 text-center">รหัสข้อมูลผิดกติ</th>
                                </tr>
                            </thead>

                            <%

                                List<Patient> plist = (List) request.getAttribute("patinetList");
                                int i = 1;
                                if (plist != null) {
                                    for (Patient pa : plist) {

                            %>

                            <tbody>
                                <!--/ShowGraphAbnormal?idPat=PA1709001&idMea=ME17103000001-->
                                <tr onclick="window.document.location = 'ServletShowGraphAbnormal?idPat=<%=pa.getPatId()%>&idMea=<%=pa.getIdMea()%>';">
                                    <td class="text-center"> <%=i%> </td>
                                    <td>
                                        <div class="media">
                                            <a href="#" class="pull-left">
                                                <img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
                                            </a>
                                            <div class="media-body">
                                                <%=pa.getFname()%>  <%=pa.getLname()%>
                                                <p class="summary">โรคประจำตัว <%=pa.getUnderlyingDisease()%></p>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-center">รอการวินิจฉัย</td>
                                    <td class="text-center"><%=pa.getPatId()%></td>
                                    <td class="text-center"><%=pa.getIdMea()%></td>
                                </tr>
                            </tbody>

                            <% i++;
                                    }
                                } else {
                                    System.out.println("no info");
                                }
                            %>

                        </table>
                    </div>
                </div>
            </div><!--/.row-->

        </div>   

       <script type="text/javascript">
            (function (document) {
                'use strict';

                var LightTableFilter = (function (Arr) {

                    var _input;

                    function _onInputEvent(e) {
                        _input = e.target;
                        var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
                        Arr.forEach.call(tables, function (table) {
                            Arr.forEach.call(table.tBodies, function (tbody) {
                                Arr.forEach.call(tbody.rows, _filter);
                            });
                        });
                    }

                    function _filter(row) {
                        var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
                        row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';
                    }

                    return {
                        init: function () {
                            var inputs = document.getElementsByClassName('light-table-filter');
                            Arr.forEach.call(inputs, function (input) {
                                input.oninput = _onInputEvent;
                            });
                        }
                    };
                })(Array.prototype);

                document.addEventListener('readystatechange', function () {
                    if (document.readyState === 'complete') {
                        LightTableFilter.init();
                    }
                });

            })(document);
        </script>

    </body>
</html>
