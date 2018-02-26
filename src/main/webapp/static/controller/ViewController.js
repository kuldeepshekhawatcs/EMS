myController.controller('ViewController',['$scope','$rootScope','fileUploadService','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,fileUploadService,NgTableParams,homeFactory,$location,$window){
	
	$scope.input = {};
	
		$scope.getEmployeeProfile = function() {
			homeFactory.getEmployeeProfile({employeeId : $rootScope.employeeId})
			.$promise.then(function(data) {
				if(data != undefined)
			{
					$scope.input = data;
					
			}
		        }, function(data) {
		          alert("Something went wrong !!");
		        });
		}
	
			$scope.getEmployeeProfile();
			
			$scope.editUser = function(data){
				$location.path('/editEmployee').search({editData: data});
		  	}
			
}]);
