package ex03.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 5
public class MainEntry {
	public static void main(String[] args) {

		String config = "classpath:ex03/aop/appCtx.xml";

		ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

		ICalc proxy = ctx.getBean("proxy", ICalc.class);

		// Proxy 만들고 객체를 넘긴다. 필요한 객체 생성 작업은 XML 설정했음
		System.out.println(proxy.add(20, 30));
		System.out.println(proxy.sub(20, 30));
		System.out.println(proxy.mul(20, 30));

	}
}
