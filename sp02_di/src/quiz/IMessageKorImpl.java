package quiz;

public class IMessageKorImpl implements IMessage {

	private String hello;

	public IMessageKorImpl(String hello) {
		this.hello = hello;
	}

	@Override
	public void sayHello() {
		System.out.println(this.hello);

	}

}
