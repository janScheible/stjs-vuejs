package org.stjs.server.rest.spring;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *
 * @author sj
 */
@ControllerAdvice
public class ResponseResultResponseBodyAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		 return ResponseResult.class.isAssignableFrom(returnType.getParameterType());
	}

	@Override
	public Object beforeBodyWrite(Object returnValue, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		ResponseResult<?> responseResult = (ResponseResult<?>) returnValue;
		response.setStatusCode(responseResult.getHttpStatus());
		// TODO This just mimics Jacksons behaviour to place type info in the first position of an wrapper array...
		return new Object[]{responseResult.getBody().getClass().getSimpleName(), responseResult.getBody()};
	}
}
