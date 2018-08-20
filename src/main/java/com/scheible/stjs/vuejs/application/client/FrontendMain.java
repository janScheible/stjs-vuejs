package com.scheible.stjs.vuejs.application.client;

import com.scheible.stjs.vuejs.application.client.component.CustomComponent;
import org.stjs.bridge.vuejs.Route;
import org.stjs.bridge.vuejs.Vue;
import org.stjs.bridge.vuejs.VueOptions;
import org.stjs.bridge.vuejs.VueRouter;
import org.stjs.bridge.vuejs.VueRouterOptions;
import static org.stjs.javascript.JSCollections.$array;

/**
 *
 * @author sj
 */
public class FrontendMain {

	public static void main(String[] args) {
		new Vue(new VueOptions() {{
			render = h -> h.$invoke(App.class);
			el = "#app";
			router = new VueRouter(new VueRouterOptions() {{
				routes = $array(
					new Route() {{
						path = "*";
						redirect = "/component/talking";
					}},
					new Route() {{
						path = "/component/:superPower";
						component = CustomComponent.class;
						props = true;
					}}
				);
			}});
		}});
	}
}
