package todo_app;

import java.util.Scanner;
import java.util.Set;

import todo_app.controller.TaskController;
import todo_app.controller.UserController;
import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.request.UserRequestDto;
import todo_app.dto.response.TaskResponseDto;
import todo_app.dto.response.UserResponseDto;

/*
 * === Todo(할 일) 프로그램 ===
 * 
 * 1. 프로젝트 개요
 *  : 할 일(Todo)에 대한 콘솔 기반 응용 프로그램
 *  두 도메인(사용자, 할 일)을 대상으로 회원가입, 로그인, 로그아웃, 회원 탈퇴 기능
 *  	할 일에 대한 추가, 조회(단건/전체), 수정, 삭제 기능을 제공
 *  
 *  +) 할일의 활성화 여부(할일 완료 여부)에 따른 필터링
 *  
 *  2. 주요 기능 및 비즈니스 로직
 *    : 회원 정보 관리 - CR(단건)D (+ 로그인, 로그아웃)
 *    : 할일 기록 관리 - CR(단건/전체)UD (+ 필터링)
 *    
 *  3. 비즈니스 로직 구조
 * */

public class App {
	private static final Scanner sc = new Scanner(System.in);
	private static final UserController userController = new UserController();
	private static final TaskController taskController = new TaskController();
	
	
	private static void displayMenu() {
		System.out.println("[메뉴선택]");
		

		System.out.println("1. 회원 가입");
		System.out.println("2. 회원 정보 전체 조회");
		System.out.println("3. 회원 정보 단건 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 정보 삭제");
		
		System.out.println("6. 할일 추가");
		System.out.println("7. 할일 기록 조회");
		System.out.println("8. 할일 기록 필터링");
		System.out.println("9. 할일 기록 수정");
		System.out.println("10. 할일 기록 삭제");
		
		System.out.println("0. 프로그램 종료");
		System.out.println("메뉴를 선택하세요: ");
	}
	
	private static int getChoice() {
		while(!sc.hasNextInt()) {
			System.out.println("숫자를 입력해주세요");
			sc.nextLine();
		}
		
		int choice = sc.nextInt();
		sc.nextLine();//버퍼처리
		return choice;
	}
	
	private static String getInput(String prompt) {
		System.out.println(prompt + ":");
		return sc.nextLine().trim();
	}
	
	private static long getIdInput() {
		String input = getInput("ID를 입력하세요");
		return Long.parseLong(input);
	}
	
	private static UserRequestDto createUserRequest() {
		UserRequestDto dto = null;
		try {
			String userId = getInput("회원 아이디를 입력하세요");
			String userPassword = getInput("회원 비밀번호를 입력하세요");
			String nickName = getInput("회원 닉네임을 입력하세요");
			int age = Integer.parseInt(getInput("회원 나이를 입력하세요"));
			String gender = getInput("회원 성별을 입력하세요(남/여)");
			String address = getInput("회원 주소를 입력하세요");
			
			dto = new UserRequestDto(null, userId, userPassword, nickName, age, gender, address);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return dto;
	}
	
	private static TaskRequestDto createTaskRequest() {
		TaskRequestDto dto = null;
		
		try {
			
			String task = getInput("해야할 일을 입력하세요");
			String creationDate = getInput("시작일을 입력하세요(ex: 2025-03-04)");
			String deadLine = getInput("종료일을 입력하세요(ex: 2025-03-25)");
			
			dto = new TaskRequestDto( null ,task, creationDate, deadLine);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return dto;
	}
	
	private static boolean processChoice(int choice) {
		switch(choice) {
		
		case 1: {
			UserRequestDto requestDto = createUserRequest();
			userController.registerUser(requestDto);
			break;
		}
	    case 2: {
	    	Set<UserResponseDto> users = userController.getAllUsers();
	    	if(users.isEmpty()) {
	    		System.out.println("회원 정보가 없습니다.");
	    	} else {
	    		users.forEach(System.out::println);
	    	}
	    	break;
		}
	    
	    case 3:
	    {
	    	long id = getIdInput();
	    	UserResponseDto user = userController.getUserById(id);
	    	if(user == null) {
	    		System.out.println("해당되는 ID의 회원이 없습니다.");
	    	} else {
	    		System.out.println(user);
	    	}
	    	break;
	    }
	    
	    case 4: {
	    	long id = getIdInput();
	    	UserRequestDto requestDto = createUserRequest();
	    	userController.updateUser(id, requestDto);
	    	break;
	    }
	    
	    case 5:{
	    	long id = getIdInput();
	    	userController.deleteUser(id);
	    	
	    	break;
	    }
	    
	    case 6:{
	    	TaskRequestDto requestDto = createTaskRequest();
	    	taskController.createTask(requestDto);
	    	break;
	    }
	    
	    case 7:{
	    Set<TaskResponseDto> tasks = taskController.getAllTasks();
	    if(tasks.isEmpty()) {
	    	System.out.println("할일 작성 기록이 없습니다.");
	    } else {
	    	tasks.forEach(System.out::println);
	    }
	    break;
	    }
	    
	    case 8: {
	    	String taskFilter = getInput("필터 조건 (할 일): ");
	    	Set<TaskResponseDto> filteredTasks = taskController.filterTasksByTask(taskFilter);
	    	if(filteredTasks.isEmpty()) {
	    		System.out.println("검색 결과를 찾을 수 없습니다.");
	    	} else {
	    		filteredTasks.forEach(System.out::println);
	    	}
	    	break;
	    }
	    
	    case 9: {
	    	Long id = getIdInput();
	    	TaskRequestDto requestDto = createTaskRequest();
	    	taskController.updateTask(id, requestDto);
	    	break;
	    }
	    
	    case 10:{
	    	long id = getIdInput();
	    	taskController.deleteTask(id);
	    	break;
	    }
	    
	    case 0:{
	    	System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
	    	return false;
	    }
	    default:{
	    	System.out.println("잘 못된 선택입니다. 유효한 메뉴를 선택해주세요");
	    	break;
	    }
		}
		return true;
	}
	public static void main(String[] args) {
		try {
			while(true) {
				displayMenu();
				int choice = getChoice();
				
				if(!processChoice(choice)) break;
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
	}
}
