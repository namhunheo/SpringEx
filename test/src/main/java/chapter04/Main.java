package chapter04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(Beans.class);
		// 자동으로 빈등록 시 클래스명의 첫자를 소문자로 변경
		// BoardService -> boardService
		BoardController service = ctx.getBean("boardController", BoardController.class);
		service.list();
	}

}
