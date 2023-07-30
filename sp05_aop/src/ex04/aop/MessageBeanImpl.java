package ex04.aop;

public class MessageBeanImpl implements IMessageBean {

	@Override
	public void sayHello() {
		System.out.println("public void sayHello() call!!!");

	}

	@Override
	public void engHello() {
		System.out.println("public void engHello() call!!!");

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
