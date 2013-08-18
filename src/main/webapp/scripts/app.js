angular.module('rotile', []).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : 'projects.html',
				controller : HomeController
			}).when('/project/:projectId', {
				templateUrl : 'project.html',
				controller : ProjectController
			}).otherwise({
				redirectTo : '/'
			});
		} ]);