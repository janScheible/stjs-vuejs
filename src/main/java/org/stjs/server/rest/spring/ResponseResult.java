package org.stjs.server.rest.spring;

import org.springframework.http.HttpStatus;
import org.stjs.shared.rest.spring.RestCallback;
import org.stjs.shared.rest.spring.RestResult;

/**
 *
 * @author sj
 */
public class ResponseResult<T> implements RestResult<T> {
	
	private final HttpStatus httpStatus;
	private final T body;

	public ResponseResult(HttpStatus httpStatus, T body) {
		this.httpStatus = httpStatus;
		this.body = body;
	}

	@Override
	public void then(RestCallback<T> callback) {
		throw new UnsupportedOperationException("Not supported on server-side.");
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public T getBody() {
		return body;
	}
}
