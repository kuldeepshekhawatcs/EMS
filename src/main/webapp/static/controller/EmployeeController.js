myController.controller('EmployeeController',['$scope','$rootScope','fileUploadService','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,fileUploadService,NgTableParams,homeFactory,$location,$window){
	
	$scope.userList = {};
	$scope.input = {"firstName":null,"middleName":null,"lastName":null,"gender":"MALE","phoneNumber":null,
			"email":null,"dateOfBirth":null,"dateOfJoining":null,"address":null,"pinCode":null,"country":null,
			"bankAccountNumber":null,"bankName":null,"branchName":null,"ifscCode":null,"adharNumber":null,
			"panNumber":null,"drivinglicenseNumber":null,"employeeType":"","role":""};
	
	$scope.showmandatory = false;

	
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
	
	$scope.save = function(data,valid){
		alert(JSON.stringify($scope.input));
		if(valid){
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
		
		fileUploadService.uploadFilesWithData('/EMS/addemployee', formData).success(function(response){
				if(response=="success"){
					alert("Registerd Succesfully");
					$location.path('/');
					
				}
			    	}).error(function(result){
			    		alert("Something went wrong !!");
			    	});
	}	
 	else {
			$scope.showmandatory = true
		}
							}
	
	
	$scope.populatedDropDownLists = function()
	{
		homeFactory.dropdownlists().$promise.then(function(data) {
			if (data != undefined) {
					$scope.rolesList = data.rolesList;
					$scope.employeeTypeList = data.empTypeList;
			}
		}, function(data) {
			alert("Something went wrong !!");
		});
	} 
	
	$scope.cancel = function()
	{
		if($scope.showconfirmbox())
		{
			$location.path('/employeelist');
		}
	}
	
}]);
