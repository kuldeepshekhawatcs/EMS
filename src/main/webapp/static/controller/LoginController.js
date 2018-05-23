myController.controller('LoginController',['$scope','$rootScope','NgTableParams','homeFactory','$location','$window','$cookies',function($scope,$rootScope,NgTableParams,homeFactory,$location,$window,$cookies){
	$scope.user = {};
	$scope.showEmployeeManagement = false;
	$scope.profileManagement = false;
	
	$scope.setViewAccordingToRole = function(userId)
	{ 
		var cookieValue = document.cookie.replace(/(?:(?:^|.*;\s*)userId\s*\=\s*([^;]*).*$)|^.*$/, "$1");
		homeFactory.findEmployeeByUserId({userId: cookieValue}).$promise.then(function(data) {
			if(data.role.roleName == "MANAGER" ||  data.role.roleName == "ADMIN")
			{
			$scope.showEmployeeManagement = true;
			$scope.profileManagement = true;
			$rootScope.employeeId = data.employeeId;
			$rootScope.userId = data.user.id;
			}
			else{
			$scope.profileManagement = false;
			}
			
		},function error(data) {
			alert("Invalid Credentials !!")
		});
	}

	$scope.setViewAccordingToRole();
}]);
