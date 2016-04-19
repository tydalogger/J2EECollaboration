

<h1>Blog</h1>
<div class="col-lg-12">
	<div class="alert alert-info" role="alert">{{add_blog_result}}</div>

	<div class="form-group">
		<label for="title">Title</label> <input type="text"
			class="form-control" id="title" ng-model="title" placeholder="Title">

	</div>
	<div class="form-group">
		<label for="content">Description</label>
		<textarea class="form-control" ng-model="content" id="content"
			rows="15"></textarea>
	</div>

	<button type="submit" ng-click="add_blog_fun(title,content)"
		class="btn btn-default">Submit</button>


</div>
