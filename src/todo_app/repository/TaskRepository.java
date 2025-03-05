package todo_app.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import todo_app.entity.Task;

public class TaskRepository {
	Set<Task> tasks = new HashSet<Task>();
	private static final TaskRepository instance = new TaskRepository();
	
	private TaskRepository() {
		
	}
	
	public static TaskRepository getInstance() {
		return instance;
	}
	
	public void taskSave(Task task) {
		tasks.add(task);
	}
	
	
	public Optional<Task> taskFindById(Long id){
		return tasks.stream()
			  .filter(setTask -> setTask.getTask().equals(id))
		      .findFirst();
			
	}
	
	public Set<Task> taskFindAll(){
		return tasks;
	}
	
	public void taskDeleteById(Long Id) {
		for(Task task : tasks) {
			if(task.getId().equals(Id)) {
				tasks.remove(task);
			}
		}
	}
}
