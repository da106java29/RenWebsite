package idv.ren.decoupled;

public class StandardOutMessageRenderer implements MessageRenderer {

	private MessageProvider messageProvider;

	@Override
	public void render() {
		if (messageProvider.isEmpty()) {
			throw new RuntimeException("You Must set the Property message Provider of class : "
					+ StandardOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}

}
