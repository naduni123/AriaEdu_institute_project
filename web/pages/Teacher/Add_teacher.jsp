<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../../assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="../../assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../../assets/libs/css/style.css">
    <link rel="stylesheet" href="../../assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="../../assets/vendor/charts/chartist-bundle/chartist.css">
    <link rel="stylesheet" href="../../assets/vendor/charts/morris-bundle/morris.css">
    <link rel="stylesheet" href="../../assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../../assets/vendor/charts/c3charts/c3.css">
    <link rel="stylesheet" href="../../assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
    <title>Add Teachers</title>
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
            <a class="navbar-brand" href="../../TeacherDashboard.jsp"><img src="../../assets/images/logo.png"></a>
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

                                </div>
                            </li>
                            <li>
                                <div class="list-footer"> <a href="#">View all notifications</a></div>
                            </li>
                        </ul>
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
    <%@include file="../common/header.jsp" %>
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
                            <h2 class="pageheader-title">Add Teacher Details</h2>
                            <div class="page-breadcrumb">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Dashboard</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Teacher Details</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- end pageheader  -->
                <!-- ============================================================== -->
                <div class="ecommerce-widget">

                    <div class="row">
                        <!-- ============================================================== -->
                        <!-- validation form -->
                        <!-- ============================================================== -->
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="card">
                                <h5 class="card-header" style="color: red">Teacher Details</h5>
                                <div class="card-body">
                                    <form class="needs-validation" id="addTeacherForm" novalidate>
                                        <div class="card">
                                            <h5 class="card-header">Personal Details</h5>
                                            <div class="card-body">
                                                <%--                                                form starts here--%>
                                                <div class="form-group">
                                                    <label for="full_name">First Name</label>
                                                    <input type="text" class="form-control" id="f_name" placeholder="Enter First name" required>
                                                    <div class="valid-feedback">
                                                        Looks good!
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="full_name">Last Name</label>
                                                    <input type="text" class="form-control" id="l_name" placeholder="Enter Last name" required>
                                                    <div class="valid-feedback">
                                                        Looks good!
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="full_name">Full Name</label>
                                                    <input type="text" class="form-control" id="full_name" placeholder="Enter Full name"  required>
                                                    <div class="valid-feedback">
                                                        Looks good!
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="full_name">Gender</label><br>
                                                    <label class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" name="radio-inline" id="male" checked="" class="custom-control-input"><span class="custom-control-label">Male</span>
                                                    </label>
                                                    <label class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" name="radio-inline" id="female" class="custom-control-input"><span class="custom-control-label">Female</span>
                                                    </label>
                                                </div>
                                                <div class="form-group">
                                                    <label for="full_name">NIC</label>
                                                    <input type="text" class="form-control" id="nic" placeholder="Enter NIC"  required>
                                                    <div class="valid-feedback">
                                                        Looks good!
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="full_name">Address</label>
                                                    <input type="text" class="form-control" id="address" placeholder="Enter Address"  required>
                                                    <div class="valid-feedback">
                                                        Looks good!
                                                    </div>
                                                </div>
                                            </div>

                                        </div>


                                        <div class="card">
                                            <h5 class="card-header">Contact Details</h5>
                                            <div class="card-body">
                                                <div class="card-body border-top">
                                                    <div class="form-group">
                                                        <label>Phone <small class="text-muted">(999) 999-9999</small></label>
                                                        <input type="text" class="form-control phone-inputmask" id="phone-mask" placeholder="">
                                                    </div>
                                                </div>
                                                <div class="card-body border-top">
                                                    <div class="form-group">
                                                        <label>Email<small class="text-muted">xxx@xxx.xxx</small>
                                                        </label>
                                                        <input type="text" class="form-control email-inputmask" id="email-mask" placeholder="">
                                                    </div>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="card">
                                            <h5 class="card-header">Qualifications</h5>
                                            <div class="card-body">
                                                <div class="card-body">
                                                    <div class="form-group">
                                                        <label for="input-select">Education Qualifications</label>
                                                        <select class="form-control" id="input-select">
                                                            <option>Advanced Level</option>
                                                            <option>Diploma</option>
                                                            <option>BSc Degree</option>
                                                            <option>MSc Degree</option>
                                                            <option>Phd Degree</option>
                                                        </select>
                                                    </div>

                                                    <input type="button" onclick="addToQualificationTable(event)" class="btn btn-danger btn-user btn-block" id="addQualification" value="Add Qualification">
                                                    <br><br>
                                                    <!--add qualifications table-->
                                                    <table id="tblQualifications" class="table table-bordered table-striped">
                                                        <thead>
                                                        <tr>
                                                            <th>Education Qualifications</th>
                                                            <th>Close</th>
                                                        </tr>
                                                        </thead>

                                                        <tbody>

                                                        </tbody>
                                                    </table>
                                                    <br><br>
                                                    <div class="form-group">
                                                        <label for="input-select">Assign Subject</label>
                                                        <select class="form-control" id="subject">
                                                            <option>Biological Sciences</option>
                                                            <option>Combined Mathematics</option>
                                                            <option>Chemistry</option>
                                                            <option>Physics</option>
                                                        </select>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                                <button class="btn btn-primary" onclick="validateSubmit(event)" id="submitBtn" type="submit">Save Teacher Details</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- ============================================================== -->
                        <!-- end validation form -->
                        <!-- ============================================================== -->
                    </div>




                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- footer -->
        <!-- ============================================================== -->
        <%@include file="../common/footer.jsp" %>
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
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="../../assets/vendor/jquery/jquery.min.js"></script>
<!-- bootstap bundle js -->
<script src="../../assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
<!-- slimscroll js -->
<script src="../../assets/vendor/slimscroll/jquery.slimscroll.js"></script>

