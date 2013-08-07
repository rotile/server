function Ctrl($scope, $http) {
  $scope.submit = function() {
    $http({
            url: '/vote/' + this.vote,
            method: "POST"
    });
    this.vote = '';
  };
}

function getVotes($scope, $http) {
  var promise = $http.get('/vote').success(function(data) {
    $scope.votes = data;
  });
}