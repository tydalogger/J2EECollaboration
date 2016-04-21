
<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">

			<a href="" ng-click="Add_blog()"
				class="glyphicon glyphicon-plus btn btn-primary" role="button"></a>


			<div class="row">
				<table class="table">
				<tr>
				<th>BlogId</th>
					<th>Title</th>
					<th>Date</th>
					
					<th>Action</th>
				</tr>
				<tr ng-repeat="x in all_blog_post">
					<td>{{ x.blogId }}</td>
					<td>{{ x.title }}</td>
					<td>{{ x.date_time | date}}</td>
					<td><button type="button" ng-click="view_full_blog(x);" class="btn btn-primary">Read More..</button></td>
				</tr>

			</table>

				
			</div>
		</div>
	</div>
</div>
