package chapter01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJava {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Beans.class);
		Person p = (Person)ctx.getBean("person");
		Person p2 = (Person)ctx.getBean("person");
		
		System.out.println(p == p2);

	}

}
