function ProjectController($scope, $http, $location, $routeParams, $filter) {

	$scope.project = getProject($scope, $http, $routeParams.projectId);
	$scope.url = $location.absUrl();
	$scope.vote = new Object();

	$scope.submit = function() {
		$http({
			url : '/services/projects/' + $scope.project.id,
			method : "POST",
			data : $filter('json')($scope.vote)
		});
		$scope.vote = new Object();
		getProject($scope, $http, $scope.project.id);
	};
}

function getProject($scope, $http, projectId) {
	$http.get('/services/projects/' + projectId).success(function(data) {
		$scope.project = angular.fromJson(data);
	});
}
