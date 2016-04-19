<div id="page-content-wrapper">
	<div class="container-fluid">
		<div class="row">
			<table class="table">
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>UserId</th>
					<th>Profile</th>
				</tr>
				<tr ng-repeat="x in all_friends">
					<td>{{ x.name }}</td>
					<td>{{ x.email }}</td>
					<td>{{ x.userId }}</td>
					<td><button type="button" class="btn btn-primary">View
							Profile</button></td>
				</tr>

			</table>


		</div>
	</div>
</div>
