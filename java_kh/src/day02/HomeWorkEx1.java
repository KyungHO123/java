package day02;

import java.util.Scanner;

public class HomeWorkEx1 {

	private static Scanner sc;

	public static void main(String[] args) {
		/* 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 * 90이상 ~ 100이하 : A
		 * 80이상 ~ 90미만 : B
		 * 70이상 ~ 80미만 : C
		 * 60이상 ~ 70미만 : D
		 * 60미만 : F
		 * 0보다 작거나 100보다 큰 경우 : 잘못된 점수
		 */
		
	Scanner scan = new Scanner(System.in);
	System.out.print("성적을 입력 하세요 : ");
	int num = scan.nextInt();
		
		
		if (0> num || num > 100) {
			System.out.println("잘못된 점수 입니다.");
			}
		else if(90<=num && num<=100) {
			System.out.println(num + "점은 A입니다.");
		}else if(80<=num && num<=90) {
			System.out.println(num + "점은 B입니다.");
		}else if(70<=num && num<=80) {
			System.out.println(num + "점은 C입니다.");
		}else if(60<=num && num<=70) {
			System.out.println(num + "점은 D입니다.");
		}else  {
			System.out.println(num + "점은 F입니다.");
		}
		
		sc.close();
		
	}

}
