myController.controller('EmployeeController',['$scope','$rootScope','fileUploadService','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,fileUploadService,NgTableParams,homeFactory,$location,$window){
	
	$scope.userList = {};
	$scope.input = {};
	
	$scope.deleteUser = function(id)
	{
		if($scope.showconfirmbox());
	}
	
	$scope.editUser = function(data){
		$location.path('/editEmployee').search({editData: data});
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
		
		formData.append('data', angular.toJson($scope.input));
		
			if(document.getElementById("adharupload").files[0] != undefined)
			{
				$scope.adharFile = document.getElementById("adharupload").files[0];
				formData.append("adhar", $scope.adharFile);
			}
			if(document.getElementById("pan").files[0] != undefined)
			{
				$scope.panFile = document.getElementById("pan").files[0];
				formData.append("pan", $scope.panFile);
			}
			if(document.getElementById("drivinglicense").files[0] != undefined)
			{
				$scope.drivingLicenseFile = document.getElementById("drivinglicense").files[0];
				formData.append("drivinglicense", $scope.drivingLicenseFile);
			}
			if(document.getElementById("pvd").files[0] != undefined)
			{
				$scope.pvdFile = document.getElementById("pvd").files[0];
				formData.append("pvd", $scope.pvd);
			}
		
		fileUploadService.uploadFilesWithData('/addemployee', formData).success(function(response){
				if(response=="success"){
					alert("Registerd Succesfully");
					/*$location.path('/home');*/
				}
			    	}).error(function(result){
			    	});
	}	
}]);
