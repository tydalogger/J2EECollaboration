</div>
<!-- /#wrapper -->

<!-- Friend Request Modal -->
<div class="modal fade" id="friendrequestModel" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<div class="alert alert-info" role="alert">{{friend_resuest_status_result}}</div>
				<table class="table">
					<tr>
						<th>Name</th>
						<th>Approve</th>
						<th>reject</th>
					</tr>
					<tr ng-repeat="x in frinedrequests">
						<td>{{ x.senderId }}</td>
						<td><button type="button"
								ng-click="sendFriendrequestStatus(x, 1)"
								class="btn btn-primary glyphicon glyphicon-ok"></button></td>
						<td><button type="button"
								ng-click="sendFriendrequestStatus(x, 0)"
								class="btn btn-primary glyphicon glyphicon-remove"></button></td>
					</tr>

				</table>

			</div>
		</div>
	</div>
</div>

<!-- Notification Modal -->
<div class="modal fade" id="notificationModel" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<div class="modal-body">...</div>

		</div>
	</div>
</div>



<!-- Bootstrap Core JavaScript -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>


<!-- Menu Toggle Script -->
<script>
	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("toggled");
	});
</script>

</body>

</html>
