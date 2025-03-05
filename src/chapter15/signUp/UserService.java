package chapter15.signUp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
	// 회원가입
	// 요청값: UserSignUpRequestDto
	// 반환괎: User
	public static User SignUp(UserSignUprequestDto dto) {
		User user = null;
		
		try {
			// 회원 유효성 검증
			// : 비밀번호와 비밀번호 확인 값의 일치 유뮤 검증
			String password = dto.getPassword();
			String passwordcheck = dto.getPasswordCheck();
			
			if(!password.equals(passwordcheck)) {
				// 일치하지 않는 경우 예외 발생
				throw new Error("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			}
			
			Long id = 1L; // 데이터베이스의 역할을 대신!
			Date nowDate = new Date(); // 회원가입
			
			user = User.builder()
					.id(id) // dto에 없는 값을 할당
					.userId(dto.getUserId())
					.password(password)
					.username(dto.getUsername())
					.email(dto.getEmail())
					.phone(dto.getPhone())
					.nickname(dto.getNickname())
					.signUpDate(nowDate)// dto에 없는 값 할당
					.build();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return user;
		
	}
	
	public static void main(String[] args) {
		UserSignUprequestDto dto1 = new UserSignUprequestDto(
				"qwe123", "qwe123!!", "qwe123!!", "이승아", "qwe123@naver.com", "010-1111-2222", "개구리"
				);
		
		User user1 = SignUp(dto1);
		System.out.println(user1.getSignUpDate());
		
		
		UserSignUprequestDto dto2 = new UserSignUprequestDto(
				"qwe123", "qwe123!!", "qwe123!!", "이승아", "qwe123@naver.com", "010-1111-2222", "개구리"
				);
		
		User user2 = SignUp(dto2);
		System.out.println(user2.getSignUpDate());
		
		List<User> userList = null;
		List<UserSignUprequestDto> dtos = new ArrayList<UserSignUprequestDto>();
		dtos.add(dto1);
		dtos.add(dto2);
		
		userList = dtos.stream()
				.map(dto -> SignUp(dto))
				.collect(Collectors.toList());
		
		userList.forEach(System.out::println);
	}
}
