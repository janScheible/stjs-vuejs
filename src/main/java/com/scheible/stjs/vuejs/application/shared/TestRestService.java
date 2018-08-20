package com.scheible.stjs.vuejs.application.shared;

import org.springframework.web.bind.annotation.GetMapping;
import org.stjs.shared.rest.spring.RestResult;
import org.stjs.shared.rest.spring.RestService;

/**
 *
 * @author sj
 */
public interface TestRestService extends RestService {
	
	@GetMapping("/get-result")
	RestResult<ResultDto> getResult();
}
