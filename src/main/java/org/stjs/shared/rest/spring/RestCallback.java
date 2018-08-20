package org.stjs.shared.rest.spring;

import org.stjs.javascript.annotation.JavascriptFunction;

/**
 *
 * @author sj
 */
@JavascriptFunction
@FunctionalInterface
public interface RestCallback<T> {
	
	void on(int httpStatusCode, T body);
}
