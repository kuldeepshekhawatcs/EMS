myController.controller('JobController',['$scope','$rootScope','fileUploadService','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,fileUploadService,NgTableParams,homeFactory,$location,$window){
	
	$scope.jobList = {};
	$scope.input = {};
	
	$scope.loadData = function(){
		homeFactory.getJobList(function(result){
			$scope.jobList = result.jobList;
			$scope.displayRecords();
		});
	}
	
	
	$scope.displayRecords = function(){  
        $scope.jobTable = new NgTableParams({
			page: 1,
			count : $scope.jobList.length
		}, { 
			filterDelay: 0,
			data: $scope.jobList,
		});
	};
	
		
	$scope.loadData();
	
	
	$scope.datePicketConfiguration = function() {
		  var date_input=$('input[name="date"]'); 
		  var options={
		    format: 'dd/mm/yyyy',
		    todayHighlight: true,
		    autoclose: true,
		  };
		  date_input.datepicker(options);
	}

	$scope.createJob = function(){

		$location.path('/estimate-job');
	}

			$scope.loadNewJob = function() {
				homeFactory.loadNewJob().$promise.then(function(data) {
					if(data != undefined)
				{
						$location.path('/addJob');
						$scope.input = data;
		 		}
			        }, function(data) {
			          alert("Something went wrong !!");
			        });
			}

}]);
