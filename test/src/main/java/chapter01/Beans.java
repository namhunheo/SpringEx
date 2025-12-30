package chapter01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정파일
public class Beans {

	// 빈등록
	@Bean
	public Person person() { // person - 메서드이름(id)
		Person p = new Person();
		p.setName("홍길동");
		return p;
	}
	
	@Bean
	public Person person2() {
		return new Person("김길동", 30);
	}
}
