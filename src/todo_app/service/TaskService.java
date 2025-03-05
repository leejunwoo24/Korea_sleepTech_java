package todo_app.service;

import java.util.Set;

import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.response.TaskResponseDto;

public interface TaskService {
	void createTask(TaskRequestDto dto);
	Set<TaskResponseDto> getAllTasks();
	Set<TaskResponseDto> filterTasksByTask(String task);
	void updateTasks(Long id, TaskRequestDto dto);
	void deleteTask(Long id);
	
}
