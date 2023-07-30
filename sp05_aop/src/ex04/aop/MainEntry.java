package ex04.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex04/aop/ctx.xml");
		
		IMessageBean msg = ctx.getBean("messageBeanImpl", IMessageBean.class);
		msg.sayHello();
		System.out.println("--------------------------------");
		msg.engHello();
		
		System.out.println("\n\n------------------------------------------");
		
		IBookBean book = (IBookBean) ctx.getBean("bookBeanImpl");
		book.testHello("deabo");
		System.out.println();
		book.korHello();
		
		
		
		
	}

}
