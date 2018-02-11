myApp.factory('homeFactory', function($resource){
	var baseURL = "";
	return $resource(baseURL, {}, {
		'get' : {
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
	});
});