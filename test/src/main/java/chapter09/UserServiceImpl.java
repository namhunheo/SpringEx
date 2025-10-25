package chapter09;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional
	public int insert(UserVO vo, MultipartFile profile) {
		// 첨부파일 처리 (새로운파일명, 저장, vo에 set)
		if (!profile.isEmpty()) { // 사용자가 파일첨부했으면
			// 원본파일명
			String org = profile.getOriginalFilename();
			// 새로운파일명 = xxxxx.확장자
			String ext = org.substring(org.lastIndexOf(".")); // 확장자
			String real = System.nanoTime()+ext; // 실제저장될 파일명
			
			try {
				profile.transferTo(new File("D:/file_repo/"+real));
			} catch (Exception e) {
				e.printStackTrace();
			}
			// vo에 set
			vo.setProfile_org(org);
			vo.setProfile_real(real);
		}
		
		// user테이블에 저장
		System.out.println("insert전:"+vo.getUserno());
		int r = userMapper.insert(vo);
		System.out.println("insert후:"+vo.getUserno());
		// user의 pk로 hobby테이블에 저장
		if (vo.getHobby() != null) {
			for (String hobby : vo.getHobby()) {
				Map<String, Object> map = new HashMap<>();
				map.put("userno", vo.getUserno());
				map.put("name", hobby);
				userMapper.insertHobby(map);
			}
		}
		return r;
	}

}
