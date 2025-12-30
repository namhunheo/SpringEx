package chapter03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
	
	@Bean
	public MemberDAO aaa() {
		return new MemberDAOImpl();
	}
	
	@Bean
	public MemberDAOImpl2 bbb() {
		return new MemberDAOImpl2();
	}
	
	@Bean
	public MemberServiceImpl memberService() {
		MemberServiceImpl memberService = new MemberServiceImpl();
		// ¡÷¿‘
//		memberService.setDao(memberDao());
		return memberService;
	}
}
