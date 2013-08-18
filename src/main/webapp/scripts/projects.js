function Ctrl($scope, $http, $filter) {
	$scope.projectView = new Object();
	$scope.submit = function() {
		$http({
			url : '/services/projects',
			method : 'PUT',
			data : $filter('json')($scope.projectView)
		});
		$scope.projectView = new Object();
		getProjects($scope, $http);
	};

	getProjects($scope, $http);
}

function getProjects($scope, $http) {
	$http.get('/services/projects').success(function(data) {
		$scope.projects = angular.fromJson(data);
	});
}
