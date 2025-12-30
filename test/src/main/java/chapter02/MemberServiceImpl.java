package chapter02;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDao;
	public void setMemberDao(MemberDAO dao) {
		this.memberDao = dao;
	}
	
	@Override
	public void regist() {
		// 예전) MemberDAO객체 생성(new)해서 addMember()메서드 호출
//		MemberDAO memberDao = new MemberDAO();
		
		// 스프링) 주입받은 MemberDAO객체로 메서드 호출
		memberDao.addMember();
	}

}
