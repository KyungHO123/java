package day03;

import java.util.Scanner;

public class SwtichEx2 {
		
	//Switch문 예제
	public static void main(String[] args) {
		//정수를 입력받아 입력받은 정수의 
		//홀짝 판별 예제를 switch문을 이용하여 작성하세요.
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 입력");
		int num=scan.nextInt();
				
		
		switch(num%2) {
		case 0:
			System.out.println(num + "은 짝수입니다");
		break;
		case 1:{
				System.out.println(num + "은 홀수입니다");
		break;}
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
