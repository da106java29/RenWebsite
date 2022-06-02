package idv.ren.decoupled;

public class HelloWorldMessageProvider implements MessageProvider{
	
	@Override
	public String getMessage() {
		return "Hello World";
	}
	
	@Override
	public boolean isEmpty() {
		return this.getMessage().isEmpty();
	}

}
