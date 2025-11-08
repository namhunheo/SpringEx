package chapter06;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("chapter06/beans.xml");
//		Calculator cal = (Calculator)ctx.getBean("calcTarget");
		Calculator cal = (Calculator)ctx.getBean("proxyCal");
		cal.add(100, 20);
	}

}
