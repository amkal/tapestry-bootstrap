package com.trsvax.bootstrap.components;

import java.util.List;

import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@SuppressWarnings("unused")
public class MediaGrid<T> implements ClientElement {
	
	@Parameter(autoconnect=true,required=true)
	@Property
	private List<?> source;
	
	@Parameter
	@Property
	private Object value;
	
	@Parameter(value="resources.id")
	@Property
	private String parameterName;
	
	@Parameter
	@Property
	private Integer index;
	
	@Inject
	@Property
	private ComponentResources resources;
	
	@Inject
	private JavaScriptSupport javaScriptSupport;
	
	private String clientId;
	
	@Component(parameters={"value=value","index=index"})
	private Loop<T> loop;

	public String getClientId() {
		if ( clientId == null ) {
			clientId = javaScriptSupport.allocateClientId(resources);
		}
		return clientId;
	}

}
