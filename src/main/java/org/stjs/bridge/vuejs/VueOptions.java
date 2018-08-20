package org.stjs.bridge.vuejs;

import org.stjs.javascript.annotation.SyntheticType;
import org.stjs.javascript.functions.Function1;

/**
 *
 * @author sj
 */
@SyntheticType
public class VueOptions {

	public Function1<Function1<Object, Class<? extends VueComponent>>, Object> render;

	public VueRouter router;
	
	public String el;
	
	public String name;
	
	public String template;
}
