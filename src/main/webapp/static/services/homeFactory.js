myApp.factory('homeFactory', function($resource,$http){
	var baseURL = "";
	return $resource(baseURL, {}, {
		'getEmpList' : {
			method : 'GET',
			url:  '/EMS/getallemployee'
		},
		'query' : {
			method : 'GET',
			url: '/EMS/search'
		},
		'deleteCandidate' : {
			method : 'GET',
			url: '/EMS/delete'
		},
		'getHolidayList':{
			method : 'GET',
			url: '/EMS/getHolidayList'
		},
		'getEmployeeAttachmentByEmployeeId':{
			method : 'GET',
			url: '/EMS/getEmployeeAttachmentByEmployeeId',
			isArray : true,
		},
		'deleteAttachmentById':{
			method : 'DELETE',
			url:  '/EMS/deleteAttachmentById',
		},
		'getEmployeeProfile':{
			method : 'GET',
			url: '/EMS/getEmployeeProfile',
		},
		'submitUserCredentials':{
			method : 'POST',
			url:  '/EMS/submitUserCredentials',
		},
		'getLeaveCountByEmployeeId' : {
			method : 'GET',
			url:  '/EMS/getLeaveCountByEmployeeId',
		},
		'applyLeave' : {
			url : '/EMS/applyLeave',
			method : 'POST'
		},
		'getallLeaveRequested' : {
			url : '/EMS/getallLeaveRequested',
			method : 'GET',
			isArray : true,
		},
		'updateLeaveStatus' : {
			url : '/EMS/updateLeaveStatus',
			method : 'PUT',
		},
		'findEmployeeByUserId' : {
			url : '/EMS/findEmployeeByUserId',
			method : 'GET',			
		},
		'getJobList' : {
			method : 'GET',
			url:  '/EMS/getAllJobs'
		},
		
	});
});