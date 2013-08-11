function Ctrl($scope, $http) {
	$scope.submit = function() {
		$http({
			url : '/services/projects/' + this.name,
			method : "PUT"
		});
		this.name = '';
		getProjects($scope, $http);
	};

	getProjects($scope, $http);
}

function getProjects($scope, $http) {
	$http.get('/services/projects').success(function(data) {
		$scope.projects = data;
	});
}