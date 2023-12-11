package day02;

import java.util.Scanner;

public class IfMultiple {

	public static void main(String[] args) {
		//정수를 입력받아 3의 배수인지 아닌지 판별하는 코드를 작성하세요
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력 해주세요 : ");
		int num1 = scan.nextInt();
		System.out.print("입력 받은 정수 : ");
	
		
		if (num1 % 3 == 0) {
		System.out.println(num1 + "은 3의 배수가 맞습니다. ");
		}else {
			System.out.println(num1 + "은(는) 3의 배수가 아닙니다.");
		}
		scan.close();
 
	}

}
