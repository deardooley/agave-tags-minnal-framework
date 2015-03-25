package org.iplantc.service.tags;

import org.minnal.core.Application;
import org.minnal.jpa.JPAPlugin;
import org.minnal.jpa.OpenSessionInViewFilter;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;

public class TagsApplication extends Application<TagsConfiguration> {

	@Override
	protected void registerPlugins() {
		registerPlugin(new JPAPlugin());
	}

	@Override
	protected void addFilters() {
		addFilter(new OpenSessionInViewFilter(getConfiguration().getDatabaseConfiguration()));
	}

	@Override
	protected void defineRoutes() {
	}

	@Override
	protected void defineResources() {
	}
}
