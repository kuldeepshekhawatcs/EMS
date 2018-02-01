myController.controller('LeaveController',['$scope','$rootScope','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,NgTableParams,homeFactory,$location,$window){
	
	$scope.leaveList = [{name:"kuldeep",age:"25"},{name:"ram",age:"25"}]
	
	$scope.displayRecords = function(){  
        $scope.leaveTable = new NgTableParams({
			page: 1,
			count : $scope.leaveList.length
		}, { 
			filterDelay: 0,
			data: $scope.leaveList,
		});
	};
	$scope.displayRecords();
	
	
}]);
