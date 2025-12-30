package chapter01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		// 설정파일(XML) 읽어들임
		// 빈(객체)생성, 등록(컨테이너에 저장)
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("chapter01/beans.xml");
		
		// 객체 사용
		Person p = (Person)ctx.getBean("person");
		System.out.println(p);
		
		// 싱글톤
		Person p2 = ctx.getBean("person", Person.class);
		System.out.println(p == p2);
		
//		Person p3 = new Person();
		// -> 스프링이 제어 (IoC)
		
		Person p3 = (Person)ctx.getBean("person2");
		System.out.println(p3);
		
	}

}
