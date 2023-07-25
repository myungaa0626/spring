package ex05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {

	public static void main(String[] args) {


		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("ex05/di/memberCtx.xml");

		MemberDAO dao = ctx.getBean("dao", MemberDAO.class);

		dao.insert();

	}

}
