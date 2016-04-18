<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Login &amp; Register Templates</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="resources/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/form-elements.css">
<link rel="stylesheet" href="resources/css/style.css">

<script src="resources/js/and_index.js"></script>

</head>

<body>

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

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Home</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">


				<div class="row">
					<div class="col-sm-5">

						<div class="form-box">
							<div class="form-top">
								<div class="form-top-left">
									<h3>Login to our site</h3>
									<p>Enter username and password to log on:</p>
								</div>
								<div class="form-top-right">
									<i class="fa fa-key"></i>
								</div>
							</div>
							<div class="form-bottom">
								<div class="alert alert-danger" role="alert">${error}</div>
								<form:form action="login" method="post">
									<div class="form-group">
										<label class="sr-only" for="form-username">Username</label> <input
											type="text" name="userId" placeholder="Username..."
											class="form-username form-control" id="form-username">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-password">Password</label> <input
											type="password" name="password" placeholder="Password..."
											class="form-password form-control" id="form-password">
									</div>
									<button type="submit" class="btn">Sign in!</button>
								</form:form>
							</div>
						</div>

						<div class="social-login">
							<h3>...or login with:</h3>
							<div class="social-login-buttons">
								<a class="btn btn-link-1 btn-link-1-facebook" href="#"> <i
									class="fa fa-facebook"></i> Facebook
								</a> <a class="btn btn-link-1 btn-link-1-twitter" href="#"> <i
									class="fa fa-twitter"></i> Twitter
								</a> <a class="btn btn-link-1 btn-link-1-google-plus" href="#">
									<i class="fa fa-google-plus"></i> Google Plus
								</a>
							</div>
						</div>

					</div>

					<div class="col-sm-1 middle-border"></div>
					<div class="col-sm-1"></div>

					<div class="col-sm-5">

						<div class="form-box">
							<div class="form-top">
								<div class="form-top-left">
									<h3>Sign up now</h3>
									<p>Fill in the form below to get instant access:</p>
								</div>
								<div class="form-top-right">
									<i class="fa fa-pencil"></i>
								</div>
							</div>
							<div class="form-bottom">
								<form:form action="registation" method="post">
									<div>

										<div class="fileinput fileinput-new" data-provides="fileinput">
											<span class="btn btn-default btn-file"
												style="width: 100%; margin-bottom: 4%"><span>Choose
													Profile Pic</span><input type="file" name="profilepicUrl" /> </span> <span
												class="fileinput-filename"></span>
										</div>

									</div>
									<div class="form-group">
										<label class="sr-only" for="username">Username</label> <input
											type="text" name="userId" placeholder="Username"
											class="form-first-name form-control" id="username">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-name">Name</label> <input
											type="text" name="name" placeholder="Name"
											class="form-last-name form-control" id="form-name">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-email">Email</label> <input
											type="text" name="email" placeholder="Email"
											class="form-email form-control" id="form-email">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-pass">Password</label> <input
											type="password" name="password" placeholder="Password"
											class="form-email form-control" id="form-pass">
									</div>

									<button type="submit" class="btn">Sign me up!</button>
								</form:form>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>

	</div>

	<!-- Footer -->
	<footer> </footer>

	<!-- Javascript -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="resources/js/angular.js"></script>
	<scripts
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js">
	</script>
</body>

</html>