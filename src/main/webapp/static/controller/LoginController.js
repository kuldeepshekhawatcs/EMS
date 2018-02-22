myController.controller('LoginController',['$scope','$rootScope','NgTableParams','homeFactory','$location','$window',function($scope,$rootScope,NgTableParams,homeFactory,$location,$window){
	
	$scope.user = {};
	$scope.submitUserCredentials = function(data)
	{
		homeFactory.submitUserCredentials({username : data.userName,password:data.password},function(data,getResponseHeaders){
			if(data != undefined)
				{
					alert("Should show index page");
				}
			
		}
				
		
		)
	}

}]);
