package chapter04;

class Person{
	String name;
	int	age;
	static int population;
	
	Person(){
		population++;
	}
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
		population++;
	}
	
	void introduce() {
		System.out.println("안녕하세요, 저는 " + name + "이고, " + age + "살입니다.");
	}
}



public class H_Practice {

	public static void main(String[] args) {
		Person p1 = new Person("홍길동", 25);
		p1.introduce();
		
		new Person();
		new Person();
		new Person();
		new Person();
		System.out.println(Person.population); // 5
		
	}

}
