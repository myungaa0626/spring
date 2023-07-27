package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springConfig.Client;
import springConfig.Client2;

public class MainEntry3 {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = new GenericXmlApplicationContext("config/appCtx.xml");

		Client client = (Client) ctx.getBean("client");

		Client2 client2 = (Client2) ctx.getBean("client2");

		client.send();

		client2.send();

		client.afterPropertiesSet();

		client2.connect();

		client2.close();
		
		
	    System.out.println(client.hashCode());
	    System.out.println(client2.hashCode());


	}
}
