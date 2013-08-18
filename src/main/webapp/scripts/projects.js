function Ctrl($scope, $http, $filter) {
	$scope.submit = function() {
		var projectView = new Object();
		projectView.name = this.name;
		projectView.description = this.description;
		$scope.projectView = projectView;
		$http({
			url : '/services/projects',
			method : 'PUT',
			data : $filter('json')($scope.projectView)
		});
		this.name = '';
		this.description = '';
		$scope.projectView = null;
		getProjects($scope, $http);
	};

	getProjects($scope, $http);
}

function getProjects($scope, $http) {
	$http.get('/services/projects').success(function(data) {
		$scope.projects = angular.fromJson(data);
	});
}
