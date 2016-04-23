<div>

	<div class="row">

		<div class="alert alert-info" role="alert">{{action_result}}</div>
	</div>
	<div class="row">
		<div class="col-md-10 col-lg-10">
			<b>{{blog_title}}</b>
		</div>

	</div>
	<div class="row">
		<div class="col-md-10 col-lg-10">
			<br> {{blog_content}}
		</div>

	</div>
	<div class="row">

		<div class="col-md-10 col-lg-10">
			<br> <b>Comments:</b><br>
			<div ng-repeat="x in actions">
				<b>{{x.userId}} </b> {{x.content}}
			</div>

		</div>

	</div>

	<div class="row">
		<div class="col-md-10 col-lg-10">
			<br> <b>Comment</b>
			<textarea class="form-control" rows="3" ng-model="action_content"></textarea>
			<button type="button" class="btn btn-primary"
				ng-click="add_action(action_content)">Add Comment</button>
		</div>

	</div>
</div>