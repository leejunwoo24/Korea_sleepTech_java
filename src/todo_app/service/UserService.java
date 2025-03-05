package todo_app.service;

import java.util.Set;

import todo_app.dto.request.UserRequestDto;
import todo_app.dto.response.UserResponseDto;

public interface UserService {
	public void resisterUser(UserRequestDto dto);
	public Set<UserResponseDto> setAllUser();
	UserResponseDto getUserById(Long id);
	void updateUser(Long id, UserRequestDto dto);
	void deleteUser(Long id);
}
