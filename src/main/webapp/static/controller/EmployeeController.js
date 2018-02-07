myController.controller('EmployeeController',['$scope','$rootScope','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,NgTableParams,homeFactory,$location,$window){
	$scope.userList = [{name:"kuldeep",age:"25"},{name:"ram",age:"25"}]
	
	$scope.deleteUser = function(id)
	{
		if($scope.showconfirmbox());
	}
	
	$scope.editUser = function(data){
  	  $location.path('/editEmployee');
  	  //$scope.updateModeOff = false;
  	  /*.search({candidateid: data.id});*/
  	   
  	}
	
	$scope.displayRecords = function(){  
        $scope.usersTable = new NgTableParams({
			page: 1,
			count : $scope.userList.length
		}, { 
			filterDelay: 0,
			data: $scope.userList,
		});
	};
	$scope.displayRecords();
	
	$scope.showconfirmbox = function () {
		return $window.confirm("Do you want to continue?");
		}

	$scope.updateProfile = function()
	{
		$scope.updateModeOff = false;
	}
}]);
