myController.controller('EmployeeController',['$scope','$rootScope','fileUploadService','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,fileUploadService,NgTableParams,homeFactory,$location,$window){
	$scope.userList = {};
	$scope.input = new Object();
	$scope.deleteUser = function(id)
	{
		if($scope.showconfirmbox());
	}
	
	$scope.editUser = function(data){
  	  $location.path('/editEmployee');
  	  //$scope.updateModeOff = false;
  	  /*.search({candidateid: data.id});*/
  	   
  	}
	
	$scope.loadData = function(){
		homeFactory.getEmpList(function(result){
			$scope.userList = result.employeeList;
			$scope.displayRecords();
		});
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
	
		
	$scope.loadData();
	
	$scope.showconfirmbox = function () {
		return $window.confirm("Do you want to continue?");
		}

	$scope.updateProfile = function()
	{
		$scope.updateModeOff = false;
	}
	
	$scope.save = function(){
		var formData = new FormData();
		$scope.adharFile = document.getElementById("adharupload").files[0];
		$scope.panFile = document.getElementById("pan").files[0];
		$scope.drivingLicenseFile = document.getElementById("drivinglicense").files[0];
		$scope.pvdFile = document.getElementById("pvd").files[0];
		
		formData.append(document.getElementById("adharupload").files[0].name, $scope.adharFile);
		formData.append(document.getElementById("pan").files[0].name, $scope.panFile);
		formData.append(document.getElementById("drivinglicense").files[0].name, $scope.drivingLicenseFile);
		formData.append('data', angular.toJson($scope.input));
		
		fileUploadService.uploadFilesWithData('/addemployee', formData).success(function(response){
				if(response=="success"){
					alert("Registerd Succesfully");
					/*$location.path('/home');*/
				}
			    	}).error(function(result){
			    	});
	}	
}]);
