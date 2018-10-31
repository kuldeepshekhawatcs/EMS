myController.controller('JobController',['$scope','$rootScope','fileUploadService','NgTableParams','homeFactory','$location','$window','$routeParams','$filter',function($scope,$rootScope,fileUploadService,NgTableParams,homeFactory,$location,$window,$rootParams,$filter){
	$scope.jobList = {};
	$scope.input = {"ticketNo":null,"registrationNo":"","status":null,"advisor":null,"vehicleName":null,"arrivalDate":null,"delieveryDate":null,"mobileNumber":null,"partStatus":null,"customerName":null,"insuranceName":null,"odoMeter":null,"avgKmPerDay":null,"vinNo":null,"engineNo":null,"modelName":null,"make":null,"modelYear":null,"variant":null,"vehicleColor":null,"fuelType":null,"serviceType":null,"complaint":null,"customer":null};
	$scope.part = {"name":"","rate":0.0,"quantity":0.0,"total":0.0,"discount":0.0,"selected":true};
	$scope.invoice = {"parts":[],"shipping":"0.0","miscellanous":"0.0","subTotal":0.0,"advancePaid":0.0,"balance":0.0};
	$scope.displayInvoiceTable = false;
	$scope.showmandatory = false;
	$scope.regexRegistration = /^[A-Z]{2}[-][0-9]{2}[-]^[A-Z]{2}[-][0-9]{4}$/;
	$scope.vehicles = [];
	
	
	$scope.loadData = function(){
		homeFactory.getJobList().$promise.then(function(result){
			$scope.jobList = result.jobList;
			$scope.displayRecords();
		},function(error){
			alert("Something went wrong");
			$location.path('/showAllJob');
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
		    format: 'yyyy-mm-dd',
		    todayHighlight: true,
		    autoclose: true,
		  };
		  date_input.datepicker(options);
	}
	
		$scope.estimateJob = function(data,valid){
			if(valid){
			$scope.input.delieveryDate = angular.element(document.getElementById('frompicker')).val();	
			homeFactory.createJob(data).$promise.then(function(data) {
				if (data != undefined) {
					$rootScope.jobCartId = data.ticketNo;
					$location.path('/estimate-job');
				}
			}, function(data) {
				alert("Something went wrong !!");
				$location.path('/showAllJob');
			});
			}else
			{
				$scope.showmandatory =true;
			}
			
		}

			$scope.loadNewJob = function() {
				homeFactory.loadNewJob().$promise.then(function(data) {
					if (data != undefined) {
						$location.path('/addJob');
						$scope.input = data;
					}
				}, function(data) {
					alert("Something went wrong !!");
					$location.path('/showAllJob');
				});
			}
			
			
			
			$scope.editJobCart = function(job)
			{
				$rootScope.jobCartId = job.ticketNo;
				$location.path('/estimate-job');
			}
			
			$scope.estimateLater = function(data,valid)
			{
				if(valid){
					$scope.input.delieveryDate = angular.element(document.getElementById('frompicker')).val();	
					homeFactory.createJob(data).$promise.then(function(data) {
						if (data != undefined) {
							$rootScope.jobCartId = data.ticketNo;
							$location.path('/showAllJob');
						}
					}, function(data) {
						alert("Something went wrong !!");
					});
					}else
					{
						$scope.showmandatory =true;
					}
				
			}
			
			$scope.loadVehicleDataForList = function()
			{
				homeFactory.getVehicles().$promise.then(function(data) {
					if (data != undefined) {
						$scope.vehicles = data.vehicleList;
						$scope.fuels = $filter('unique')($scope.vehicles,"fuel");
						$scope.colors = $filter('unique')($scope.vehicles,"color");
						$scope.paymentMode = data.paymentModeList; 
					}
				}, function(data) {
					alert("Something went wrong !!");
				});
			} 
			
			$scope.setCarMakeOnSelection = function(selectedValue)
			{
				var result = selectedValue.split(",");
				$scope.input.model = result.pop();
				$scope.input.make = result.pop();
			}
			
			

}]);
