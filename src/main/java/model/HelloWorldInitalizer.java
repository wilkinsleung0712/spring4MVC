package model;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HelloWorldInitalizer implements WebApplicationInitializer {

	/*
	 *  we are using the front-controller DispatherServler, 
	 *  assigning the mapping (url-pattern in xml) and instead of providing the path to 
	 *  spring configuration file(spring-servlet.xml) , 
	 *  here we are registering the Configuration Class. Overall, 
	 *  we are doing the same thing, just the approach is different.
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
	 */
	public void onStartup(ServletContext container) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(HelloWorldConfiguration.class);
        ctx.setServletContext(container);
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
	}

}
