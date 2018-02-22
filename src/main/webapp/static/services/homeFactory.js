myApp.factory('homeFactory', function($resource,$http){
	var baseURL = "";
	return $resource(baseURL, {}, {
		'getEmpList' : {
			method : 'GET',
			url: '/getallemployee'
		},
		'query' : {
			method : 'GET',
			url: baseURL+'/search'
		},
		'deleteCandidate' : {
			method : 'GET',
			url: baseURL+'/delete'
		},
		'getHolidayList':{
			method : 'GET',
			url: '/getHolidayList'
		},
		'getEmployeeAttachmentByEmployeeId':{
			method : 'GET',
			url: '/getEmployeeAttachmentByEmployeeId',
			isArray : true,
		},
		'deleteAttachmentById':{
			method : 'DELETE',
			url: '/deleteAttachmentById',
		},
		'getEmployeeProfile':{
			method : 'GET',
			url: '/getEmployeeProfile',
		},
		'submitUserCredentials':{
			method : 'GET',
			url: '/submitUserCredentials',
		}
		
	});
});