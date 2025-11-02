package chapter06_1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chapter06_1.aop.Calculator;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Beans.class);
		Calculator cal = (Calculator)ctx.getBean("calculator");
		
		long result = cal.factorial(10);
		
		System.out.println(result);
		
		System.out.println(cal.getClass().getName());
	}

}
