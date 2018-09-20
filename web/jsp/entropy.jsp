<%--
  Created by IntelliJ IDEA.
  User: arhor
  Date: 20.9.18
  Time: 17.35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        Theory of Information
    </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="assets/css/material-dashboard.css?v=2.1.0" rel="stylesheet" />
</head>

<body class="">
<div class="wrapper ">
    <div class="sidebar" data-color="green" data-background-color="white">
        <!--
          Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

          Tip 2: you can also add an image using data-image tag
      -->
        <div class="logo">
            <a href="/controller?command=home" class="simple-text logo-normal">
                HOME
            </a>
        </div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li class="nav-item active  ">
                    <a class="nav-link" href="/controller?command=entropy">
                        <p>Entropy</p>
                    </a>
                </li>
                <li class="nav-item active  ">
                    <a class="nav-link" href="/controller?command=approximation">
                        <p>Approximation</p>
                    </a>
                </li>
                <!-- your sidebar here -->
            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
            <div class="container-fluid">
                <div class="navbar-wrapper">
                    <%--<a class="navbar-brand" href="#pablo">Dashboard</a>--%>
                </div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="navbar-toggler-icon icon-bar"></span>
                    <span class="navbar-toggler-icon icon-bar"></span>
                    <span class="navbar-toggler-icon icon-bar"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#pablo">
                                <i class="material-icons">notifications</i> Notifications
                            </a>
                        </li>
                        <!-- your navbar here -->
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-8 mr-auto ml-auto">
                        <div class="card">
                            <div class="card-header card-header-success">
                                <h3 class="card-title">Information source entropy</h3>
                            </div>
                            <div class="card-body">
                                <form action="/controller" method="POST">
                                    <div class="form-row">
                                        <div class="col">
                                            <input type="text" class="form-control text-center" id="prob-1" name="prob" pattern="(1\.0)|(0\.[0-9]{1,2})" />
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control text-center" id="prob-2" name="prob" pattern="(1\.0)|(0\.[0-9]{1,2})" />
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control text-center" id="prob-3" name="prob" pattern="(1\.0)|(0\.[0-9]{1,2})" />
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control text-center" id="prob-4" name="prob" pattern="(1\.0)|(0\.[0-9]{1,2})" />
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control text-center" id="prob-5" name="prob" pattern="(1\.0)|(0\.[0-9]{1,2})" />
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control text-center" id="prob-6" name="prob" pattern="(1\.0)|(0\.[0-9]{1,2})" />
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control text-center" id="prob-7" name="prob" pattern="(1\.0)|(0\.[0-9]{1,2})" />
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control text-center" id="prob-8" name="prob" pattern="(1\.0)|(0\.[0-9]{1,2})" />
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control text-center" id="prob-9" name="prob" pattern="(1\.0)|(0\.[0-9]{1,2})" />
                                        </div>
                                        <div class="col">
                                            <input type="text" class="form-control text-center" id="prob-10" name="prob" pattern="(1\.0)|(0\.[0-9]{1,2})" />
                                        </div>
                                    </div>
                                    <div class="form-row text-center">
                                        <div class="col">
                                            <label for="prob-1">1</label>
                                        </div>
                                        <div class="col">
                                            <label for="prob-2">2</label>
                                        </div>
                                        <div class="col">
                                            <label for="prob-3">3</label>
                                        </div>
                                        <div class="col">
                                            <label for="prob-4">4</label>
                                        </div>
                                        <div class="col">
                                            <label for="prob-5">5</label>
                                        </div>
                                        <div class="col">
                                            <label for="prob-6">6</label>
                                        </div>
                                        <div class="col">
                                            <label for="prob-7">7</label>
                                        </div>
                                        <div class="col">
                                            <label for="prob-8">8</label>
                                        </div>
                                        <div class="col">
                                            <label for="prob-9">9</label>
                                        </div>
                                        <div class="col">
                                            <label for="prob-10">10</label>
                                        </div>
                                    </div>
                                    ${wrongInput}
                                    <div class="row">
                                        <button type="submit" class="btn btn-success col-5 ml-auto mr-auto" name="command" value="setprob">Set probability distribution</button>
                                    </div>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container-fluid">
                <nav class="float-left">
                    <ul>
                        <li>
                            <%--<a href="https://www.creative-tim.com">--%>
                            <%--Creative Tim--%>
                            <%--</a>--%>
                        </li>
                    </ul>
                </nav>
                <%--<div class="copyright float-right">--%>
                <%--&copy;--%>
                <%--<script>--%>
                <%--document.write(new Date().getFullYear())--%>
                <%--</script>, made with <i class="material-icons">favorite</i> by--%>
                <%--<a href="https://www.creative-tim.com" target="_blank">Creative Tim</a> for a better web.--%>
                <%--</div>--%>
                <!-- your footer here -->
            </div>
        </footer>
    </div>
</div>
<!--   Core JS Files   -->
<script src="assets/js/core/jquery.min.js" type="text/javascript"></script>
<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
<script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
<script src="assets/js/material-dashboard.min.js?v=2.1.0" type="text/javascript"></script>
</body>

</html>
