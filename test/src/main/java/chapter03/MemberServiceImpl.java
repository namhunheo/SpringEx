package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberServiceImpl implements MemberService {

	// 주입(주입받는객체, 주입되는개체도 둘다 빈으로 등록)
	// 자동으로 주입
	@Autowired // 타입기준(타입일치, 하위관계)
	@Qualifier("bbb") // 빈이름 지정
	private MemberDAO dao;

	@Override
	public void regist() {
		dao.addMember();
	}

}
