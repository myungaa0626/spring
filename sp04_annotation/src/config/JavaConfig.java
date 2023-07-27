package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springConfig.Client;

@Configuration // 설정파일임을 알려준다
public class JavaConfig { // XML 기반 설정이 아닌 자바 기반 설정

	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("server!!!");
		return client;

	}

}
