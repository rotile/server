function Ctrl($scope, $http) {
	$scope.submit = function() {
		$http({
			url : '/services/projects',
			method : 'PUT',
			data : '{ "name": "' + this.name + '", "description": "' + this.description + '"}'
		});
		this.name = '';
		this.description = '';
		getProjects($scope, $http);
	};

	getProjects($scope, $http);
}

function getProjects($scope, $http) {
	$http.get('/services/projects').success(function(data) {
		$scope.projects = angular.fromJson(data);
	});
}
