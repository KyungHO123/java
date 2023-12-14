package day05;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumberEx1 {

	public static void main(String[] args) {

			/* 정수를 입력받아 입력받은 정수를 거꾸로출력하는 코드를 작성하세요.
			 * 예
			 * 입력 : 1234
			 * 출력 : 4321
			 * 예ㄴㄴ
			 * 입력 : 1200
			 * 출력 : 0021 
			 * */
		Scanner scanner = new Scanner(System.in);
		/*System.out.print("정수를 입력하세요 : ");
		int num = scanner.nextInt();
		System.out.println("입력하신 정수 : " + num);
		int arr[] = new int[10];
		//정수를 입력하여 num에 저장
		
		//tmp에 num를 복사 
		int tmp = num;
		//10개짜리 배열 arr를 선언
		
		//추출되어 저장된 개수를 의미하는 count변수를 선언 
		int count=0;
		
		//반복문(tmp가 0이 아닐때까지)
		while(tmp != 0) {
			//tmp를 10으로 나눈 나머지를 배열에 저장count번지에 저장
			  arr[count] = tmp % 10;
			//count를 1증가
			  count++;
		//tmp를 10으로 나눈 값을 tmp에 저장
			  tmp/=10;
		}
		//반복문을 이용하여 arr에 값을 0번지부터 count개 만큼 출력 
		System.out.println("배열 출력" + arr[i]);*/
		
		//강사님 코드
		//정수를 입력하여 num에 저장
		System.out.println("입력 : ");
		int num = scanner.nextInt();
		
		//tmp에 num를 복사 
				int tmp = num;
		//10개짜리 배열 arr를 선언
				int[]arr = new int[10];
				
		//추출되어 저장된 개수를 의미하는 count변수를 선언
				int count = 0;
		//반복문(tmp가 0이 아닐때까지)
				while(tmp != 0) {
		//tmp를 10으로 나눈 나머지를 배열에 저장count번지에 저장
				arr[count] = tmp % 10; 
		//count를 1증가
				count++;
		//tmp를 10으로 나눈 값을 tmp에 저장
				tmp /= 10; //tmp = tmp / 10;
	     }
		//반복문을 이용하여 arr에 값을 0번지부터 count개 만큼 출력 
				System.out.print("결과 : ");
				for(int i = 0;i < count;i++) {
					System.out.print(arr[i]);
				}
	scanner.close();
	
	
	
	
	}	

}


