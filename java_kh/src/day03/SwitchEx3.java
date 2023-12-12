package day03;

import java.util.Scanner;

public class SwitchEx3 {

	public static void main(String[] args){
		
		/*월을 입력받아 입력받은 월의 계절을 출력하세요
		 * 345 : 봄
		 * 678 : 여름
		 * 91011 : 가을
		 * 1212 :겨울
		 * 그 외 : 잘못된 월
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("월을 입력 하세요");
		int month = scan.nextInt();
		
		switch(month) {
		case 3,4,5:
	
			System.out.println(month + "월은 봄 입니다");
		break;
		case 6,7,8:
	
			System.out.println(month + "월은 여름 입니다");
		break;
		case 9,10,11:
		
			System.out.println(month + "월은 가을 입니다");
		break;
		case 12,1,2:
		
			System.out.println(month + "월은 겨울 입니다");
			}
		scan.close();
		
	}
}


