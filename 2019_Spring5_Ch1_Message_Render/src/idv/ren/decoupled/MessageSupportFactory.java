package idv.ren.decoupled;

import java.io.IOException;
import java.util.Properties;

public class MessageSupportFactory {
	
	private static MessageSupportFactory instance;
	
	private Properties props;
	
	private MessageRenderer render;
	
	private MessageProvider provider;
	
	private MessageSupportFactory() {
		props = new Properties();
		
		try {
			props.load(this.getClass().getResourceAsStream("/msf.properties"));
			
			String renderClass = props.getProperty("render.class");
			String providerClass = props.getProperty("provider.class");
			
			render = (MessageRenderer) Class.forName(renderClass).newInstance();
			provider = (MessageProvider) Class.forName(providerClass).newInstance();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static {
		instance = new MessageSupportFactory();
	}
	
	public static MessageSupportFactory getInstance() {
		return instance;
	}
	
	public MessageRenderer getMessageRenderer() {
		return render;
	}
	
	public MessageProvider getMessageProvider() {
		return provider;
	}

}
