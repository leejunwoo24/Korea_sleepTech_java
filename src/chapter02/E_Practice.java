package chapter02;

import java.util.Scanner;

public class E_Practice {
	public static void main(String[] args) {
		/*
		1. 점수에 따른 학점 출력 (if, else if, else 사용)

        사용자로부터 점수를 입력받아 아래 기준에 따라 학점을 출력하세요.
        0 미만 또는 100 초과인 경우: 유효하지 않은 점수입니다.
        90 이상: A
        80 이상: B
        70 이상: C
        60 이상: D
        그 외: F
        */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		int grade = sc.nextInt();
		if(100 < grade || 0 > grade) {
			System.out.println("유효하지 않은 점수입니다.");
		} else if(grade >= 90) {
			System.out.println("A");
		} else if(grade >= 80) {
			System.out.println("B");
		} else if(grade >= 70) {
		 	System.out.println("C");
		} else if(grade >= 60) {
			System.out.println("D");
		} else{
			System.out.println("F");
		} 
		
		sc.close();
		
		/*
		2. 삼각형 모양의 별(*) 출력 (중첩 for 사용)
        (1)
        *
        **
        ***
        ****
        *****
        
        >> 행이 5번 반복 (줄 수 1 ~ 5까지 반복)
        >> 각 행 마다 *의 갯수가 1씩 증가 (1에서 5로 증가)
        	: 각 줄의 별 개수는 각 줄의 수 보다 "이하"의 값
	*/
		
		for(int i = 1; i <= 5; i++) {
			System.out.println();
			for(int j = 1; j <= 5; j++ ) {
				if(i >= j) {
					System.out.print("*");
				}
				
			}
		}
		
		// 2. (2)
		/*
		  		 *
		  		**
		  	   ***
		  	  ****
		  	 *****
		  	 
		  	 +) int rows = 5;
		  	 
		  	 - 행은 1부너 5까지 5번 반복
		  	  : i <= rows;
		  	  
		  	 - 공백은 4부터 0까지 -1씩 감소
		  	  : rows - i; (조건)
		  	  >> 첫 번째 행 i가 1, 공백은 4
		  	  >> 세 번째 행 i가 3, 공백은 2
		  	  >> 다섯 번째 행 i가 5, 공백은 0
		  	 - 별은 1부터 5까지 증가 (행의 수를 초과하지 않음)
		  	 
		 */
		
		System.out.println();
		System.out.println();
		
//		for(int i = 1; i <= 5; i++) {
//			
//			for(int k = 5; k >= 1; k--) {
//			
//			}
//			
//			for(int j = 1; j <= 5; j++) {
//				
//				if(i >= j) {
//				System.out.print("*");
//				}
//				
//			}
//			System.out.println();
//			
//		}
		
		
		int rows = 5; //출력할 줄 수
		for (int i = 1; i <= rows; i++) {
			//각 행의 반복
			// i: 1부터 5까지의 수
			for(int j = 1; j <= rows - i; j++) {
				//공백반복
				// j: 4부터 0까지의 수
				System.out.print(" ");
			}
			
			for(int k = 1; k <= i; k++) {
				//별 반복
				// k: 1부터 5까지의 수
				System.out.print("*");
			}
			System.out.println();
			
		}
		

	}

}
