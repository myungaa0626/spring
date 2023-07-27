package springConfig;

public class Client2 {

	private String host;

	public void setHost(String host) { // DI
		this.host = host;
	}

	public void connect() throws Exception {
		System.out.println("Client2.connect() 실행 - 초기화 메소드");

	}

	public void send() {
		System.out.println("Client2.send() call:" + host);

	}

	public void close() throws Exception {
		System.out.println("Client2.close() call - 소멸 메소드");

	}

}
