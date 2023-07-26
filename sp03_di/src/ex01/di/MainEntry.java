package ex01.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ex01/di/playerCtx.xml");

		PlayerImpl p = context.getBean("player", PlayerImpl.class);

		String[] sportsName = { "축구", "농구", "컬링" };
		Object[] className = { context.getBean("soccer"), context.getBean("basketBall"), context.getBean("curling") };

		for (int i = 0; i < sportsName.length; i++) {
			System.out.println(sportsName[i]);
//			System.out.println(className[i]);
			p.input();
			p.info();
		}

	}

}
