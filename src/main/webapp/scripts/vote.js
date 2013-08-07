function Ctrl($scope, $http) {
  $scope.submit = function() {
    $http({
            url: '/vote/' + this.vote,
            method: "POST"
    });
    this.vote = '';
    getVotes($scope, $http);
  };
  
  getVotes($scope, $http);
}

function getVotes($scope, $http) {
	$http.get('/vote').success(function(data) {
    	$scope.votes = data;
  	});
}