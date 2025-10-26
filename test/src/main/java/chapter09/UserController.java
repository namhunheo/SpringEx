package chapter09;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // 모든 필드 자동 주입
public class UserController {
	
	private final UserService userService;

	// 등록폼
	@GetMapping("/user/insert")
	public String insert() {
		
		return "user/insert";
	}
	
	// 등록처리
	@PostMapping("/user/insert")
	public String insert(UserVO vo, 
			@RequestParam MultipartFile profile,
			HttpServletResponse res,
			Model model,
			RedirectAttributes ra,
			HttpServletRequest req
			) throws Exception {
		
		System.out.println("vo:"+vo);
		int r = userService.insert(vo, profile);
		
		if (r > 0) {
//			model.addAttribute("msg", "회원가입되었습니다.");
//			model.addAttribute("cmd", "move");
//			model.addAttribute("url", "insert");
			ra.addFlashAttribute("msg", "회원가입되었습니다."); // 일회성
		} else {
//			model.addAttribute("msg", "회원가입오류");
//			model.addAttribute("cmd", "back");
			ra.addFlashAttribute("msg", "회원가입오류.");
		}
		
		//return "common/return";
		
//		// 서블릿으로 응답
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.print("<script>");
//		if (r > 0) { // 정상적으로 등록
//			out.print("alert('회원가입되었습니다.');");
//			out.print("location.href='insert';");
//		} else {
//			out.print("alert('회원가입오류');");
//			out.print("history.back();");
//		}
//		out.print("</script>");
		
		
		return "redirect:insert"; // 등록페이지로 리다이렉트
	}
}
