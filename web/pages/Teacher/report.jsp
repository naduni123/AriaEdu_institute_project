<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="util.DataAccess" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Teacher Details Report</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../assets/vendor/bootstrap/css/bootstrap.min.css">
    <style>
        .styled-table {
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 0.9em;
            font-family: sans-serif;
            min-width: 400px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
        }
        .styled-table thead tr {
            background-color: #011cdb;
            color: #ffffff;
            text-align: left;
        }
        .styled-table th,
        .styled-table td {
            padding: 12px 15px;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <!-- Main content -->
    <section class="invoice" id="pdf">
        <!-- title row -->
        <div class="row">
            <div class="col-12">
                <h2 class="page-header">
<%--                    <i class="fas fa-globe"></i> <a class="navbar-brand" href="../../TeacherDashboard.jsp">AriaEdu</a>--%>
                    <a class="navbar-brand" href="../../TeacherDashboard.jsp"><img src="../../assets/images/logo.png"></a>
                    <small class="float-right" id="date">Date: 2/10/2014</small>
                </h2>
            </div>
            <!-- /.col -->
        </div>
        <!-- info row -->
        <div class="card">
            <div class="card-body">
                <div class="row invoice-info">
                    <div class="col-sm-4 invoice-col">
                        <address>
                            Status : <%if (request.getParameter("status").equals("1")){
                            out.print("Current");
                        }else if(request.getParameter("status").equals("0")){
                            out.print("Past");
                        }else {
                            out.print("All");
                        }
                        %><br>
                            Subject : <%if (request.getParameter("sub").equals("all")){
                            out.print("All");
                        }else {
                            out.print(request.getParameter("sub"));
                        }
                        %>
                        </address>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-12 table-responsive">
                <table class="table table-striped styled-table">
                    <thead>
                    <tr>
                        <th>Full Name</th>
                        <th>Gender</th>
                        <th>Contact Number</th>
                        <th>NIC</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Subject</th>
                    </tr>

                    </thead>
                    <tbody>
                    <%
                        String txt=request.getParameter("txt");
                        String status=request.getParameter("status");
                        String subject=request.getParameter("sub");
                        Connection con = DataAccess.connect();
                        String sql = "select * from teacher where (full_name like '%"+txt+"%' or nic like '%"+txt+"%'  or contact_no like '%"+txt+"%')";
                        if (status.equals("all")){
                            if (subject.equals("all")){

                            }else{
                                sql = sql + " and subject='"+subject+"'";
                            }
                        }else {
                            if (subject.equals("all")){
                                sql = sql + " and status='"+status+"'";
                            }else{
                                sql = sql + " and status='"+status+"' and subject='"+subject+"'";
                            }

                        }
                        try {
                            PreparedStatement ps = con.prepareStatement(sql);

                            ResultSet resultset = ps.executeQuery();

                            while(resultset.next()) {%>
                    <tr class="active-row">
                        <td><%=resultset.getString("full_name") %></td>
                        <td><%=resultset.getString("gender") %></td>
                        <td><%=resultset.getString("contact_no") %></td>
                        <td><%=resultset.getString("nic") %></td>
                        <td><%=resultset.getString("address") %></td>
                        <td><%=resultset.getString("email") %></td>
                        <td><%=resultset.getString("subject") %></td>
                    </tr>
                    <%
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                    </tbody>
                </table>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->

        <div class="row">

        </div>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- ./wrapper -->
<!-- Page specific script -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
<script>
    window.addEventListener("load", window.print());
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0');
    var yyyy = today.getFullYear();

    today = dd + '/' + mm + '/' + yyyy;
    document.getElementById("date").innerText=today;
    createPDF();
    function createPDF() {
        html2canvas(document.getElementById('pdf'), {
            onrendered: function (canvas) {
                var data = canvas.toDataURL();
                var docDefinition = {
                    content: [{
                        image: data,
                        width: 530
                    }]
                };
                pdfMake.createPdf(docDefinition).download("Teacher.pdf");
            }
        });
    }
</script>
</body>
</html>
