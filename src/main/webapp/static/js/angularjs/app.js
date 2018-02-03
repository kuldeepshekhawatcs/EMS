var myApp = angular.module('myApp', ['ngRoute','myController','myServices','ngResource','ngTable']);

var myController = angular.module('myController',[]);

var myServices = angular.module('myServices', []);



myApp.config(function($routeProvider) {
    $routeProvider
    .when("/addEmployee", {
        templateUrl : "html/AddEmployee.html"
              
    })
    .when("/employeelist", {
        templateUrl : "html/EmployeeListTest.html"
              
    })
    .when("/leaveCalender", {
        templateUrl : "html/LeaveCalender.html"
        
    })
    .when("/leaveUpdate", {
        templateUrl : "html/LeaveUpdate.html"
    })
   .when("/leavereport", {
        templateUrl : "html/LeaveReport.html"
    })
   .when("/editEmployee", {
        templateUrl : "html/UpdateEmployee.html"
    })
    .when("/delete", {
        templateUrl : "html/DeletePopUp.html"
    
    })
});


myApp.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
 }]);