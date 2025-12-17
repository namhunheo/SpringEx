package chapter02;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;
	public void setMemberDao(MemberDAO dao) {
		this.memberDao = dao;
	}
	
	@Override
	public void regist() {
		// 예전) MemberDAO 객체 생성(new)해서 addMember() 메소드 호출
		// 스프링) 주입받은 MemberDAO 객체로 메소드 호출
		memberDao.addMember();
	}

}
