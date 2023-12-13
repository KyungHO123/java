package day04;

import java.util.Scanner;

public class InfiniteLoopEx1 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		while(true) {
			
			System.out.println("정수 입력 : ");
			int num= scanner.nextInt();
			System.out.println("정수 출력 : "+ num);
	     }
		//무한루프가 100% 발생하는 코드 아래에 있는 코드는 에러가 발생
		//절대 실행될 일이 없어서 에러가 발생함.
		//System.out.println("프로그램 종료!");
		
		/*
		 for( ; ; ){
			//for문은 생략할시 무한루프
			System.out.println("정수 입력 : ");
			int num= scanner.nextInt();
			System.out.println("정수 출력 : "+ num);
		 * */
		
	}

}
