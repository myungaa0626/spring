package ex02.di.message;

public class TwitterMessageServiceImpl implements MessageService {

	@Override
	public boolean sendMessage(String msg, String rec) {
		System.out.println("Twitter message Sent to " + rec + " with Message = " + msg);
		return true;
	}

}
