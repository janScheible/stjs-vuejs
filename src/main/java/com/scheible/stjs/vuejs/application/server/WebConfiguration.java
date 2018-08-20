package com.scheible.stjs.vuejs.application.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.stjs.server.rest.spring.ResponseResultResponseBodyAdvice;

/**
 *
 * @author sj
 */
@Configuration
public class WebConfiguration {

	@Bean
	ResponseResultResponseBodyAdvice responseResultResponseBodyAdvice() {
		return new ResponseResultResponseBodyAdvice();
	}
}
