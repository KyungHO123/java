package day02;

import java.util.Scanner;

public class TestEx6 {

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
		Scanner scan = new Scanner(System.in);
		System.out.print( "두 정수와 연사자 입력 : (예:1+2) :");
		int num1 = scan.nextInt();
		char oper = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		if(oper == '+') {
			System.out.println(num1 + " " + oper + " " + num2 + " = " +
		(num1 + num2));
		}else if(oper == '-') {
			System.out.println(num1 + " " + oper + " " + num2 + " = " +
		(num1 - num2));}
		else if(oper == '*') {
			System.out.println(num1 + " " + oper + " " + num2 + " = " +
		(num1 * num2));}
		else if(oper == '/') {
			System.out.println(num1 + " " + oper + " " + num2 + " = " +
		(num1 /(double) num2));
		}else if(oper == '%') {
			System.out.println(num1 + " " + oper + " " + num2 + " = " +
		(num1 + num2));}
		else {
			System.out.println(oper+"는 산술 연산자가 아닙니다.");
			
		
	
		scan.close();}}}
		
		
		
		
	
