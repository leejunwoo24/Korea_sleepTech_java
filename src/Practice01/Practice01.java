package Practice01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

// == 직원 관리 시스템 == //

// 직원 데이터 정의
@AllArgsConstructor // Setter 역할
@Getter
@ToString
class Employee{
	private String department; // 부서
	private String name; // 직원명
	private int salary; //급여
}

public class Practice01 {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee("IT", "이승아", 300),
				new Employee("HR", "조승원", 500),
				new Employee("IT", "김준일", 400),
				new Employee("OP", "전예찬", 350),
				new Employee("HP", "윤대휘", 300)
				);
		
			// 1. 급여가 400 이상인 직원 필터링
			// : filter() - 조건을 검사해서 true인 요소만을 다시 반환
			List<Employee> highSalaryEmployees = employees.stream()
					.filter(e -> e.getSalary() >= 400)
					.collect(Collectors.toList());
			
			highSalaryEmployees.forEach(e -> System.out.println(e));
//			highSalaryEmployees.forEach(System.out::println);
	
//			2. IT 부서 직원의 이름만 추출
//			1) 부서(department)가 'IT'인 직원을 필터링 - filter
			List<String> itEmployeeNames = employees.stream()
			.filter(employee -> "IT".equals(employee.getDepartment()))
//			.map(employee -> employee.getName())
			.map(Employee::getName) //임의 객체 인스턴스 메서드 참조(객체 클래스타입:: 인스턴스 메서드)
			.collect(Collectors.toList());
			
			itEmployeeNames.forEach(System.out::println);
			
			// 3. 특정 부서(HT) 직원 중 이름에 '조'가 포함된 직원 필터링
			// 1) 부서가 'HR'인 직원을 필터링 >> equals
			// 2) 위의 목록 중 이름에 '조가' 포함된 직원을 필터링 >> contans
			
			List<Employee> HTEmployees = employees.stream()
					.filter(employee -> (employee.getDepartment().equals("HR")))
					.filter(employee -> (employee.getName().contains("조")))
					.collect(Collectors.toList());
			
			HTEmployees.forEach(System.out::println);
			
			// cf) groupingBy()
			// : Map 인터페이스를 반환 - 그룹화 값(key), 내부 요소 (value)
			
			// 4. 부서별 직원 그룹화
			// Collectors 클래스 - groupingBy
			Map<String, List<Employee>> employeeByDept = employees.stream()
					// .collect(Collectors.groupingBy(Employee::getDepartment));
					.collect(Collectors.groupingBy(employee -> employee.getDepartment()));
			
			System.out.println(employeeByDept);
			//{OP=[Employee(department=OP, name=전예찬, salary=350)], HP=[Employee(department=HP, name=윤대휘, salary=300)], HR=[Employee(department=HR, name=조승원, salary=500)], IT=[Employee(department=IT, name=이승아, salary=300), Employee(department=IT, name=김준일, salary=400)]}
	
			// 5. 부서별 평균 급여 계산
			// Collectors 클래스 - groupingBy, avaragingInt(각 직원의 급여를 전달)
			Map<String, Double> avgSalaryByDept = employees.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment,
							Collectors.averagingInt(Employee::getSalary)));
			
			//cf 정수값의 평균값은 실수 반환 가능성 존재
			System.out.println(avgSalaryByDept); //{OP=350.0, HP=300.0, HR=500.0, IT=350.0}
					
	}
	
	
}
