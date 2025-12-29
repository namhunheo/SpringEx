package chapter05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member") // 이컨트롤러에 모든 url은 /member로 시작
public class MemberController {

	// url매핑
	@GetMapping("/test.do") // Get방식 url : /test.do
	public String test(HttpServletRequest request, HttpServletResponse res) {
		System.out.println("test 메서드");
		request.setAttribute("name", "홍길동");
		return "test"; // prefix : /WEB-INF/views/, suffix : .jsp -> /WEB-INF/views/test.jsp
	}
	
	// post매핑
	@PostMapping("/test.do") // Post방식 url : /test.do
	public void test2() {
		System.out.println("test 메서드22");
	}
	
	@RequestMapping(value="/request.do") // 모든 요청 처리(제한 필요시, method=RequestMethod.POST)
	public void request() {
		System.out.println("request");
	}
	
	// 파라미터 받는 방법
	// 1. HttpServletRequest
	@GetMapping("/param.do")
	public String param(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("id:"+id);
		return "test";
	}
	// 2. @RequestParam
	// 반드시 파라미터 존재, 이름(변수명==파라미터명)이 일치
	@GetMapping("param2.do")
	public String param2(
			@RequestParam String pwd,
			@RequestParam(
					name="idx", 
					required = false, 
					defaultValue = "") String id
			) {
		System.out.println("id:"+id);
		return "test";
	}
	
	// 3. @ModelAttribute (커맨드객체)
	// 파라미터명과 필드명이 일치하면 자동으로 저장(setter)
	// 자동으로 request 저장
	@GetMapping("/regist.do")
	public String regist(MemberVO vo, HttpServletRequest req, @RequestParam Map map) {
		System.out.println(vo);
		System.out.println(map);
//		req.setAttribute("memberVO", vo);
		return "member/regist";
	}
	
	// 4. @PathVariable
	// 경로변수?
	// /member/view/hong -> hong이 변수로 저장
	@GetMapping("/view/{id}")
	public void view(@PathVariable String id) {
		System.out.println("id:"+id);
	}
	
	@GetMapping("/test2.do")
	public void test22() {
		// void인 경우 경로그대로 해당 jsp를 포워딩
		// /member/test2.do -> member/test2 리턴
	}
	
	// PrintWriter객체로 응답
	@GetMapping("/test3.do")
	public void test3(HttpServletResponse res) throws IOException{
		PrintWriter out = res.getWriter();
		out.print("<h1>test3.jsp</h1>");
	}
	
	// 리다이렉트
	// test4.do -> test3.do
	@GetMapping("/test4.do")
	public String test4() {
		
		return "redirect:/member/test3.do";
	}
	
	// 값저장
	// HttpServletRequest, HttpSession, Model
	@GetMapping("/test5.do")
	public String test5(HttpServletRequest req, HttpSession sess, Model model) {
		// request (하나의 요청)
		req.setAttribute("email", "hong@gmail.com");
		// session (같은 브라우저)
		sess.setAttribute("id", "hong");
		// model (request)
		model.addAttribute("name", "홍길동");
		
		return "member/test5";
	}
	
	// ModelAndView
	@GetMapping("/test6.do")
	public ModelAndView test6() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("addr", "서울시 마포구"); // 값을 저장
		mav.setViewName("member/test6"); // 포워딩할 경로 지정
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
}
