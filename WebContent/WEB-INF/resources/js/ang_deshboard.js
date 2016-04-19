(function() {
	var app = angular.module("app", [ "ngRoute" ]);

	app.config(function($routeProvider) {

		$routeProvider.when('/logout', {
			templateUrl : "lout"
		})

		$routeProvider.when('/view_friend', {
			templateUrl : "view_friends"
		})

		$routeProvider.when('/friends', {
			templateUrl : "friends"
		})
		$routeProvider.when('/blog', {
			templateUrl : "blog"
		})
		$routeProvider.when('/Add_blog', {
			templateUrl : "Add_blog"
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

		$scope.logout = function() {

			localStorage.clear();

			console.log("in this");

			$location.path("/logout");

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

		$scope.getFriends = function() {

			$http({
				url : 'get_Friends',
				method : "POST",
				data : JSON.stringify({
					"userId" : $scope.userId
				}),
				contentType : 'application/json',
			}).then(function(response) {
				var result = response.data;
				$scope.all_friends = result;
				$location.path('/friends');
			});

		}
		$scope.getBlog = function() {

			$http({
				url : 'get_user_Blogs',
				method : "POST",
				data : JSON.stringify({
					"createId" : $scope.userId
				}),
				contentType : 'application/json',
			}).then(function(response) {
				var result = response.data;
				$scope.all_blog_post = result;
				$location.path("/blog");
			});

		}

		$scope.Add_blog = function() {

			$location.path("/Add_blog");

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

		$scope.add_blog_fun = function(title, content) {

			$http({
				url : 'add_blog_fun',
				method : "POST",
				data : JSON.stringify({
					"createId" : $scope.userId,
					"title" : title,
					"content" : content
				}),
				contentType : 'application/json',
			}).then(function(response) {
				var result = response.data;
				$scope.add_blog_result = result.result;
				$location.path('/Add_blog');
			});

		}

	});

})();
