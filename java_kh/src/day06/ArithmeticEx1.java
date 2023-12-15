package day06;

import java.util.Scanner;

public class ArithmeticEx1 {

	public static void main(String[] args) {
			/*랜덤으로 산수(+,-,*) 문제를 생성하여 맞추는 게임
			 *1 + 2 = 3
			 *정답입니다.
			 *2 * 3 = 5
			 *틀렸습니다. 
			 * */
		
		//정수1을 랜덤으로 생성
		//정수2를 랜덤으로 생성
		//정수3(연산자)를 랜덤으로 생성
		System.out.println("가자");
		Scanner scanner=new Scanner(System.in);
		
		int num1,num2;
		//char oper;
		int min =1 ,max=99;
	int user,answer;
		 num1 = (int)(Math.random()*(max-min+1) + min);
		 num2 = (int)(Math.random()*(max-min+1) + min);
		int op =(int)(Math.random()*3 + 1);
		//연산자가 1이면
		switch(op) {
		case 1:
			//정수 1+정수2=을 콘솔에 출력
		System.out.println(num1+"+"+num2+"=");
			//정답을 입력
		user = scanner.nextInt();
			//입력받은 정답과 정수1+정수2가 같으면 정답이라고 출력
		answer= num1+num2;
		if(user == answer) {
			System.out.println("맞았어ㅋㅋ");
			//아니면 틀렸다고 출력
			}else {
				System.out.println("틀렸어");
			}
		break;
		//연산자가 2이면
		case 2:
			//정수1-정수2=을 콘솔에 출력
			System.out.println(num1 +"-"+num2+"=");
			//정답을 입력
			user = scanner.nextInt();
			//입력받은 정답과 정수1-정수2가 같으면 정답이라고 출력
			answer= num1-num2;
			if(user == answer) {
				System.out.println("맞았어ㅋㅋ");
			
			//아니면 틀렸다고 출력
				}else {
					
				
				System.out.println("틀렸어");}
			break;
		//연산자가 3이면
		case 3:
			//정수1*정수2=을 콘솔에 출력
			System.out.println(num1 +"*"+num2+"=");
			//정답을 입력
			user = scanner.nextInt();
			//입력받은 정답과 정수1*정수2가 같으면 정답이라고 출력
			answer= num1*num2;
			if(user == answer) {
				System.out.println("맞았어ㅋㅋ");
			//아니면 틀렸다고 출력
			}else {
				
			}System.out.println("틀렸어");
			break;
				default:
				System.out.println("정상이 아닙니다.");}
	}
		
}


