package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springConfig.Client2;

public class MainEntry4 {
   public static void main(String[] args) {
      String config = "classpath:config/appCtx2.xml";
      ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(config);
      Client2 client = (Client2) ctx.getBean("client2");
      Client2 client2 = (Client2) ctx.getBean("client2");
      client.send();
      
      System.out.println(client.hashCode());
      System.out.println(client2.hashCode());
      
      try {
		client.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
   }
}