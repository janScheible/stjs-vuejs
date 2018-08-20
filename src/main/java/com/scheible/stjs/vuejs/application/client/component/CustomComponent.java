package com.scheible.stjs.vuejs.application.client.component;

import com.scheible.stjs.vuejs.application.shared.TestRestService;
import static org.stjs.javascript.Global.alert;
import org.stjs.bridge.vuejs.VueComponent;
import org.stjs.bridge.vuejs.annotation.Component;
import org.stjs.bridge.vuejs.annotation.Prop;
import org.stjs.shared.rest.spring.RestClientFactory;

/**
 *
 * @author sj
 */
@Component(
	name = "custom-component",
	template = ""
			+ "<div style=\"background-color: orange; font-family: Times, serif;\" v-on:click=\"onClick\">"
			+ "    <span>{{heroName}}</span> <span>(super power: {{superPower}})</span>"
			+ "</div>"
)
public class CustomComponent extends VueComponent {
	
	String heroName = "loading...";
	
	@Prop
	String superPower;
	
	@Override
	public void created() {
		RestClientFactory.get(TestRestService.class).getResult()
				.then((status, body) -> heroName = body.getName());
	}
	
	void onClick() {
		$emit("hero-clicked", heroName);
		alert("You clicked the hero '" + heroName + "'!");
	}	
}
