package chapter10;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 로그인체크
		HttpSession sess = request.getSession();
		UserVO vo = (UserVO)sess.getAttribute("loginSess");
		if (vo == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인후 이용가능합니다.');");
			out.print("location.href='/test/user';");
			out.print("</script>");
			return false; // 못가
		}
		return true; // 가던길 가
	}
}
