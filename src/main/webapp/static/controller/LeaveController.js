myController.controller('LeaveController',['$scope','$rootScope','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,NgTableParams,homeFactory,$location,$window){
	
	$scope.leaveAppliedList = [];
	$scope.leaveBalance = 0; 
	$scope.leave = {'employee':{}};
	
	$scope.getAllLeaveStatus = function()
	{
		homeFactory.getallLeaveRequested().$promise.then(function(response) {
			$scope.leaveAppliedList = response;
		},function error(response) {
			alert("Something went wrong !!")
		})
			
	}
	$scope.displayRecords = function(){  
        $scope.leaveAppliedTable = new NgTableParams({
			page: 1,
			count : $scope.leaveAppliedList.length
		}, { 
			filterDelay: 0,
			data: $scope.leaveAppliedList,
		});
	};
	$scope.displayRecords();
	$scope.getAllLeaveStatus();
	
	$scope.getLeaveCountByEmployeeId = function() {
		homeFactory.getLeaveCountByEmployeeId({employeeId : $rootScope.employeeId})
		.$promise.then(function(data) {
			if(data != undefined)
		{
				$scope.leaveBalance = data.value; 
				
		}
	        }, function(data) {
	          alert("Something went wrong !!");
	        });
	}
	
	$scope.applyLeave = function(data) {
		$scope.leave.employee.employeeId = $rootScope.employeeId;
		homeFactory.applyLeave(data)
		.$promise.then(function(data) {
			if(data != undefined)
		{
				alert("Successfully Applied !!");
 		}
	        }, function(data) {
	          alert("Something went wrong !!");
	        });
	}
	
	$scope.updateStatus = function (status,data)
	{
		data.leaveStatus = status;
		homeFactory.updateLeaveStatus(data).$promise.then(function(response) {
			alert("Operation Successfully");
			$scope.displayRecords();
			$scope.getAllLeaveStatus();
		},function error(response) {
			alert("Something went wrong !!")
		})
		
	}
	
	
	$scope.getLeaveCountByEmployeeId();
}]);
