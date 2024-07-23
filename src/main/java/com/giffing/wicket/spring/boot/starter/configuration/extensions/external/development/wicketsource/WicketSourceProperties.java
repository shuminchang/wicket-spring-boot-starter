package com.giffing.wicket.spring.boot.starter.configuration.extensions.external.development.wicketsource;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = WicketSourceProperties.PROPERTY_PREFIX)
public class WicketSourceProperties {

	public static final String PROPERTY_PREFIX = "wicket.external.development.wicketsource";
	
	private boolean enabled = false;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
