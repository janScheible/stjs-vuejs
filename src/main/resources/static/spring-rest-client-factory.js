RestClientFactory = {};
(function () {
	const clientInstanceCache = {};
	
	function getRequest(url, callback) {
		const request = new XMLHttpRequest();
        request.open("GET", url, true);
        request.onreadystatechange = () => {
            const state = request.readyState;
            if(state === 4) {
                if(request.status === 200) {
					callback(request.responseText);
                } else {
					alert("Error: " + request.statusText);
                }
            }
        };
        request.send(null);   
	}
	
	RestClientFactory.get = function(restServiceClass) {
		if(!clientInstanceCache[restServiceClass.name]) {
			const restRequests = [];

			for (var annotatedElement in restServiceClass.$annotations) {
				if (restServiceClass.$annotations.hasOwnProperty(annotatedElement)) {
					const getMappingAnnotation = restServiceClass.$annotations[annotatedElement].GetMapping;
					if(getMappingAnnotation) {
						restRequests.push({
							methodName: annotatedElement,
							path: getMappingAnnotation.value
						});
					}
				}
			}

			const clientInstance = {};
			for(const restRequest of restRequests) {
				clientInstance[restRequest.methodName] = function() {
					return {
						then: function(callback) {
							getRequest(restRequest.path, function(jsonString) {
								const parsedJson = JSON.parse(jsonString);
								callback(200, stjs.parseJSON(JSON.stringify(parsedJson[1]), window[parsedJson[0]]));
							});
						}
					};
				};
			}

			clientInstanceCache[restServiceClass.name] = clientInstance;		
		}
		
		return clientInstanceCache[restServiceClass.name];
	};
}());