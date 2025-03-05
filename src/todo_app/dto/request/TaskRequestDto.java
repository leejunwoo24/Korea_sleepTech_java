package todo_app.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Setter
@Getter
@AllArgsConstructor
public class TaskRequestDto {
	private Long Id;
	private String task;
	private String creationDate;
	private String deadLine;
}
