package todo_app.controller;

import java.util.Set;

import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.response.TaskResponseDto;
import todo_app.service.TaskService;
import todo_app.service.implement.TaskServiceImpl;

public class TaskController {
	private TaskService service;
	
	public TaskController() {
		this.service = new TaskServiceImpl();
	}
	
	public void createTask(TaskRequestDto dto) {
		service.createTask(dto);
	}
	
	public Set<TaskResponseDto> getAllTasks(){
		return service.getAllTasks();
	}
	
	public Set<TaskResponseDto> filterTasksByTask(String task){
		return service.filterTasksByTask(task);
	}
	
	public void updateTask(Long Id, TaskRequestDto dto) {
		service.updateTasks(Id, dto);
	}
	
	public void deleteTask(long id) {
		service.deleteTask(id);
	}
	
}