<script src="../../assets/vendor/charts/chartist-bundle/chartist.min.js"></script>
<!-- sparkline js -->
<script src="../../assets/vendor/charts/sparkline/jquery.sparkline.js"></script>
<!-- morris js -->
<script src="../../assets/vendor/charts/morris-bundle/raphael.min.js"></script>
<script src="../../assets/vendor/charts/morris-bundle/morris.js"></script>
<!-- chart c3 js -->
<script src="../../assets/vendor/charts/c3charts/c3.min.js"></script>
<script src="../../assets/vendor/charts/c3charts/d3-5.4.0.min.js"></script>
<script src="../../assets/vendor/charts/c3charts/C3chartjs.js"></script>

<script src="../../assets/vendor/inputmask/js/jquery.inputmask.bundle.js"></script>
<%--//import Teacher function js and validations js--%>
<script src="../../js/custom/teachers/addTeacher.js"></script>
<script src="../../js/custom/validation.js"></script>

<script>
    $(function(e) {
        "use strict";
        $(".date-inputmask").inputmask("dd/mm/yyyy"),
            $(".phone-inputmask").inputmask("(999) 999-9999"),
            $(".international-inputmask").inputmask("+9(999)999-9999"),
            $(".xphone-inputmask").inputmask("(999) 999-9999 / x999999"),
            $(".purchase-inputmask").inputmask("aaaa 9999-****"),
            $(".cc-inputmask").inputmask("9999 9999 9999 9999"),
            $(".ssn-inputmask").inputmask("999-99-9999"),
            $(".isbn-inputmask").inputmask("999-99-999-9999-9"),
            $(".currency-inputmask").inputmask("$9999"),
            $(".percentage-inputmask").inputmask("99%"),
            $(".decimal-inputmask").inputmask({
                alias: "decimal",
                radixPoint: "."
            }),

            $(".email-inputmask").inputmask({
                mask: "*{1,20}[.*{1,20}][.*{1,20}][.*{1,20}]@*{1,20}[*{2,6}][*{1,2}].*{1,}[.*{2,6}][.*{1,2}]",
                greedy: !1,
                onBeforePaste: function(n, a) {
                    return (e = e.toLowerCase()).replace("mailto:", "")
                },
                definitions: {
                    "*": {
                        validator: "[0-9A-Za-z!#$%&'*+/=?^_`{|}~/-]",
                        cardinality: 1,
                        casing: "lower"
                    }
                }
            })
    });
</script>
</body>

</html>