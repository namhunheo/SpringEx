package chapter02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
	//MemberDAO 빈 등록
	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAO();
	}
	
	//MemberService 빈 등록
	@Bean
	public MemberService memberService() {
		MemberServiceImp service = new MemberServiceImp();
		service.setMemberDao(memberDAO()); // 의존성 주입
		return service;
	}
}
