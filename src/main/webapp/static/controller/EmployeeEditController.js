myController.controller('EmployeeEditController',['$scope','$rootScope','fileUploadService','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,fileUploadService,NgTableParams,homeFactory,$location,$window){
	
	$scope.input = {};
	var editEmployeeData = $location.search();
	$scope.input = angular.copy(editEmployeeData.editData);
	$scope.input.availableDocs = {};
	alert(JSON.stringify($scope.input));
	$scope.removeAttachment = function(data)
	{
		for (var key in $scope.input.availableDocs) {
		    var obj = $scope.input.availableDocs[key];
		    if(obj.documentDescription == data)
		    	homeFactory.deleteAttachmentById({documentId : obj.documentId})
				.$promise.then(function(data) {
					if(data == "success" )
					{
						alert("Sucessfully Removed");
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
	
	homeFactory.getEmployeeAttachmentByEmployeeId({employeeId : $scope.input.user.id})
			.$promise.then(function(data) {
				if(data != undefined)
			{
					$scope.input.availableDocs = data;
			}
		        }, function(data) {
		          alert("Something went wrong !!");
		        });
	
	
	$scope.UpdateUser = function()
	{
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
		
		fileUploadService.uploadFilesWithData('/EMS/updateemployee', formData).success(function(response){
				if(response=="success"){
					alert("Succesfully");
					$location.path('/employeelist');
				}
			    	}).error(function(result){
			    		alert("something went wrong !!!");
			    	});
	}
	
	
		
	
}]);
