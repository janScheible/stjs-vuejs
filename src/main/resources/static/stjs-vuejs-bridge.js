/**
 * Transform the st-js class defintion to a object literal expected by Vue.js.
 */
(function () {
	const oldStjsExtend = stjs.extend;
	stjs.extend = function(_constructor, _super, _implements, _initializer, _typeDescription, _annotations) {
		// NOTE Detect the @Component annotation (inheriting from VueComponent is optional).
		if(_annotations && _annotations._ && _annotations._.Component) {
			const data = {

			};
			const props = [];
			const methods = {};

			const vueOptions = {
				name: _annotations._.Component.name,
				template: _annotations._.Component.template,
				data: function() {
					return data;
				},
				props: props,
				methods: methods							
			};						

			const initialValues = {};
			if(_initializer) {
				_initializer(_constructor, initialValues);
			}

			for (var key in initialValues) {
				if (initialValues.hasOwnProperty(key)) {
					const annotations = _annotations[key];
					if(annotations && annotations.Prop) {
						props.push(key);
					} else if(_super.$annotations && _super.$annotations[key] && _super.$annotations[key].Lifecycle) {
						vueOptions[key] = initialValues[key];
					} else if(typeof  initialValues[key] === 'function') {
						methods[key] = initialValues[key];
					} else {
						data[key] = initialValues[key];
					}
				}
			}

			return vueOptions;
		} else {
			return oldStjsExtend(_constructor, _super, _implements, _initializer, _typeDescription, _annotations);
		}
   };
}());
