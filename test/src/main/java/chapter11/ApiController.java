package chapter11;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import chapter11.UserVO;

@RestController
public class ApiController {
	
	@GetMapping("api/index")
	public String index() {
		return "api";
	}
	
	@GetMapping("api/user")
	public UserVO user() {
		UserVO vo = new UserVO();
		vo.setId("hong");
		vo.setAge(20);
		vo.setGender(2);
		
		return vo;
	}
	
	@GetMapping("/api/index2")
	public UserVO index2(UserVO vo) {
		return vo;
	}
	
	@Autowired
	private UserMapper mapper;
	
	@GetMapping("/api/userList")
	public List<UserVO> userList() {
		return mapper.userList();
	}
	
	@PostMapping("/api/userLogin")
	public UserVO userLogin(UserVO vo) {
		return mapper.login(vo);
	}
	
	//파라미터가 JSON으로 전송되는 경우 {"id":"hong", "password":"1234"}
	@PostMapping("/api/userLogin2")
	public UserVO userLogin2(@RequestBody UserVO vo) {
		return mapper.login(vo);
	}
	
	//  ResponseEntity
	// http 응답코드 제어
	@GetMapping("/api/index3")
	public ResponseEntity<UserVO> index3(){
		UserVO vo = new UserVO();
		vo.setId("hong");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vo);
	}
}
