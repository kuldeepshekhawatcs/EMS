package com.ems;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration  extends WebMvcConfigurerAdapter{
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	 /* @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addRedirectViewController("/", "/static/index.html");
	    }*/
	  
}
