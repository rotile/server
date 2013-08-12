function Ctrl($scope, $http, $location) {

	$scope.projectId = $location.search().projectId;
	$scope.project = getProject($scope, $http);

	$scope.submit = function() {
		$http({
			url : '/services/projects/' + $scope.project.name + '/' + this.vote,
			method : "POST"
		});
		this.name = '';
		getProject($scope, $http);
	};
}

function getProject($scope, $http) {
	$http.get('/services/projects/' + $scope.projectId).success(function(data) {
		$scope.project = angular.fromJson(data);
	});
}
