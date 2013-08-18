angular.module('rotile', []).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : 'partials/home.html',
				controller : HomeController
			}).when('/project/:projectId', {
				templateUrl : 'partials/project.html',
				controller : ProjectController
			}).otherwise({
				redirectTo : '/'
			});
		} ]);