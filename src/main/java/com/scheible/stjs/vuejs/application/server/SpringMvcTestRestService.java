package com.scheible.stjs.vuejs.application.server;

import com.scheible.stjs.vuejs.application.shared.ResultDto;
import com.scheible.stjs.vuejs.application.shared.TestRestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.stjs.server.rest.spring.ResponseResult;
import org.stjs.shared.rest.spring.RestResult;

/**
 *
 * @author sj
 */
@RestController
public class SpringMvcTestRestService implements TestRestService {

	@Override
	public RestResult<ResultDto> getResult() {
		return new ResponseResult(HttpStatus.OK, new ResultDto("Darkwing Duck"));
	}	
}
