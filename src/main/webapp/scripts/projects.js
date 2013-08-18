function HomeController($scope, $http, $filter, $location) {
	$scope.projectView = new Object();
	$scope.submit = function() {
		$http({
			url : '/services/projects',
			method : 'PUT',
			data : $filter('json')($scope.projectView)
		}).success(function(data) {
			toProjectPage($location, data);
		});
	};

	getProjects($scope, $http);
}

function getProjects($scope, $http) {
	$http.get('/services/projects').success(function(data) {
		$scope.projects = angular.fromJson(data);
	});
}

function toProjectPage($location, id) {
	$location.path('#/project/' + id);
}