var app = angular.module('myApp', []);
app.controller('pollution', function($scope, $http) {
    $http.get("/query")
        .then(function(response) {
            $scope.result = response.data;
            if ($scope.result.data.pm25 > 150 ){
                $("#cloud-on-sun").attr("src", "images/badsun.png");
                $('body').css("background-image", "url(images/background.jpg)");
                $('.cloud').css("background-image", "url(images/could.png)");
            }
        });
});