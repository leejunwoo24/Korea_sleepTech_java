package todo_app.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Task {
	private Long Id;
	private String task;
	private String creationDate;
	private String deadLine;
}
