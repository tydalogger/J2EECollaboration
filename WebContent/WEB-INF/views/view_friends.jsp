

<div id="page-content-wrapper" ng-app="app"
	ng-controller="dash_controller">
	<div class="container-fluid">
		<div class="row">

			<div class="alert alert-info" role="alert">{{friend_resuest_result}}</div>

			<table class="table">
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>UserId</th>
					<th>Friend Request</th>
				</tr>
				<tr ng-repeat="x in names">
					<td>{{ x.name }}</td>
					<td>{{ x.email }}</td>
					<td>{{ x.userId }}</td>
					<td><button type="button" ng-click="sendFriendrequest(x);"
							class="btn btn-primary">Friend Request</button></td>
				</tr>

			</table>


		</div>
	</div>
</div>
