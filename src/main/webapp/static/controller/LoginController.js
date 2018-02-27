myController.controller('LoginController',['$scope','$rootScope','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,NgTableParams,homeFactory,$location,$window){
	
	$scope.user = {};
	$rootScope.showlogin = true;
	$scope.checkRole = false;
	$scope.showEmployeeManagement = false;
	$scope.profileManagement = false;
	$scope.submitUserCredentials = function(data)
	{
		homeFactory.submitUserCredentials(data).$promise.then(function(data) {
			$rootScope.showlogin = false;
			$rootScope.showHome = true;
			$rootScope.userId = data.id;
			$scope.setViewAccordingToRole($rootScope.userId);
		},function error(data) {
			alert("Invalid Credentials !!")
		})
			
	}
	
	$scope.setViewAccordingToRole = function(userId)
	{ 
		homeFactory.findEmployeeByUserId({userId: userId}).$promise.then(function(data) {
			if(data.role.roleName == "MANAGER" ||  data.role.roleName == "ADMIN")
			{
			$scope.showEmployeeManagement = true;
			$scope.profileManagement = true;
			$rootScope.employeeId = data.employeeId;
			}
			else{
			$scope.profileManagement = false;
			}
			
		},function error(data) {
			alert("Invalid Credentials !!")
		});
	}

}]);
