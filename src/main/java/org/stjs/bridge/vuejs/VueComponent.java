package org.stjs.bridge.vuejs;

import org.stjs.bridge.vuejs.annotation.Lifecycle;

/**
 *
 * @author sj
 */
public abstract class VueComponent {

	@Lifecycle
	public void beforeCreate() {

	}

	@Lifecycle
	public void created() {

	}

	@Lifecycle
	public void beforeMount() {

	}

	@Lifecycle
	public void mounted() {

	}

	@Lifecycle
	public void beforeUpdate() {

	}

	@Lifecycle
	public void updated() {

	}

	@Lifecycle
	public void beforeDestroy() {

	}

	@Lifecycle
	public void destroyed() {

	}
	
	public void $emit(String eventName, Object data) {
	}
}
