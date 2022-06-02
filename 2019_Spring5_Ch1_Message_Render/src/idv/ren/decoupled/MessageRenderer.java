package idv.ren.decoupled;

public interface MessageRenderer {
	
	public void render();
	
	public void setMessageProvider(MessageProvider provider);
	
	MessageProvider getMessageProvider();

}
