package chapter09;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
	int insert(UserVO vo, MultipartFile profile);
}
