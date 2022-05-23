package idv.ren.security;

import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import idv.ren.sitemesh.SiteMeshFilter;

public class WebSecurityConfig extends AbstractSecurityWebApplicationInitializer{

	@Override
	protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
		// TODO Auto-generated method stub
		insertFilters(servletContext, new SiteMeshFilter());
	}
}
