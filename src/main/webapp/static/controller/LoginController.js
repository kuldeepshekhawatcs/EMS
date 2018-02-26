myController.controller('LoginController',['$scope','$rootScope','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,NgTableParams,homeFactory,$location,$window){
	
	$scope.user = {};
	$rootScope.showlogin = true;
	$scope.checkRole = false;
	$scope.showEmployeeManagement = false;
	$scope.profileManagement = false;
	$scope.submitUserCredentials = function(data)
	{
		homeFactory.submitUserCredentials({username : data.userName,password:data.password}).$promise.then(function(data) {
			$rootScope.showlogin = false;
			$rootScope.showHome = true;
			$rootScope.employeeId = data.employeeId;
			$scope.setViewAccordingToRole(data.role.roleName);
		},function error(data) {
			alert("Invalid Credentials !!")
		})
			
	}
	
	$scope.setViewAccordingToRole = function(data)
	{ 
		if(data == "MANAGER" ||  data == "ADMIN")
		{
		$scope.showEmployeeManagement = true;
		$scope.profileManagement = true;
		}
		else
		$scope.profileManagement = false;
	}

}]);
