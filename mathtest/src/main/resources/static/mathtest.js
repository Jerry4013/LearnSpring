
// $(document).ready(function() {
//     $.ajax({
//         url: "http://localhost:8080/question"
//     }).then(function(data) {
//         $('#operand1').text(data.operand1);
//         $('#operand2').text(data.operand2);
//         $('#operator').text(data.operator);
//     });
// });

var app = angular.module('question', []);
app.controller('mathtest', function($scope, $http) {

    $http.get('http://localhost:8080/question').
    then(function(response) {
        $scope.question = response.data;
    });

    $scope.checkAnswer = function (question) {

        $http.post('http://localhost:8080/answer', JSON.stringify(question))
            .then(function (response) {
                    $scope.question = response.data;
                    if ($scope.question.result === "correct")
                        $scope.msg = "Congratulations!";
                    else $scope.msg = "incorrect. Try again";
                },
                function (response) {
                    $scope.msg = "Service not Exists";
                    $scope.statusval = response.status;
                    $scope.statustext = response.statusText;
                 });
    };

    $scope.tryAgain = function () {
        $scope.msg = null;
        $http.get('http://localhost:8080/question').
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



