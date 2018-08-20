package org.stjs.bridge.vuejs;

import org.stjs.javascript.annotation.SyntheticType;

/**
 *
 * @author sj
 */
@SyntheticType
public class Route {

	public String path;

	public Class<? extends VueComponent> component;

	public String redirect;
	
	public boolean props = false;
}
