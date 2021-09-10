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
    <title>View Teacher Details</title>
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
            <a class="navbar-brand" href="index.jsp">AriaEdu</a>
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

    //modal

    <div class="modal fade" id="ModalAdd">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header bg-primary">
                    <h4 class="modal-title">Update Teacher Details</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="color: white">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="card-body">
                            <div class="form-group">                        //change this
                                <input type="hidden" class="form-control" id="id_customer" name="id_customer" hidden>
                            </div>

                            <div class="form-group">
                                <label for="first_name">First Name</label>
                                <input type="text" class="form-control" id="first_name"
                                       placeholder="Enter First Name">
                            </div>

                            <div class="form-group">
                                <label for="last_name">Last Name</label>
                                <input type="text" class="form-control" id="last_name"
                                       placeholder="Enter Last Name">
                            </div>

                            <div class="form-group">
                                <label for="full_name">Full Name</label>
                                <input type="text" class="form-control" id="full_name"
                                       placeholder="Enter Full Name">
                            </div>

                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" id="address"
                                       placeholder="Enter Address">
                            </div>

                            <div class="form-group">
                                <label for="email-mask">Email</label>
                                <input type="text" class="form-control email-inputmask" id="email-mask">
                            </div>

                            <div class="form-group">
                                <label for="email-mask">Subject</label>
                                <input type="text" class="form-control" id="subject" disabled>
                            </div>
                        </div>
                        <!-- /.card-body -->
                        <div class="modal-footer justify-content-end">
                            <div class="">
                                <button class="btn btn-primary" onclick="update_teacher(event)" id="submitBtn" type="submit">Update Teacher Details</button>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>






    <div class="dashboard-wrapper">
        <div class="dashboard-ecommerce">
            <div class="container-fluid dashboard-content ">
                <!-- ============================================================== -->
                <!-- pageheader  -->
                <!-- ============================================================== -->
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="page-header">
                            <h2 class="pageheader-title">View Teacher Details</h2>
                            <div class="page-breadcrumb">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Dashboard</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">View Teacher Details</li>
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
                    <div class="card">
                        <h5 class="card-header">All Details</h5>

                        <div class="card-deck">
                            <div class="card bg-grey">
                                <div class="card-body text-center">

                                    <div class="col-12 mb-2">
                                        <span style="color: green">Search by Name, NIC or Contact Number</span>
                                        <input type="text" placeholder="Search" id="txt" onkeyup="getTeachers()"  style="width:100%">
                                        //search bar

                                    </div>
                                    //search by status
                                    <span style="color: green">Search by Status</span>
                                    <div class="col-12 mb-2">
                                        <select id="status" style="width:100%" onchange="getTeachers()">
                                          <option value="all" selected>All</option>
                                          <option value="1">Current</option>
                                          <option value="0">Past</option>
                                        </select>
								    </div>
                                </div>
                            </div>
                            <div class="card bg-grey">
                                <div class="card-body text-center">
                                    <div class="col-12 mb-2">
                                        //search by subject
                                        <span style="color: green">Search by Subject</span>
                                        <select id="sub" style="width:100%" onchange="getTeachers()">
                                            <option value="all" selected>All</option>
                                            <option value="Biological Sciences">Biological Sciences</option>
                                            <option value="Combined Mathematics">Combined Mathematics</option>
                                            <option value="Chemistry">Chemistry</option>
                                            <option value="Physics">Physics</option>
                                        </select>
                                    </div>

                                    <br>
                                    <button class="btn btn-warning"  onclick="createPDF()">Report</button>
                                </div>
                            </div>

                        </div>


                        <div class="card-body">
                            <table class="table table-hover" id="tblViewTeachers">
                                <thead>
                                <tr>
                                    <th scope="col">Full Name</th>
                                    <th scope="col">Gender</th>
                                    <th scope="col">Contact Number</th>
                                    <th scope="col">NIC</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Options</th>
                                    <th scope="col">Update</th>
                                    <th scope="col">Delete</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
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


<script src="../../js/custom/teachers/manageTeachers.js"></script>
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
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
<script>
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
                pdfMake.createPdf(docDefinition).download("Teacher_list.pdf");
            }
        });
    }


</script>
</body>

</html>