<%@ page import="service.StudentService" %>
<%@ page import="model.Student" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Hansaka Dilshan
  Date: 8/19/2021
  Time: 9:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/libs/css/style.css">
    <link rel="stylesheet" href="assets/libs/css/hanskacss.css">
    <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="assets/vendor/charts/chartist-bundle/chartist.css">
    <link rel="stylesheet" href="assets/vendor/charts/morris-bundle/morris.css">
    <link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">
    <link rel="stylesheet" href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css">

    <title>AriaEdu | Student List</title>
</head>

<body>
<!-- ============================================================== -->
<!-- main wrapper -->
<!-- ============================================================== -->
<div class="dashboard-main-wrapper">
    <!-- ============================================================== -->
    <!-- navbar -->
    <!-- ============================================================== -->
    <div class="dashboard-header">
        <nav class="navbar navbar-expand-lg bg-white fixed-top">
            <img src="documentation\img\logo.png">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto navbar-right-top">
                    <li class="nav-item">
                        <div id="custom-search" class="top-search-bar">
                            <input class="form-control" type="text" placeholder="Search..">
                        </div>
                    </li>
                    <li class="nav-item dropdown notification">
                        <a class="nav-link nav-icons" href="#" id="navbarDropdownMenuLink1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-fw fa-bell"></i> <span class="indicator"></span></a>
                        <ul class="dropdown-menu dropdown-menu-right notification-dropdown">
                            <li>
                                <div class="notification-title"> Notification</div>
                                <div class="notification-list">
                                    <div class="list-group">
                                        <a href="#" class="list-group-item list-group-item-action active">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img src="assets/images/avatar-2.jpg" alt="" class="user-avatar-md rounded-circle"></div>
                                                <div class="notification-list-user-block"><span class="notification-list-user-name">Jeremy Rakestraw</span>accepted your invitation to join the team.
                                                    <div class="notification-date">2 min ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item list-group-item-action">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img src="assets/images/avatar-3.jpg" alt="" class="user-avatar-md rounded-circle"></div>
                                                <div class="notification-list-user-block"><span class="notification-list-user-name">John Abraham </span>is now following you
                                                    <div class="notification-date">2 days ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item list-group-item-action">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img src="assets/images/avatar-4.jpg" alt="" class="user-avatar-md rounded-circle"></div>
                                                <div class="notification-list-user-block"><span class="notification-list-user-name">Monaan Pechi</span> is watching your main repository
                                                    <div class="notification-date">2 min ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item list-group-item-action">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img src="assets/images/avatar-5.jpg" alt="" class="user-avatar-md rounded-circle"></div>
                                                <div class="notification-list-user-block"><span class="notification-list-user-name">Jessica Caruso</span>accepted your invitation to join the team.
                                                    <div class="notification-date">2 min ago</div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list-footer"> <a href="#">View all notifications</a></div>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown connection">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="fas fa-fw fa-th"></i> </a>
                        <ul class="dropdown-menu dropdown-menu-right connection-dropdown">
                            <li class="connection-list">
                                <div class="row">
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src="assets/images/github.png" alt="" > <span>Github</span></a>
                                    </div>
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src="assets/images/dribbble.png" alt="" > <span>Dribbble</span></a>
                                    </div>
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src="assets/images/dropbox.png" alt="" > <span>Dropbox</span></a>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src="assets/images/bitbucket.png" alt=""> <span>Bitbucket</span></a>
                                    </div>
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src="assets/images/mail_chimp.png" alt="" ><span>Mail chimp</span></a>
                                    </div>
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src="assets/images/slack.png" alt="" > <span>Slack</span></a>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="conntection-footer"><a href="#">More</a></div>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown nav-user">
                        <a class="nav-link nav-user-img" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="assets/images/avatar-1.jpg" alt="" class="user-avatar-md rounded-circle"></a>
                        <div class="dropdown-menu dropdown-menu-right nav-user-dropdown" aria-labelledby="navbarDropdownMenuLink2">
                            <div class="nav-user-info">
                                <h5 class="mb-0 text-white nav-user-name">John Abraham </h5>
                                <span class="status"></span><span class="ml-2">Available</span>
                            </div>
                            <a class="dropdown-item" href="#"><i class="fas fa-user mr-2"></i>Account</a>
                            <a class="dropdown-item" href="#"><i class="fas fa-cog mr-2"></i>Setting</a>
                            <a class="dropdown-item" href="#"><i class="fas fa-power-off mr-2"></i>Logout</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <!-- ============================================================== -->
    <!-- end navbar -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- left sidebar -->
    <!-- ============================================================== -->
    <%@include file="header.jsp" %>
    <!-- ============================================================== -->
    <!-- end left sidebar -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- wrapper  -->
    <!-- ============================================================== -->
    <div class="dashboard-wrapper">
        <div class="dashboard-ecommerce">
            <div class="container-fluid dashboard-content ">
                <!-- ============================================================== -->
                <!-- pageheader  -->
                <!-- ============================================================== -->
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="page-header">
                            <h2 class="pageheader-title">View Student Details</h2>
                            <div class="page-breadcrumb">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="indexhome.jsp" class="breadcrumb-link">Dashboard</a></li>
                                        <li class="breadcrumb-item"><a href="student_management_dashboard.jsp" class="breadcrumb-link">Student Management</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">View Student Details</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- end pageheader  -->
                <!-- ============================================================== -->

                <!-- ========================================Student List-------------->
                <div class="row">
                    <!-- ============================================================== -->
                    <!-- basic table  -->
                    <!-- ============================================================== -->
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card">
                            <h5 class="card-header">View Student Details</h5>
                            <div class="card-deck">
                                <div class="card bg-grey">
                                    <div class="card-body text-center">
                                        <!-- Search by Name, NIC or Contact Number -->
                                        <div class="col-12 mb-2">
                                            <span style="color: #007bff">Search by Name, NIC or Contact Number</span>
                                            <form action="SearchStudentDetailsTxtServlet" id="form3">
                                            <input type="text" name="txt" id="srh3" placeholder="Search" id="txt" style="width:100%">
                                            </form>
                                        </div>

                                        <!-- Search by Status (Filter) -->
                                        <span style="color: #007bff">Search by Status</span>
                                        <div class="col-12 mb-2">
                                            <select id="searchStatus" style="width:100%">
                                                <option value="All" selected>All</option>
                                                <option value="Current">Current</option>
                                                <option value="Past">Past</option>
                                            </select>
                                        </div>
                                        <form id="form2" action="/SearchStudentDetailsStatusServlet">
                                            <input type="hidden" id="srh2" name="status">
                                        </form>
                                    </div>
                                </div>

                                <div class="card bg-grey">
                                    <div class="card-body text-center">
                                        <div class="col-12 mb-2">
                                            <!-- Search by Batch (Filter) -->
                                            <span style="color: #007bff">Search by Batch</span>
                                            <select id="searchbatch" style="width:100%" >
                                                <option value="All">All</option>
                                                <option value="2021">2021 A/L</option>
                                                <option value="2022">2022 A/L</option>
                                                <option value="2023">2023 A/L</option>
                                            </select>
                                        </div>
                                        <form id="form1" action="/SearchStudentDetailsDServlet">
                                            <input type="hidden" id="srh1" name="batch">
                                        </form>

                                        <br>

                                        <!-- Buttons -->
                                        <div class="bottombtn" align="right">
                                            <!-- Add Button -->
                                            <a href="add_student.jsp" class="btn" style="margin-bottom: 10px; background-color:transparent"><i class="fas fa-user-plus" style="color: grey"></i></a>
                                            <!-- Generate PDF Button -->
                                            <a  href="<%=request.getContextPath()%>/GenerateStudentListServlet" class="btn" style="margin-bottom: 10px; background-color:transparent"><i class="fas fa-file-pdf" style="color: grey"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="card-body">
                                <div class="table-responsive">
                                    <!-- Student List Table -->
                                    <table class="table table-hover">
                                        <!-- Create an Object and ArrayList -->
                                        <% StudentService service = new StudentService();
                                            ArrayList<Student> list=  service.ViewStudent();

                                            //Search Loop
                                            if(request.getAttribute("bt") !=null)
                                            {
                                                list = (ArrayList<Student>)request.getAttribute("bt");
                                            } else if (request.getAttribute("status") !=null)
                                            {
                                                list = (ArrayList<Student>)request.getAttribute("status");
                                            } else if (request.getAttribute("txt") !=null)
                                            {
                                                list = (ArrayList<Student>)request.getAttribute("txt");
                                            }
                                            else
                                            {
                                                list=  service.ViewStudent();
                                            }
                                        %>

                                        <thead>
                                        <tr>
                                            <th scope="col">Student ID</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Batch</th>
                                            <th scope="col">Subject/s</th>
                                            <th scope="col">Status</th>
                                            <th scope="col">Profile</th>
                                            <th scope="col">Edit</th>
                                            <th scope="col">Delete</th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                        <%for(Student i:list){ %>
                                        <tr>
                                            <td id="id"><%= i.getId() %></td>
                                            <td id="name"><%= i.getFullName() %></td>
                                            <td id="batch"><%= i.getBatch() %></td>
                                            <td id="subject"><%= i.getList() %></td>
                                            <td id="status"><%= i.getStatus() %></td>
                                            <td id="actions">
                                                <!-- User Profile Button -->
                                                <a href="<%=request.getContextPath()%>/UserProfileServlet?id=<%=i.getId()%>" class="btn" style="background-color:transparent"><i class="fas fa-eye" style="color:darkblue"></i></a>
                                            </td>
                                            <td id="edit">
                                                <!-- Edit (Update) Button -->
                                                <a href="<%=request.getContextPath()%>/RetrieveStudent?id=<%=i.getId()%>" class="btn" style="background-color:transparent"><i class="fas fa-edit" style="color:limegreen"></i></a href="<%=request.getContextPath()%>/RetrieveStudent?id=<%=i.getId()%>">
                                            </td>
                                            <td id="delete">
                                                <!-- Delete Button -->
                                                <a href="<%=request.getContextPath()%>/DeleteStudentServlet?getId=<%=i.getId()%>&getFirstName=<%=i.getFirstName()%>&getLastName=<%=i.getLastName()%>" class="btn" style="background-color:transparent"><i class="fas fa-trash-alt"  style="color:Red"></i></a>
                                            </td>
                                        </tr>
                                        <%} %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- end basic table  -->
                    <!-- ============================================================== -->
                </div>
                <!-- End Student List -->
            </div>
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <%@include file="footer.jsp" %>
            <!-- ============================================================== -->
            <!-- end footer -->
            <!-- ============================================================== -->
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- end wrapper  -->
    <!-- ============================================================== -->
</div>
<!-- ============================================================== -->
<!-- end main wrapper  -->
<!-- ============================================================== -->
<!-- Optional JavaScript -->
<!-- jquery 3.3.1 -->
<script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
<script src="js/custom/students/search.js"></script>
<!-- bootstap bundle js -->
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
<!-- slimscroll js -->
<script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
<!-- main js -->
<script src="assets/libs/js/main-js.js"></script>
<!-- chart chartist js -->
<script src="assets/vendor/charts/chartist-bundle/chartist.min.js"></script>
<!-- sparkline js -->
<script src="assets/vendor/charts/sparkline/jquery.sparkline.js"></script>
<!-- morris js -->
<script src="assets/vendor/charts/morris-bundle/raphael.min.js"></script>
<script src="assets/vendor/charts/morris-bundle/morris.js"></script>
</body>
</html>