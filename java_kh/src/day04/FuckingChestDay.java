package day04;

import java.util.Scanner;

public class FuckingChestDay {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("몸무게를 입력하세요 : ");
		int num=scanner.nextInt();
		System.out.println("입력하신 몸무게 : " + num + "kg");
		
		
		if(0>num) {
			System.out.println("다시 입력하세요");
			}else if(num>90) {
				System.out.println("존나돼지입니다");			
			}else if(num>80) {
				System.out.println("살짝돼지입니다");			
			}else if(num>70) {
				System.out.println("정상입니다");			
			}else if(num>60) {
				System.out.println("빼빼로입니다");			
			}else {
				System.out.println("비정상입니다");
			}
		scanner.close();
	}
 

}
