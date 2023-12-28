package day14;

import java.security.PublicKey;
import java.text.MessageFormat;
import java.util.Scanner;

public class ArithmeticExceptionEx2 {
	
	

	public static void main(String[] args) {
		//두 정수와 산술 연산자를 입력 받아 결과를 출력하는 메서드를 구현하세요
		//단 , 메서드를 이용, throws와 thorw를 이용
		Scanner sc=new Scanner(System.in);
		System.out.println("두 정수와 산술 연산자를 입력하세요 (예 1 + 2) : ");
		try {
			int num1 =sc.nextInt();
			char op = sc.next().charAt(0);
			int num2=sc.nextInt();
			double res = calculate(num1, op, num2) ;
			String pattern = "{0}{1}{2}={3}";
			System.out.println(MessageFormat.format(pattern, num1,op,num2,res));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	public static double calculate(int num1,char op,int num2)
		throws RuntimeException {
		switch(op) { 
		case '+': return  num1 + num2 ; 
		case '-': return num1 - num2 ; 
		case '*': return num1 * num2 ; 
		case '/':if(num2 ==0) {
			throw new ArithmeticException("0으로 나눌 수 없습니다");
		} return num1 / num2 ; 
		case '%':
			if(num2 ==0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다");
			} return num1 % num2 ; 
		default :
			throw new RuntimeException(op + "산술 연산자가 아닙니다.");
		
		}
		
	}
	public static void print() {
		System.out.println("두 정수와 산술 연산자를 입력하세요 (예 1 + 2) : ");
	}
}
