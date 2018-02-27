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
			method : 'POST',
			url: '/submitUserCredentials',
		},
		'getLeaveCountByEmployeeId' : {
			method : 'GET',
			url: '/getLeaveCountByEmployeeId',
		},
		'applyLeave' : {
			url : '/applyLeave',
			method : 'POST'
		},
		'getallLeaveRequested' : {
			url : '/getallLeaveRequested',
			method : 'GET',
			isArray : true,
		},
		'updateLeaveStatus' : {
			url : '/updateLeaveStatus',
			method : 'PUT',
		},
		'findEmployeeByUserId' : {
			url : '/findEmployeeByUserId',
			method : 'GET',			
		}
		
	});
});