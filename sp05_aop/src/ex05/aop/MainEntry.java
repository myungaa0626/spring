package ex05.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainEntry {
	public static void main(String[] args) {

		ApplicationContext ctx = 
				new GenericXmlApplicationContext("ex05/aop/appCtx.xml");
		
		ICalc proxyCal = (ICalc) ctx.getBean("proxy");
		
		System.out.println(proxyCal.add(5, 3));
		System.out.println(proxyCal.sub(15, 5, 3));
		System.out.println(proxyCal.mul(10, 3));
		System.out.println("-----------------------------");
		
	}
}
