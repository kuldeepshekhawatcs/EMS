myController.controller('LeaveCalendarController',['$scope','$rootScope','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,NgTableParams,homeFactory,$location,$window){
	
	$scope.holidayList={};

	$scope.loadHolidayCalData = function(){
		homeFactory.getHolidayList(function(result){
			$scope.holidayList = result.calendars;
			$scope.showHolidays();
		});
	}
	
	$scope.showHolidays = function(){
		$scope.holidayTable = new NgTableParams({
			page: 1,
			count : $scope.holidayList.length
		}, { 
			filterDelay: 0,
			data: $scope.holidayList,
		});
	};
	
	$scope.loadHolidayCalData();
	
}]);