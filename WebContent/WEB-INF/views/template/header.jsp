<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html ng-app="app">

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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.3/angular-route.js"></script>
<!-- jQuery -->
<script src="resources/js/jquery-1.11.1.js"></script>
<script>
	localStorage.setItem("data", "${data}");
</script>
<script type="application/javascript"
	src="resources/js/ang_deshboard.js"></script>

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
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Brand</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<div class="col-sm-3 col-md-3" style="margin-left: 30%">
					<form class="navbar-form" role="search">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search Friend" name="friend_name"
								ng-model="friend_name">
							<div class="input-group-btn">
								<button class="btn btn-default" type="button"
									ng-click="friendSearch()">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div>
						</div>
					</form>
				</div>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">
							<div class="glyphicon glyphicon-home"></div>
					</a></li>
					<li><a href="#" data-toggle="modal"
						data-target="#friendrequestModel">
							<div class="glyphicon glyphicon-user">
								<span class="badge">{{frinedrequests.length}}</span>
							</div>
					</a></li>
					<li><a href="#">
							<div class="glyphicon glyphicon-envelope">
								<span class="badge">2</span>
							</div>
					</a></li>
					<li><a href="#" data-toggle="modal"
						data-target="#notificationModel">
							<div class="glyphicon glyphicon-globe">
								<span class="badge">2</span>
							</div>
					</a></li>
					<li class="dropdown"><a href="#"
						class="dropdown-toggle glyphicon glyphicon-cog"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"></a>
						<ul class="dropdown-menu">
							<li><a href="#">Profile</a></li>
							<li><a href="#">Setting</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="lout">Logout</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">

				<li><b>Name:</b> {{name}}</li>
				<li><b>Username:</b> {{userId}}</li>
				<li><b>Email Id:</b> {{email}}</li>
				<li><a href="" ng-click="getBlog()">Blog</a></li>
				<li><a href="" ng-click="getForum()">forum</a></li>
				<li><a href="" ng-click="getFriends()">Friends</a></li>
				<li><a href="#">Services</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->