package chapter15.signUp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

// 사용자 가입 요청 Dto

// cf) Data Transfer Object
// : 데이터 전송 객체
// - 프로세스 간에 데이터를 전달하는 객체를 의미
// - 계층간 데이터를 전송을 위해 사용하는 객체

@ToString
@AllArgsConstructor
@Data
public class UserSignUprequestDto {
	private String userId;
	private String password;
	private String passwordCheck; // 비밀번호 확인
	private String username;
	private String email;
	private String phone;
	private String nickname;
}
