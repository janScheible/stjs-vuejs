package org.stjs.shared.rest.spring;

/**
 *
 * @author sj
 */
public interface RestResult<T> {
	
	void then(RestCallback<T> callback);
}
