package chapter11;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	int insert(UserVO vo);
	int insertHobby(Map map);
	List<UserVO> userList();
	UserVO login(UserVO vo);
}
