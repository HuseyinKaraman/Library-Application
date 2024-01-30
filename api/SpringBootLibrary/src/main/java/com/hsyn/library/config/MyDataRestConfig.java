package com.hsyn.library.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.hsyn.library.entity.Book;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	
	private String theAllowedOrigins = "http://localhost:8080";
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,CorsRegistry cors) {
		
			HttpMethod[] theUnsupportedActions = {HttpMethod.DELETE,HttpMethod.POST,HttpMethod.PUT,HttpMethod.PATCH}; 
			
			
			config.exposeIdsFor(Book.class);
			
			
			disableHttpMethod(Book.class,config,theUnsupportedActions);
			
		/* Configure CORS Mapping */
		cors.addMapping(config.getBasePath()+"/**")
			.allowedOrigins(theAllowedOrigins);
	}

	private void disableHttpMethod(Class theClass, RepositoryRestConfiguration config,
			HttpMethod[] theUnsupportedActions) {
		
		config.getExposureConfiguration()
			   .forDomainType(theClass)
			   .withItemExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedActions))
			   .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(theUnsupportedActions));
		
	}
	
}
