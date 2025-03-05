package todo_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class User {
	private Long id;
	private String userId;
	private String userPassword;
	private String nickName;
	private int age;
	private String gender;
	private String address;
}
