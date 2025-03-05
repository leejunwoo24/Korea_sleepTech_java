package test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lombok.ToString;

// 1. src 폴더 내에 test 패키지 생성
// 2. JavaTest_본명 class 파일 생성
// 3. main 메서드 내에 문제 답안 작성

// cf) 구글링, AI Tool 사용 금지
//		: 아는 내용만 작성, 없을 경우 문제 번호만 작성하고 공란 제출 
public class JavaTest_이준우 {
	public static void main(String[] args) {
		// cf) 답안 작성 예시
		// 1. 서술형
		// - 기본 데이터 타입: ~~ byte, short, int, long, float, double, char, boolean 
		//					등 변수에 할당된 '값'이 바로 메모리에 저장되게 하는 데이터
		
		// - 참조 데이터 타입: ~~ 위에서 작성한 데이터 외의 타입으로 변수에 값이 할당되면
		//   그 값이 메모리의 Heap영역에 저장되어서 값에 대한 주소값이 변수에 저장되게 하는 데이터
		
		// 2. 코드 구현 문제
		int num1 = 10; // 이후 풀이 작성
		double num2 = 3.5;
		double result = num1 + num2;
		System.out.println(result);
		
		// 3. 코드 구현 문제
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		if(sum % 2 == 0) {
			System.out.println("입력하신 숫자는 짝수 입니다.");
		} else{
			System.out.println("입력하신 숫자는 홀수 입니다.");
		}
		// 4. 코드 구현 문제
		int [] numbers = {1, 2, 3, 4, 5};
		for(int number : numbers) {
			System.out.println(number);
		}
		
		// 5. 코드 구현 문제
		@ToString
		class Student{
			private String name;
			private int score;
			
			public Student(String name, int scroe) {
				this.name = name;
				this.score = scroe;
			}
			
		}
			List<Student> students = Arrays.asList(
					new Student("john", 85),
					new Student("Jane", 92),
					new Student("Tom", 78),
					new Student("Emily", 88),
					new Student("Alex", 95)
					);
			for(Student student : students) {
				if(student.score > 90) {
					System.out.println(student);
				}
			}
		// 6. 단답형
		// 자바에서 모든 클래스의 최상위 부모 클래스는 무엇입니까?
		// __정답:Object______

		// 7. 단답형
		// ArrayList와 같은 컬렉션에서 요소의 개수를 반환하는 메서드는 무엇입니까?
		// 정답 :length()
			
		// 8. 단답형
		// 자바에서 if-else 문 대신 간결하게 조건에 따라 값을 반환할 수 있는 연산자는 무엇입니까?
		// 정답: 삼항연산자
			
		// 9. 단답형
	    // 다음 중 인터페이스에서 사용할 수 없는 것은 무엇입니까?
		// 정답 : 생성자
			

		/*10. 접답: "2번"
		 	*  다음 중 `@FunctionalInterface`에 해당하는 조건으로 올바른 것은 무엇입니까?
			1. 여러 개의 추상 메서드 포함 가능
			2. 반드시 하나의 추상 메서드 포함
			3. `default` 메서드를 포함할 수 없음
			4. 정적 메서드만 포함 가능
		 * */	
			

			/*
			 * 11. 정답 :child
			 * 다음 코드에서 출력 결과는 무엇입니까?
			 * class Parent {
				void display() {
					System.out.println("Parent");
				}
			}

			class Child extends Parent {
				void display() {
					System.out.println("Child");
				}
			}

			public class Main {
				public static void main(String[] args) {
					Parent obj = new Child();
					obj.display();
				}
			}
			 * */
			
			
			
		// 12. 정답 :1번
		/* 싱글톤 패턴을 구현할 때 가장 일반적으로 사용되는 메서드는 무엇입니까?
		* 	1. `public static`
			2. `private static`
			3. `protected static`
			4. `default static`
		* */
			
			
		// 13. 정답: 2번
		/*추상 클래스는 객체를 생성할 수 있습니까?
		 * 1. 예
		 * 2. 아니요
		 * */	
			
		// 14.다음 코드에서 다운 캐스팅이 성공하려면 어떤 조건이 필요합니까?
		/*
		 * Animal animal = new Dog();
		 *	Dog dog = (Dog) animal;	
		 * */	
		// animal이 부모클래스이고 Dog가 자식클래스인 서로 상속 관계의 클래스여야한다.
		//	그러면 생성된 Dog객체가 Animal타입으로 업케스팅이 한 번 되고,
		// Animal타입으로 업케스팅 된 Dog객체를 담고 있는 animal 객체를
		// 다시 Dog클래스 타입으로 강제 형 변환시켜서 다운캐스팅을 한다.
	
			
			
		// 15 정답: 2번
		//빌더 패턴의 주요 이점은 무엇입니까?
		/*
		 *  1. 상속 관계에서 객체를 더 쉽게 생성할 수 있다.
			2. 객체 생성 시 복잡한 생성자 호출을 피할 수 있다.
			3. 동시성 처리를 쉽게 한다.
			4. 객체의 메모리 사용을 줄인다.
		 * */	
			
			
		// 16. 정답 : 2번
		/*MVC 패턴**에서 사용자의 입력을 처리하는 역할은 무엇입니까?
		1. Model
		2. View
		3. Controller
		 * 
		 * 
		 * */
			
		// 17. 인터페이스의 모든 메서드는 기본적으로 어떤 접근 제어자를 가집니까? 
			//정답: public
			
		// 18. 추상 클래스와 인터페이스의 주요 차이점 중 맞지 않는 것은 무엇입니까?
		/*
		 * 1. 추상 클래스는 생성자를 가질 수 있다.
			2. 인터페이스는 다중 상속을 지원한다.
			3. 인터페이스는 필드를 가질 수 없다.
			4. 추상 클래스는 정적 메서드를 가질 수 없다.
		 * */	
			// 정답: 3번
			
	}
}