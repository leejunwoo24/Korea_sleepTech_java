package todo_app.service.implement;

import java.util.Set;
import java.util.stream.Collectors;

import todo_app.dto.request.UserRequestDto;
import todo_app.dto.response.UserResponseDto;
import todo_app.entity.User;
import todo_app.repository.UserRepository;
import todo_app.service.UserService;

public class UserServiceImpl implements UserService {
	private UserRepository repository;
	private static long currentId = 1; 
	
	public UserServiceImpl() {
		this.repository = UserRepository.getInstance();
	}
	
	private Long generateId() {
		return currentId++;
	}

	@Override
	public void resisterUser(UserRequestDto dto) {
		User user = new User(
				generateId(), dto.getUserId(), dto.getUserPassword()
				, dto.getNickName(), dto.getAge(), dto.getGender(), 
				dto.getAddress()
				);
		
		repository.userSave(user);
	}

	@Override
	public Set<UserResponseDto> setAllUser() {
		Set<User> users = repository.userFindAll();
		
		Set<UserResponseDto> responseDtos = users.stream()
				.map(user -> new UserResponseDto(user.getUserId(), user.getUserPassword(), user.getNickName(), user.getAge(), user.getGender()))
				.collect(Collectors.toSet());
		return responseDtos;
	}

	@Override
	public UserResponseDto getUserById(Long id) {
		UserResponseDto responseDto = null;
		
		try {
			User user = repository.userFindById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 유저를 조회할 수 없습니다." + id));
			
			responseDto = new UserResponseDto(user.getUserId(), user.getUserPassword(), user.getNickName(), user.getAge(), user.getGender());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return responseDto;
	}

	@Override
	public void updateUser(Long id, UserRequestDto dto) {
		
		try {
			User user = repository.userFindById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 유저를 조회할 수 없습니다." + id));
			
			user.setUserId(dto.getUserId());
			user.setUserPassword(dto.getUserPassword());
			user.setNickName(dto.getNickName());
			user.setAge(dto.getAge());
			user.setGender(dto.getGender());
			
			repository.userSave(user);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public void deleteUser(Long id) {
		try {
			User user = repository.userFindById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 유저를 조회할 수 없습니다." + id));
			
			repository.userDeleteById(user.getUserId());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	
}
