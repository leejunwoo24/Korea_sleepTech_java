package todo_app.controller;

import java.util.Set;


import todo_app.dto.request.UserRequestDto;
import todo_app.dto.response.UserResponseDto;
import todo_app.service.UserService;
import todo_app.service.implement.UserServiceImpl;

public class UserController {
	private UserService service;
	
	public UserController() {
		this.service = new UserServiceImpl();
	}
	
	public void registerUser(UserRequestDto dto) {
		service.resisterUser(dto);
	}
	
	public Set<UserResponseDto> getAllUsers(){
		Set<UserResponseDto> Users = service.setAllUser();
		return Users;
	}
	
	public UserResponseDto getUserById(Long id) {
		UserResponseDto user = service.getUserById(id);
		return user;
	}
	
	public void updateUser(long id, UserRequestDto dto) {
		service.updateUser(id, dto);
	}
	
	public void deleteUser(long id) {
		service.deleteUser(id);
	}
}
