package ex01.annot.java;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig { // xml 설정파일 역할 ex) ctx.xml, appCtx.xml,....

	@Bean
	public MyCats cat1() { // MyCats cat1 = new MyCats(); <bean id = "cat1" class = ex01.annot.java.MyCats"
							// />
		ArrayList<String> hobbys = new ArrayList();
		hobbys.add("뒹굴기");
		hobbys.add("앞발들기");

		MyCats myCats = new MyCats("냥이", 12, hobbys);
		myCats.setWeight(3.0);
		myCats.setColor("black");

		return myCats;
	}

	@Bean
	public MyCats cat2() {
		ArrayList<String> hobbys = new ArrayList();
		hobbys.add("윙크하기");
		hobbys.add("잠자기");

		MyCats myCats = new MyCats("나비야", 3, hobbys);
		myCats.setWeight(2.3);
		myCats.setColor("white");

		return myCats;

	}

	@Bean
	public Cats catsInfo() {
		Cats cats = new Cats(this.cat1()); // ref ="employee"
		return cats;

	}

}
