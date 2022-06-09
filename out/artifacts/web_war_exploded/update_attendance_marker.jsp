<%--
  Created by IntelliJ IDEA.
  User: Hansaka Dilshan
  Date: 8/26/2021
  Time: 8:47 PM
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
    <link rel="stylesheet" href="assets/libs/css/naduni.css">
    <link rel="stylesheet" href="assets/libs/css/kavindulocal.css">
    <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="assets/vendor/charts/chartist-bundle/chartist.css">
    <link rel="stylesheet" href="assets/vendor/charts/morris-bundle/morris.css">
    <link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">
    <link rel="stylesheet" href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css">

    <!-- Add Student Form Validation -->
    <script>
        //validate function
        function validate() {
            var firstName = document.forms["form"]["firstName"].value;
            var lastName = document.forms["form"]["lastName"].value;
            var dob = document.forms["form"]["dob"].value;
            var nic = document.forms["form"]["nic"].value;
            var address = document.forms["form"]["address"].value;
            var gender = document.forms["form"]["gender"].value;
            var phone = document.forms["form"]["phone"].value;
            var email = document.forms["form"]["email"].value;
            var admissionDate = document.forms["form"]["admissionDate"].value;
            var batch = document.forms["form"]["batch"].value;
            if (isAlphebatic(firstName)) {
                if (isAlphebatic(lastName)) {
                    if (isNumeric(phone)) {
                        if (emailValidation(email)) {
                            return true;
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        <!-- Empty Validation -->
        function isEmpty(elemValue, field) {
            if (elemValue == " " || elemValue == null) {
                alert("You cannot have " + field + "field empty");
                return true;
            } else {
                return false;
            }
        }
        <!-- First Name Validation -->
        function isAlphebatic(elemValue) {
            var exp = /^[a-zA-Z]+$/;
            if (!isEmpty(elemValue, "firstName")) {
                if (elemValue.match(exp)) {
                    return true;
                } else {
                    alert("Enter only text for you first name");
                    return false;
                }
            } else {
                return false;
            }
        }
        <!-- Last Name Validation -->
        function isAlphebatic(elemValue) {
            var exp = /^[a-zA-Z]+$/;
            if (!isEmpty(elemValue, "lastName")) {
                if (elemValue.match(exp)) {
                    return true;
                } else {
                    alert("Enter only text for you last name");
                    return false;
                }
            } else {
                return false;
            }
        }
        <!-- Email Validation -->
        function emailValidation(elemValue) {
            if (!isEmpty(elemValue, "email")) {
                var atops = elemValue.indexOf("@");
                var dotops = elemValue.indexOf(".");
                if (atops < 1 || dotops+2 >= elemValue.length || atops+2 > dotops) {
                    alert("Enter a valid email");
                    return false;
                } else{
                    return true;
                }
            } else {
                return false;
            }
        }
        <!-- Phone Number Validation -->
        function isNumeric(elemValue) {
            if (!isEmpty(elemValue, "phone")) {
                var exp=/^[0-9]+$/;
                if (elemValue.match(exp)) {
                    return true;
                } else {
                    alert("Enter a valid phone number");
                    return false;
                }
            } else {
                return false;
            }
        }
        function clearFields() {
            document.getElementById("firstName").value="";
            document.getElementById("lastName").value="";
            document.getElementById("dob").value="";
            document.getElementById("nic").value="";
            document.getElementById("address").value="";
            document.getElementById("phone").value="";
            document.getElementById("email").value="";
            document.getElementById("admissionDate").value="";
        }
        function DisabledCheck() {
            document.getElementById("subjectTwo").disabled = true;
        }
        function DisabledCheckTwo() {
            document.getElementById("subjectOne").disabled = true;
        }
    </script>

    <title>AriaEdu | Update Student</title>
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
    <div class="nav-left-sidebar sidebar-dark">
        <div class="menu-list">
            <nav class="navbar navbar-expand-lg navbar-light">
                <a class="d-xl-none d-lg-none" href="#">Student Management</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav flex-column">
                        <li class="nav-divider">
                            Menu
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-2" aria-controls="submenu-2"><i class="fa fa-fw fa-user"></i>Student Management</a>
                            <div id="submenu-2" class="collapse submenu" style="">
                                <ul class="nav flex-column">
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/cards.html">page 1</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/general.html">page 2</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/carousel.html">page 3</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/listgroup.html">page 4</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-3" aria-controls="submenu-3"><i class="fas fa-fw fa-users"></i>Teacher Management</a>
                            <div id="submenu-3" class="collapse submenu" style="">
                                <ul class="nav flex-column">
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/cards.html">page 1</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/general.html">page 2</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/carousel.html">page 3</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/listgroup.html">page 4</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-4" aria-controls="submenu-4"><i class="fab fa-fw fa-wpforms"></i>Attendance Management</a>
                            <div id="submenu-4" class="collapse submenu" style="">
                                <ul class="nav flex-column">
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/cards.html">page 1</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/general.html">page 2</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/carousel.html">page 3</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/listgroup.html">page 4</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-5" aria-controls="submenu-5"><i class="fas fa-fw fa-table"></i>Time Tables</a>
                            <div id="submenu-5" class="collapse submenu" style="">
                                <ul class="nav flex-column">
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/cards.html">page 1</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/general.html">page 2</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/carousel.html">page 3</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/listgroup.html">page 4</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-6" aria-controls="submenu-6"><i class="fas fa-hospital-alt"></i>Class Room</a>
                            <div id="submenu-6" class="collapse submenu" style="">
                                <ul class="nav flex-column">
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/cards.html">page 1</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/general.html">page 2</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/carousel.html">page 3</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/listgroup.html">page 4</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
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
                            <h2 class="pageheader-title">Update Student</h2>
                            <div class="page-breadcrumb">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Dashboard</a></li>
                                        <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Attendance Management</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Update Attendance Marker</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- end pageheader  -->
                <!-- ============================================================== -->

                <!-- ========================================your contents start here-------------->
                <!-- Add Student Form -->
                <div class="card">
                    <h2 class="card-header">Update Attendance Marker Details</h2>
                    <div class="card-body">
                        <form class="form" name="form" action="<%=request.getContextPath()%>/UpdateMarkerServlet" method="post" onsubmit="return validate()">

                            <div class="row g-3">
                                <!-- first name -->
                                <div class="divCol">
                                    <input type="hidden" value="<%=request.getAttribute("id")%>" id="id" name="id">
                                    <label class="col-form-label">First Name*</label>
                                    <input type="text" name="fname" id="fname" class="form-control"  value="<%=request.getAttribute("fname")%>" placeholder="First Name" required>
                                </div>

                                <!-- last name-->
                                <div class="divCol">
                                    <label class="col-form-label">Last Name *</label>
                                    <input type="text" name="lname"  value="<%=request.getAttribute("lname")%>" id="lname" class="form-control" placeholder="Last Name" required>
                                </div>
                            </div>
                            <div class="row g-3">
                                <!-- Address -->
                                <div class="divCol2">
                                    <label class="col-form-label">Address *</label>
                                    <input type="text" name="address" value="<%=request.getAttribute("address")%>"id="address" class="form-control" placeholder="Address" required>
                                </div>
                            </div>

                            <div class="row g-3">
                                <!-- Phone Number -->
                                <div class="divCol">
                                    <label class="col-form-label">Phone Number *</label>
                                    <input type="tel" name="phone" value="<%=request.getAttribute("phone")%>"id="phone" class="form-control" placeholder="Phone Number" required>
                                </div>

                                <!-- Email -->
                                <div class="divCol">
                                    <label class="col-form-label">Email *</label>
                                    <input type="email" name="email" value="<%=request.getAttribute("email")%>" id="email" class="form-control" placeholder="Email" required>
                                </div>
                            </div>
                            <div class="row g-3">
                                <div class="divCol4">
                                    <div class="form-group">
                                        <label class="col-form-label" for="teacher">Status *</label>
                                        <select class="form-control" name="teacher" id="teacher" required>
                                            <option value="<%=request.getAttribute("teacher")%>"><%=request.getAttribute("teacher")%></option>
                                            <option value="ajith" selected>Ajith Pushpakumara</option>
                                            <option value="nilantha">Nilantha Jayasooriya</option>
                                            <option value="duminda">Duminda Rathnayaka</option>
                                            <option value="janaka">Janaka Abewardhana</option>
                                            <option value="hemal">Hemal Jayasingha</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="btndiv" align="right">
                                <!-- Update Button-->
                                <button type="submit" class="btn btn-rounded btn-primary">Update</button>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- End Add Student Form -->

                <!-- ============================================================== -->
                <!-- footer -->
                <!-- ============================================================== -->
                <div class="footer">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
                                Copyright © 2021 Concept. All rights reserved. Dashboard by <a href="https://colorlib.com/wp/">AriaEdu</a>.
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
                                <div class="text-md-right footer-links d-none d-sm-block">
                                    <a href="javascript: void(0);">About</a>
                                    <a href="javascript: void(0);">Support</a>
                                    <a href="javascript: void(0);">Contact Us</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
</body>
</html>