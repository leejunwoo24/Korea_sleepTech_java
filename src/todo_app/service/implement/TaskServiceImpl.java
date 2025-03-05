package todo_app.service.implement;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import phr_solution.dto.response.RecordResponseDto;
import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.response.TaskResponseDto;
import todo_app.entity.Task;
import todo_app.entity.User;
import todo_app.repository.TaskRepository;
import todo_app.repository.UserRepository;
import todo_app.service.TaskService;

public class TaskServiceImpl implements TaskService{
	private final TaskRepository taskRepository;
	private final UserRepository userRepository;
	
	private static long currentId = 1;
	
	public TaskServiceImpl() {
		this.taskRepository = TaskRepository.getInstance();
		this.userRepository = UserRepository.getInstance();
	}
	
	private Long generatedRecordId() {
		return currentId++;
	}

	
	@Override
	public void createTask(TaskRequestDto dto) {
		try {
		
			Task task = new Task(generatedRecordId(), dto.getTask(), dto.getCreationDate(), dto.getDeadLine());
			
			taskRepository.taskSave(task);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Set<TaskResponseDto> getAllTasks() {
		Set<TaskResponseDto> responseDtos = null;
		
		try {
			Set<Task> tasks = taskRepository.taskFindAll();
			
			responseDtos = tasks.stream()
					.map(task -> new TaskResponseDto(task.getTask(), task.getCreationDate(), task.getDeadLine()))
					.collect(Collectors.toSet());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return responseDtos;
	}

	@Override
	public Set<TaskResponseDto> filterTasksByTask(String task) {
		Set<TaskResponseDto> responseDtos = null; 
		
		try {
		Set<Task> tasks = taskRepository.taskFindAll();
			
		responseDtos = tasks.stream()
				.filter(setTask -> setTask.getTask().contains(task))
				.map(filteredTask -> new TaskResponseDto(
						filteredTask.getTask(), filteredTask.getCreationDate(), filteredTask.getDeadLine()))
				.collect(Collectors.toSet());
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return responseDtos;
	}

	@Override
	public void updateTasks(Long id, TaskRequestDto dto) {
		
		try {
			Task findTask = taskRepository.taskFindById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 아이디는 존재하지 않습니다." + id));
			
			findTask.setTask(dto.getTask());
			findTask.setCreationDate(dto.getCreationDate());
			findTask.setDeadLine(dto.getDeadLine());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void deleteTask(Long id) {
		try {
			Task task = taskRepository.taskFindById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 ID의 Todo는 존재하지 않습니다. ID: " + id));
		
		taskRepository.taskDeleteById(task.getId());
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
