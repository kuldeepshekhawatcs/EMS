myController.controller('EmployeeEditController',['$scope','$rootScope','fileUploadService','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,fileUploadService,NgTableParams,homeFactory,$location,$window){
	
	$scope.input = {};
	$scope.input.availableDocs = {};
	function getEmployeeProfile() {
		var selectIdFromTable = $location.search();
		homeFactory.getEmployeeProfile({employeeId : selectIdFromTable.editData.employeeId})
		.$promise.then(function(data) {
			if(data != undefined)
		{
				$scope.input = data;
				getEmployeeAttachmentByEmployeeId();
		}
	        }, function(data) {
	          alert("Something went wrong !!");
	        });
	}
	
	getEmployeeProfile();
	
	$scope.removeAttachment = function(data)
	{
		for (var key in $scope.input.availableDocs) {
		    var obj = $scope.input.availableDocs[key];
		    if(obj.documentDescription == data)
		    	homeFactory.deleteAttachmentById({documentId : obj.documentId})
				.$promise.then(function(data) {
					alert(JSON.stringify(data))
					if(data != undefined )
					{
						alert("Sucessfully Removed");
						getEmployeeAttachmentByEmployeeId();
					}
			        }, function(data) {
			          alert("Something went wrong !!");
			        });
		    }
	}
	
	$scope.showRemoveLink = function (data)
	{
		for (var key in $scope.input.availableDocs) {
		    var obj = $scope.input.availableDocs[key];
		    if(obj.documentDescription == data)
		    	return true;
		    }
	}
	
	
	function getEmployeeAttachmentByEmployeeId() { 
	homeFactory.getEmployeeAttachmentByEmployeeId({employeeId : $scope.input.user.id})
			.$promise.then(function(data) {
				if(data != undefined)
			{
					$scope.input.availableDocs = data;
			}
		        }, function(data) {
		          alert("Something went wrong !!");
		        });
	}
	
	$scope.UpdateUser = function()
	{
		alert(JSON.stringify($scope.input))
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
			
		
		fileUploadService.uploadFilesWithData('/EMS/updateemployee', formData).success(function(response){
				if(response=="success"){
					alert("Succesfully");
					$location.path('/employeelist');
				}
			    	}).error(function(result){
			    		alert("something went wrong !!!");
			    	});
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
	
	$scope.downloadAttachment = function (data)
	{
		for (var key in $scope.input.availableDocs) {
		    var obj = $scope.input.availableDocs[key];
		    if(obj.documentDescription == data)
		    	var s = "/EMS/downloadAttachmentById/" + obj.documentId;
		    	$window.open(s);
		    }
	}
	
}]);
