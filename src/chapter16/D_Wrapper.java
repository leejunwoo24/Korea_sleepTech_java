package chapter16;

// === Wrapper 클래스 ===//
// : 기본 데이터타입을 객체로 다루기 위해 사용되는 클래스

// cf) 기본 데이터 타입
// byte, short, int, long, float,double, char, boolenn, void(메서드 반환)
//	>> 각 데이터 타입에 해당하는 Wrapper 클래스가 존재

// - java.lang 패키지에 정의
// 		: 컬렉션 프레임워크에서는 내부에 객체만을 저장
//			>> 기본 데이터 타입의 저장을 Wrapper 클래ㅅ로 변환하여 저장

// Byte, Short, Integer, Long, Float, Double, Character, Boolean, Void

// 박싱(Boxing) & 언박싱(UnBoxing) //
// : 기본 타입과 해당 타입의 Wrapper 클래스간의 자동 변환
// : 자바 컴파일러가 자동 처리

// 1) 박싱
//  Wrapper 클래스로 객체로 변환하는 과정

// 2) 언박식
// : Wrapper 기본 타입으로 변환하는 과정

// +) 장단점
// 장점 : 기본 타입과 객체 ㅇ타입 간의 호환이 용이
// 단점 : 객체 생성 과정에서 메모리 사용량 증가(박싱,언박싱)
//	 
public class D_Wrapper {
	public static void main(String[] args) {
		// 1) 박싱
		int i = 5;
		Integer iObject = i;
		System.out.println(iObject); // 5
		
		// 2) 언박싱
		Integer integerValue = new Integer(15);
		int iValue = integerValue;
		System.out.println(iValue); //15
		
		// == Wrpper 클래스의 배무 메서드 == //
		// cf_) Wrapper 클래스 내부의 toString() 메서드 객체가 보유하고 있는 실제 값이 출력
		
		// Integer
		
		// 1) 생성자: Integer(int value)
		Integer myInteger = new Integer(50);
		
		new Integer("50"); // 문자열을 받아 해당한느 int 값을 갖는 Integer 객체생성
		// new Integer("안녕");
		// >> 문자열이 숫자로 변환될 수 없는 경우 NumberFormatException 발생
		
		// intValue(): Integer 객체를 기본 int 타입으로 변환
		int myInt = myInteger.intValue();
		System.out.println(myInt);
		
		// parseInt(String s): 문자열을 기본 int 타입으로 파싱
		// String >> Integer >> int
		int parseInt = Integer.parseInt("123");
		System.out.println(parseInt);
		
		//compareTo(Integer anotherInt): 두 Integer 객체를 비교해서, 호출 객체(a)가 더 크면 양스, 더 작으면 음수
		Integer anotherInt = new Integer(51);
		int result = myInteger.compareTo(anotherInt);
		System.out.println(result);
	}
}
