package quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {

	public static void main(String[] args) {

		ApplicationContext context = 
				new ClassPathXmlApplicationContext("quiz/appCtx.xml");


		IMessageKorImpl kor = context.getBean("hellokor", IMessageKorImpl.class);
		IMessageEngImpl eng = context.getBean("helloeng", IMessageEngImpl.class);

		kor.sayHello();
		eng.sayHello();

	}

}