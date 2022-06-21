package idv.ren.container;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.lang.Nullable;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

public abstract class PuzzContainerInitializer implements WebApplicationInitializer{
	
	private static final String MSG = "idv.ren.PuzzContainer";
	protected final Log logger = LogFactory.getLog(getClass());
	
	private AopUtils aopUtil;
	
    static {
    	
    }
    
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		
		WebApplicationContext rootAppContext = createRootApplicationContext();
		
		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
		listener.setContextInitializers(getRootApplicationContextInitializers());
		servletContext.addListener(listener);
		
		logger.info("Just Test New Framework");
		
	}

	@Nullable
	protected abstract WebApplicationContext createRootApplicationContext();
	
	@Nullable
	protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
		return null;
	}
}
