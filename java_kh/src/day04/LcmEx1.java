package day04;

public class LcmEx1 {

	public static void main(String[] args) {
		/* 두 정수의 최소 공배수를 구하는 코드를 작성하세요.
		 * 10의 배수 : 10 , 20 ,30 , ...
		 * 15의 배수 : 15 , 30 , 45 , ....
		 * 10과 15의 공배수 : 30 , 60 , 90
		 * 10과 15의 최소 공배수 : 30
		 * */
		
		int num1 = 10 , num2 = 15;
		int lcm;
		
		for(int i= 1;i <= num1*num2; i++) {
			
			if(i%num1==0&&i%num2==0) {
		
				System.out.println(num1 +"과 " + num2 + "의 최소 공배수 : " + i);
				break;
			}
		}
	}
}
