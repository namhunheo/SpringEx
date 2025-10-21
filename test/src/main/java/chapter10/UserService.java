package chapter10;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
	int insert(UserVO vo, MultipartFile profile);
	List<UserVO> userList();
	UserVO login(UserVO vo);
}
