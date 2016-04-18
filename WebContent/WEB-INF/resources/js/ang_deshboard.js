(function() {
	var app = angular.module("app", [ "ngRoute" ]);

	app.config(function($routeProvider) {

		$routeProvider.when('/view_friend', {
			templateUrl : "view_friends"
		})
	});

	app.controller("dash_controller", function($scope, $http, $location,
			$rootScope) {
		var temp = localStorage.data;
		;

		while (temp.indexOf("'") > -1) {
			temp = temp.replace("'", "\"");

		}

		var data = JSON.parse(temp);

		$scope.name = data.name;
		$scope.email = data.email;
		$scope.userId = data.userId;
		$scope.frinedrequests = data.frinedrequests;

		$scope.friendSearch = function() {

			$http({
				url : 'people_search',
				method : "POST",
				data : JSON.stringify({
					"name" : $scope.friend_name
				}),
				contentType : 'application/json',
			}).then(function(response) {
				var result = response.data;
				$scope.names = result;
				$location.path('/view_friend');
			});
		};

		$rootScope.sendFriendrequest = function(x) {
			$http({
				url : 'friend_request',
				method : "POST",
				data : JSON.stringify({
					"senderId" : $scope.userId,
					"targerId" : x.userId
				}),
				contentType : 'application/json',
			}).then(function(response) {
				var result = response.data;
				$scope.friend_resuest_result = result.result;
				$location.path('/view_friend');
			});
		}

		$rootScope.sendFriendrequestStatus = function(x, status) {
			$http({
				url : 'friend_request_status',
				method : "POST",
				data : JSON.stringify({
					"senderId" : x.senderId,
					"targerId" : $scope.userId,
					"frId" : x.frId,
					"action" : status
				}),
				contentType : 'application/json',
			}).then(function(response) {
				var result = response.data;
				$scope.friend_resuest_status_result = result.result;
				$location.path('/');
			});
		};

	});

})();
