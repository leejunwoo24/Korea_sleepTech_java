package todo_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class UserRequestDto {
	private Long id;
	private String userId;
	private String userPassword;
	private String nickName;
	private int age;
	private String gender;
	private String address;
}
