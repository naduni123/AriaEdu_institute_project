<%--
  Created by IntelliJ IDEA.
  User: Hansaka Dilshan
  Date: 8/16/2021
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/libs/css/style.css">
    <link rel="stylesheet" href="assets/libs/css/hansakacss.css">
    <link rel="stylesheet" href="assets/libs/css/kavindulocal.css">
    <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="assets/vendor/charts/chartist-bundle/chartist.css">
    <link rel="stylesheet" href="assets/vendor/charts/morris-bundle/morris.css">
    <link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">
    <link rel="stylesheet" href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css">

    <!-- DisabledCheck Bio and Maths -->
    <script>
        function DisabledCheck() {
            document.getElementById("subjectTwo").disabled = true;
        }

        function DisabledCheckTwo() {
            document.getElementById("subjectOne").disabled = true;
        }
    </script>

    <title>AriaEdu | Add Student</title>
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
                            <h2 class="pageheader-title">Add Student</h2>
                            <div class="page-breadcrumb">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="indexhome.jsp" class="breadcrumb-link">Dashboard</a></li>
                                        <li class="breadcrumb-item"><a href="student_management_dashboard.jsp" class="breadcrumb-link">Student Management</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Add Student</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- end pageheader  -->
                <!-- ============================================================== -->

                <!-- ========================================Add Student Form-------------->
                <div class="card">
                    <h2 class="card-header">Add Student</h2>
                    <div class="card-body">
                        <form class="form" name="form" action="<%=request.getContextPath()%>/AddStudentServlet" method="post" onsubmit="return studentValidation()">
                            <h5 style="color:red" class="error" id="eEmpty"></h5>
                            <div class="row g-3">
                                <!-- First Name -->
                                <div class="divCol">
                                    <label class="col-form-label">First Name *</label>
                                    <input type="text" name="firstName" id="firstName" class="form-control" placeholder="First Name">
                                    <h5 style="color:red" class="error" id="eFirstName"></h5>
                                </div>

                                <!-- Last Name -->
                                <div class="divCol">
                                    <label class="col-form-label">Last Name *</label>
                                    <input type="text" name="lastName" id="lastName" class="form-control" placeholder="Last Name">
                                    <h5 style="color:red" class="error" id="eLastName"></h5>
                                </div>
                            </div>

                            <div class="row g-3">
                                <!-- Date Of Birth -->
                                <div class="divCol">
                                    <label class="col-form-label">Date Of Birth *</label>
                                    <input type="Date" name="dob" id="dob" class="form-control" max="2005-01-31" min="2002-02-01">
                                    <h5 style="color:red" class="error" id="eDob"></h5>
                                </div>

                                <!-- NIC Number -->
                                <div class="divCol">
                                    <label class="col-form-label">NIC *</label>
                                    <input type="text" name="nic" id="nic" class="form-control" placeholder="National Identity Card Number">
                                    <h5 style="color:red" class="error" id="eNic"></h5>
                                </div>
                            </div>

                            <div class="row g-3">
                                <!-- Address -->
                                <div class="divCol2">
                                    <label class="col-form-label">Address *</label>
                                    <input type="text" name="address" id="address" class="form-control" placeholder="Address">
                                    <h5 style="color:red" class="error" id="eAddress"></h5>
                                </div>
                            </div>

                            <div class="row g-3">
                                <!-- Gender -->
                                <div class="divCol3">
                                    <label class="col-form-label">Gender *</label><br>
                                    <label class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" name="gender" id="gender" value="Male" class="custom-control-input"><span class="custom-control-label">Male</span>
                                    </label>
                                    <label class="custom-control custom-radio custom-control-inline">
                                        <input type="radio" name="gender" id="gender" value="Female" class="custom-control-input"><span class="custom-control-label">Female</span>
                                    </label>
                                    <h5 style="color:red" class="error" id="eGender"></h5>
                                </div>

                                <!-- Phone Number -->
                                <div class="divCol3">
                                    <label class="col-form-label">Phone Number *</label>
                                    <input type="tel" name="phone" id="phone" class="form-control" placeholder="Phone Number">
                                    <h5 style="color:red" class="error" id="ePhone"></h5>
                                </div>

                                <!-- Email -->
                                <div class="divCol3">
                                    <label class="col-form-label">Email *</label>
                                    <input type="email" name="email" id="email" class="form-control" placeholder="Email">
                                    <h5 style="color:red" class="error" id="eEmail"></h5>
                                </div>
                            </div>

                            <div class="row g-3">
                                <!-- Admission Date -->
                                <div class="divCol">
                                    <label class="col-form-label">Admission Date *</label>
                                    <input type="Date" name="admissionDate" id="admissionDate" class="form-control">
                                    <h5 style="color:red" class="error" id="eAdmissionDate"></h5>
                                </div>

                                <!-- Batch -->
                                <div class="divCol">
                                    <div class="form-group">
                                        <label class="col-form-label" for="batch">Batch *</label>
                                        <select class="form-control" name="batch" id="batch">
                                            <option value="Select Batch" selected>Select Batch</option>
                                            <option value="2021">2021 A/L</option>
                                            <option value="2022">2022 A/L</option>
                                            <option value="2023">2023 A/L</option>
                                        </select>
                                        <h5 style="color:red" class="error" id="eBatch"></h5>
                                    </div>
                                </div>
                            </div>

                            <div class="row g-3">
                                <!-- Subject/s -->
                                <div class="divCol4">
                                    <label class="custom-control custom-checkbox custom-control-inline">
                                        <input name="subject" id="subjectOne" value="Biology" type="checkbox" class="custom-control-input" onclick="DisabledCheck()"><span class="custom-control-label">Biology</span>
                                    </label>
                                    <label class="custom-control custom-checkbox custom-control-inline">
                                        <input name="subject" id="subjectTwo" value="Maths" type="checkbox" class="custom-control-input" onclick="DisabledCheckTwo()"><span class="custom-control-label">Maths</span>
                                    </label>
                                    <label class="custom-control custom-checkbox custom-control-inline">
                                        <input name="subject" id="subjectThree" value="Chemistry" type="checkbox" class="custom-control-input"><span class="custom-control-label">Chemistry</span>
                                    </label>
                                    <label class="custom-control custom-checkbox custom-control-inline">
                                        <input name="subject" id="subjectFour" value="Physics" type="checkbox" class="custom-control-input"><span class="custom-control-label">Physics</span>
                                    </label>
                                    <h5 style="color:red" class="error" id="eSubject"></h5>
                                </div>
                            </div>

                            <div class="btndiv">
                                <!-- Reset Button -->
                                <input type="button" class="btn btn-rounded btn-danger" value="Reset" onclick="clearFields()">
                                <!-- Add Button-->
                                <button type="submit" class="btn btn-rounded btn-primary">Add</button>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- End Add Student Form -->
                <!-- ============================================================== -->
                <!-- footer -->
                <!-- ============================================================== -->
                <%@include file="footer.jsp" %>
                <!-- ============================================================== -->
                <!-- end footer -->
                <!-- ============================================================== -->
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
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
        <!-- chart c3 js -->
        <script src="assets/vendor/charts/c3charts/c3.min.js"></script>
        <script src="assets/vendor/charts/c3charts/d3-5.4.0.min.js"></script>
        <script src="assets/vendor/charts/c3charts/C3chartjs.js"></script>
        <script src="assets/libs/js/dashboard-ecommerce.js"></script>
        <!--import Add Student Details function js and validations js -->
        <script src="js/custom/students/studentFormValidation.js"></script>
        <!-- Future Date Disable Validation js -->
        <script>
            //Declare Variables and Assign Values
            var todayDate = new Date();
            var month = todayDate.getMonth() + 1;
            var year = todayDate.getFullYear();
            var tdate = todayDate.getDate();

            //One Digit Month Convert into Two Digit
            if (month < 10) {
                month = "0" + month;
            }

            //One Digit Date Convert into Two Digit
            if (tdate < 10) {
                tdate = "0" + tdate;
            }

            //Create a Date Pattern
            var maxDate = year + "-" + month + "-" + tdate;
            document.getElementById("admissionDate").setAttribute("max", maxDate);
        </script>
</body>
</html>