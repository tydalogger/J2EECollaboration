<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html ng-app="app" >

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Simple Sidebar - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/simple-sidebar.css" rel="stylesheet">
    <script src="resources/js/angular.js"></script>
    <script type="application/javascript" src="resources/js/ang_deshboard.js"></script>
    <link href="resources/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body ng-controller="dash_controller">

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">
                    <div class="glyphicon glyphicon-home"></div>
                </a></li>
                <li><a href="#" data-toggle="modal" data-target="#friendrequestModel">
                    <div class="glyphicon glyphicon-user"><span class="badge">5</span></div>
                </a></li>
                <li><a href="#">
                    <div class="glyphicon glyphicon-envelope"><span class="badge">2</span></div>
                </a></li>
                <li><a href="#" data-toggle="modal" data-target="#notificationModel">
                    <div class="glyphicon glyphicon-globe"><span class="badge">2</span></div>
                </a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle glyphicon glyphicon-cog" data-toggle="dropdown" role="button"
                       aria-haspopup="true"
                       aria-expanded="false"></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Profile</a></li>
                        <li><a href="#">Setting</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div id="wrapper">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand" style="height: 20%">
                <img src="resources/img/Small-mario.png" style="width: 40%; margin: 5%">
            </li>
            <li>
                {{name}}
            </li>

            <li>
                <a href="blog">Blog</a>
            </li>
            <li>
                <a href="#">Events</a>
            </li>
            <li>
                <a href="#">About</a>
            </li>
            <li>
                <a href="#">Services</a>
            </li>
            <li>
                <a href="#">Contact</a>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <h1>Blog</h1>
                <div class="col-lg-12">
                    <form:form action="blog_add" method="post">
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" class="form-control" id="title" placeholder="Title">
                        	
                        </div>
                        <div class="form-group">
                            <label for="content">Description</label>
                            <textarea class="form-control" id="content" rows="15"></textarea>
                        </div>
                        <input type="hidden" id="createrId" value="${name}">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form:form>

                </div>
            </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Friend Request Modal -->
<div class="modal fade" id="friendrequestModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">

            </div>
        </div>
    </div>
</div>

<!-- Notification Modal -->
<div class="modal fade" id="notificationModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">

            <div class="modal-body">
                ...
            </div>

        </div>
    </div>
</div>

<!-- jQuery -->
<script src="resources/js/jquery-1.11.1.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/js/angular.js"></script>

<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>

</body>

</html>
