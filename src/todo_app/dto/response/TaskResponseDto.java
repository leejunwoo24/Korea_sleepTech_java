package todo_app.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class TaskResponseDto {
	private String task;
	private String creationDate;
	private String deadLine;
}
