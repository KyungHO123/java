package day03;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class SwitchEx4 {

	public static void main(String[] args) {
		/* 산술 연산자와 두 정수를 입력받아
		 * 산술 연산자에 맞는 연산 결과를 출력하는 코드를 작성하세요
		 * 예시1
		 * 두 정수와 연사자 입력 : (예:1+2) : 1+2
		 * 1+2=3
		 * 예시2
		 * 두 정수와 연사자 입력 : (예:1+2) : 1/2
		 * 1/2=0.5
		 * 예시3
		 * 두 정수와 연사자 입력 : (예:1+2) : 1?2
		 * ?는 산술 연산자가 아닙니다.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력 하세요 : ");
		int num1=scanner.nextInt();
		char ch=scanner.next().charAt(0);
		int num2=scanner.nextInt();
		
		
		/*switch(ch) {
		case '+':
			System.out.println(num1 + "" + ch + "" + num2 + "=" + (num1+num2));
			break;
		case '-':
			System.out.println(num1 + "" + ch + "" + num2 + "=" + (num1-num2));
			break;
		case '*':
			System.out.println(num1 + "" + ch + "" + num2 + "=" + (num1*num2));
			break;
		case '/':
			System.out.println(num1 + "" + ch + "" + num2 + "=" + (double)(num1/num2));
			break;
		case '%':
			System.out.println(num1 + "" + ch + "" + num2 + "=" + (num1%num2));
			break;
		}*/
		
		switch(ch) {
		case '+':
			System.out.println(""+ num1 + ch +  num2 + "=" + (num1+num2));
			break;
		case '-':
			System.out.println(""+ num1 +  ch + num2 + "=" + (num1-num2));
			break;
		case '*':
			System.out.println(""+ num1 +  ch +  num2 + "=" + (num1*num2));
			break;
		case '/':
			System.out.println(""+ num1 +  ch +  num2 + "=" + (double)(num1/num2));
			break;
		case '%':
			System.out.println(""+ num1 + ch +  num2 + "=" + (num1%num2));
			break;
			default:
				System.out.println(ch + "는 산술 연산자가 아님.");
		}
	}

}
