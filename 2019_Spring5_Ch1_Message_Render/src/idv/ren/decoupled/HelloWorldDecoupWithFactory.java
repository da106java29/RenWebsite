package idv.ren.decoupled;

public class HelloWorldDecoupWithFactory {
	
	public static void main(String[] args) {
		MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
		
		MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
		
		mr.setMessageProvider(mp);
		mr.render();
	}

}
