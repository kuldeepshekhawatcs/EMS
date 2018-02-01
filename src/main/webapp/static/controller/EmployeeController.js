myController.controller('EmployeeController',['$scope','$rootScope','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,NgTableParams,homeFactory,$location,$window){
	
	$scope.candidateList = [{name:"kuldeep",age:"25"},{name:"ram",age:"25"}]
	$scope.updateMode = false;  
	
	$scope.deleteUser = function(id)
	{
		if($scope.showconfirmbox());
	}
	
	$scope.editUser = function(href,data){
  	  //$location.path('/edit').search({candidateid: data.id});
  	   alert(JSON.stringify(data));
  	}
	
	$scope.displayRecords = function(){  
        $scope.usersTable = new NgTableParams({
			page: 1,
			count : $scope.candidateList.length
		}, { 
			filterDelay: 0,
			data: $scope.candidateList,
		});
	};
	$scope.displayRecords();
	
	$scope.showconfirmbox = function () {
		return $window.confirm("Do you want to continue?");
		}

}]);
