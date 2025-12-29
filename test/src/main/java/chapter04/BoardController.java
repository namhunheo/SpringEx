package chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class BoardController {
	@Autowired // BoardSerivce 주입
	private BoardService boardService;
	
	public void list() {
		boardService.list();
	}
}
