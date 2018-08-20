package org.stjs.shared.rest.spring;

import org.stjs.javascript.annotation.STJSBridge;

/**
 *
 * @author sj
 */
@STJSBridge
public class RestClientFactory {
	
	public static native <T extends RestService> T get(Class<T> restServiceClass);
}
