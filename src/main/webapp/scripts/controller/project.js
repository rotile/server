function ProjectController($scope, $http, $location, $routeParams) {

	$scope.project = getProject($scope, $http, $routeParams.projectId);
	$scope.url = $location.absUrl();

	$scope.submit = function() {
		$http({
			url : '/services/projects/' + $scope.project.id + '/' + this.vote,
			method : "POST"
		});
		this.vote = '';
		getProject($scope, $http, $scope.project.id);
	};
}

function getProject($scope, $http, projectId) {
	$http.get('/services/projects/' + projectId).success(function(data) {
		$scope.project = angular.fromJson(data);
	});
}
