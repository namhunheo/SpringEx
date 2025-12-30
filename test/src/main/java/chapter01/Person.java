package chapter01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	private String name;
	private int age;
	
	public Person() {
		System.out.println("생성자 호출");
	}
}
