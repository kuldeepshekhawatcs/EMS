myController.controller('InvoiceController',['$scope','$rootScope','fileUploadService','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,fileUploadService,NgTableParams,homeFactory,$location,$window){
	
	$scope.input = {};
	$scope.part = {"name":"","rate":0.0,"quantity":0.0,"total":0.0,"discount":0.0,"selected":true};
	$scope.invoice = {"job":{}, "items":[],"shipping":"0.0","miscellanous":"0.0","subTotal":0.0,"advancePaid":0.0,"balance":0.0};
	$scope.displayInvoiceTable = false;
	
	$rootScope.loadJobCartDetail = function() {
		homeFactory.getJobCartById({id :$rootScope.jobCartId}).$promise.then(function(data) {
			if (data != undefined) {
				$scope.input = data;
				if(data.ticketNo != null){
				getInvoiceByJobId(data.ticketNo);
				}
			}
		}, function(data) {
			alert("Something went wrong !!");
			$location.path('/showAllJob');
		});
	}
	
	$rootScope.loadJobCartDetail();
	
	
	$scope.setTable = function() {
		 $scope.displayInvoiceTable = true;
		$scope.parts = new NgTableParams({
			page : 1,
			count : $scope.invoice.items.length
		}, {
			filterDelay : 0,
			data : $scope.invoice.items,
		});
	}
	
	
	$scope.addPart = function()
	{
		$scope.invoice.items.push($scope.part);
		$scope.invoice.job.ticketNo = $scope.input.ticketNo;
		createUpdateInvoice();
	}
	
	$scope.calculateTotal = function(part)
	{
		var part = angular.copy($scope.part);
		var totalPrice = part.rate * part.quantity;
		if(part.discount > 0.0 && part.discount != "")
		{
			totalPrice = totalPrice - (totalPrice * part.discount/100);
		}
		$scope.part.total = totalPrice;
	}
	
	$scope.updateInvoiceOnChange = function(data,index)
	{
		createUpdateInvoice();
	}
	
	function createUpdateInvoice()
	{
		homeFactory.createInvoice($scope.invoice).$promise.then(function(data) {
			if (data != undefined) {
				$scope.invoice = data;
				$scope.setTable();
			}
		}, function(data) {
			alert("Something went wrong !!");
			$location.path('/showAllJob');
		});
	}
	
	$scope.finaliseInvoice = function()
	{
		homeFactory.finaliseInvoice($scope.invoice).$promise.then(function(data) {
			if (data != undefined) {
				alert("Successfully Done !!!");
				$location.path('/showAllJob');
			}
		}, function(data) {
			alert("Something went wrong !!");
			$location.path('/showAllJob');
		});
	}
	
	$scope.cancelJob = function()
	{
		homeFactory.cancelJob($scope.invoice.job.ticketNo).$promise.then(function(data) {
			if (data != undefined) {
				alert("Successfully Cancelled !!!");
			}
		}, function(data) {
			alert("Something went wrong !!");
			$location.path('/showAllJob');
		});
	}
	
	function getInvoiceByJobId(id)
	{
		homeFactory.getInvoiceByJobId({id:id}).$promise.then(function(data) {
			if (data != undefined) {
				if(data.hasOwnProperty("invoiceId"))
				{
					$scope.invoice = data;
					$scope.setTable();
				}
			}
		}, function(data) {
			alert("Something went wrong !!");
			$location.path('/showAllJob');
		});
	}
	
}]);
