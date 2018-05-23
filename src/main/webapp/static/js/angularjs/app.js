var myApp = angular.module('myApp', ['ngRoute','myController','myServices','ngResource','ngTable','ngCookies']);

var myController = angular.module('myController',[]);

var myServices = angular.module('myServices', []);



myApp.config(function($routeProvider) {
    $routeProvider
    .when("/addEmployee", {
        templateUrl : "html/AddEmployee.html"
              
    })
    .when("/employeelist", {
        templateUrl : "html/EmployeeList.html"
              
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
     .when("/delete", {
        templateUrl : "html/DeletePopUp.html"
    
    })
    .when("/viewProfile", {
        templateUrl : "html/ViewEmployee.html"
    
    })
    .when("/editEmployee", {
        templateUrl : "html/UpdateEmployee.html"
              
    })
     .when("/applyLeave", {
        templateUrl : "html/ApplyLeave.html"
    })
    .when("/leaveStatus", {
        templateUrl : "html/LeaveStatus.html"
    })
     .when("/showAllJob", {
        templateUrl : "html/Jobs.html"
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