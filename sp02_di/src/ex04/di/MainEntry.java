package ex04.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ex04.di.IRecordViewImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class MainEntry {

	public static void main(String[] args) {
		
		
		ApplicationContext context 
				=   new ClassPathXmlApplicationContext("ex04/di/appCtx.xml");
//					new ClassPathXmlApplicationContext("appCtx.xml");
//					new ClassPathXmlApplicationContext(new String[]{"appCtx.xml","test.xml"});
		
		IRecordViewImpl view = context.getBean("view", IRecordViewImpl.class);
//		IRecordViewImpl view = (IRecordViewImpl)context.getBean("view");
		view.print();

	}

}
