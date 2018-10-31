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
        templateUrl : "html/UpdateEmployee1.html"
              
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
    .when("/addJob", {
        templateUrl : "html/AddJob.html"
    })
    .when("/estimate-job", {
        templateUrl : "html/Estimate.html"
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

myApp.directive('upperCase', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, modelCtrl) {
            modelCtrl.$parsers.push(function(input) {
                return input ? input.toUpperCase() : "";
            });
            element.css("text-transform","uppercase");
        }
    };
})

myApp.filter('unique', function() {
  return function (arr, field) {
	  var temp ={};
	  var r = [];
    for(i=0; i<arr.length;i++) {
    	temp[arr[i][field]] = arr[i][field];
    }
    for(i in temp) {
      r.push(temp[i]);
    }
    return r;
  };
})


