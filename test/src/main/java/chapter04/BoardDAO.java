package chapter04;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class BoardDAO {
	public void list() {
		System.out.println("목록조회");
	}
}
