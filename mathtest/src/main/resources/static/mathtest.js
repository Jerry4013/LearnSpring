

var app = angular.module('question', []);
app.controller('mathtest', function($scope, $http) {

    $http.get('http://localhost:8080/question').
    then(function(response) {
        $scope.question = response.data;
    });

    $scope.answer = null;

    $scope.checkAnswer = function () {
        var x = 2;
        $http.post('http://localhost:8080/answer', $scope.answer)
            .then(function (response) {
                    $scope.result = response.data;
                    if ($scope.result.result === "correct")
                        $scope.msg = "Congratulations!";
                    else if ($scope.result.result === "incorrect")
                        $scope.msg = "incorrect. Try again";
                    else if ($scope.result.result === "wrongFormat")
                        $scope.msg = "Wrong Format. Please enter a number";
                },
                function (response) {
                    $scope.msg = "Service not Exists";
                    $scope.statusval = response.status;
                    $scope.statustext = response.statusText;
                 });
    };

    $scope.tryAgain = function () {
        $scope.msg = null;
        $scope.answer = null;
        $http.get('http://localhost:8080/next').
        then(function(response) {
            $scope.question = response.data;
        });
    };

    $scope.myKeyup = function(event, question){
        if (event.key === "Enter") {
            $scope.checkAnswer(question);
        }
    };
});



