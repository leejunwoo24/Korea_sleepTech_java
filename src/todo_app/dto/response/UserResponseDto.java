package todo_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class UserResponseDto {
	private String userId;
	private String userPassword;
	private String nickName;
	private int age;
	private String gender;
}
