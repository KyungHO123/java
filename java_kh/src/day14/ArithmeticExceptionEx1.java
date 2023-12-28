package day14;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticExceptionEx1 {

	public static void main(String[] args) {
		//두 정수와 산술 연산자를 입력받아 산술연산하는 코드를 작성하세요.
		//단, 0으로 나눌 때 예외처리를 적용
		System.out.println("두 정수와 산술 연산자를 입력하세요 (예 1 + 2) : ");
		Scanner sc=new Scanner(System.in);
		try {
		int num1 =sc.nextInt();
		char ch1 = sc.next().charAt(0);
		int num2=sc.nextInt();
		double res = 0 ;
		//연산자에 맞게 결과를 출력
		
		switch(ch1) {
		case '+': res = num1 + num2 ; break;
		case '-': res = num1 - num2 ; break;
		case '*': res = num1 * num2 ; break;
		case '/': res = num1 / num2 ; break;
		case '%': res = num1 % num2 ; break;
		}
		String pattern = "{0}{1}{2}={3}";
		System.out.println(MessageFormat.format(pattern, num1,ch1,num2,res));
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없습니다");
		}catch(InputMismatchException e) {
			System.out.println("입력을 잘 못했습니다");
		}

	}

}
