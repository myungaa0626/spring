package ex02.di.message;

public class EmailMessageServiceImpl implements MessageService {

	@Override
	public boolean sendMessage(String msg, String rec) {
		System.out.println("Email Sent to " + rec + " with Message = " + msg);
		return true;
	}

}
