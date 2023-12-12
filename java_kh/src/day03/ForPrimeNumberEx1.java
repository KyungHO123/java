package day03;

import java.util.Scanner;

public class ForPrimeNumberEx1 {

	public static void main(String[] args) {
		/*소수 판별 예제
		 * 입력한 정수가 소수인지 아닌지 판별하는 코드를 작성하세요
		 * 소수는 약수가 2개인 수.
		 * 약수는 어떤 수를 나누었을 때 나머지가 0이 되게 하는 수.
		 * 4의 약수 : 1, 2, 4 약수 X
		 * 5의 약수 : 1 ,5 약수 O
		 * 반복회수 :
		 * 규칙성 :
		 * 반복문종료후 :
		 */
		
		int num = 6;
		int i,count;
		for(i=1,count=0;i<=num ;i++) {
		}if(num%i==0) {
			++count;
		}
		if(count==2) {
			System.out.println("ㅇㅇ");
		}else {
			System.out.println("ㄴㄴ");
		}
			
		
		
		
		
		
		
		
		
		
		
		
			
			//강사님 코드
		/*int num = 5;
		int count, i ;
		for(i = 1 , count = 0; i <= num ; i++) {
			if(num%i == 0) {
				++count;
			}
			if(count == 2) {
				System.out.println(num + "는 소수");
				
			}else {
				System.out.println(num + "는 소수 아님");
			
			}*/
		}
	}

