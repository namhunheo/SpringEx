package chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BoardServiceImpl2 implements BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public void list() {
		boardDao.list();
	}

}
