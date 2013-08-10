function Ctrl($scope, $http) {
  $scope.submit = function() {
    $http({
            url: '/services/vote/' + this.vote,
            method: "POST"
    });
    this.vote = '';
    getVotes($scope, $http);
  };
  
  getVotes($scope, $http);
}

function getVotes($scope, $http) {
	$http.get('/services/vote').success(function(data) {
    	$scope.votes = data;
  	});
}