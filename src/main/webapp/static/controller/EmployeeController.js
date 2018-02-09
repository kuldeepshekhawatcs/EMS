myController.controller('EmployeeController',['$scope','$rootScope','fileUploadService','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,fileUploadService,NgTableParams,homeFactory,$location,$window){
	$scope.userList = [{name:"kuldeep",age:"25"},{name:"ram",age:"25"}]
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
	
	$scope.save = function(){
		var formData = new FormData();
		$scope.adharFile = document.getElementById("adharupload").files[0];
		$scope.panFile = document.getElementById("pan").files[0];
		$scope.drivingLicenseFile = document.getElementById("drivinglicense").files[0];
		$scope.pvdFile = document.getElementById("pvd").files[0];
		
		
		formData.append('adhar', $scope.adharFile);
		formData.append('pan', $scope.panFile);
		formData.append('license', $scope.drivingLicenseFile);
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
