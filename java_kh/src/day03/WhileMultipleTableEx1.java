package day03;

import java.util.Scanner;

public class WhileMultipleTableEx1 {

	public static void main(String[] args) {
		/* 구구단 2단을 출력하는 코드를 작성하세요.
		 * 2 x 1 = 2
		 * 2 x 2 = 4
		 *  ...
		 * 2 x 9 = 18
		 * 반복회수 :
		 * 규칙성 :
		 * 반복문종료후 : 없음
		 */
	/*Scanner scan = new Scanner(System.in);{
			int i = scan.nextInt();
			int c = scan.nextInt();*/
		  int i = 1;
		  int n = 2;
	      int c = 9;
			while(i<= c) {
				System.out.println(n + "x" + i + "=" + (n * i++));
				}
		
		//강사님 코드
		/*int num = 2;
		int i =1;
		while(i <= 9) {
			System.out.println(num + " X " + i + " = " + num*i);
			i++;*/
		}
		}
	

