package com.scheible.stjs.vuejs.application.client;

import org.stjs.bridge.vuejs.annotation.Component;

/**
 *
 * @author sj
 */
@Component(
	name = "app",
	template = ""
			+ "<div class=\"container mx-auto p-2\">"
			+ "    <router-view></router-view>"
			+ "</div>"
)
public class App {

}
