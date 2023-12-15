package day06;

import java.util.Scanner;

public class ArithmeticEx2 {

	public static void main(String[] args) {
	
	
	
	int min =1 ,max=99;
	int num1 = (int)(Math.random()*(max-min+1) + min);
	int num2 = (int)(Math.random()*(max-min+1) + min);
	int opNum =(int)(Math.random()*3);
	String str ="+-*";
	int user,answer = 0;
	Scanner scanner=new Scanner(System.in);
	
	char op = str.charAt(opNum);
	
	System.out.println("" + num1 + op + num2 + "=");
	user=scanner.nextInt();
	//정답 계산
	switch(op) {
	case '+':
		answer = num1+num2;
		break;
	case '-':
		answer = num1-num2;
		break;
	case '*':
		answer = num1*num2;
		default:
			System.out.println("잘못된 연산자입니다.");
	}
	//맞췄는지 틀렸는지
	if(user == answer) {
		System.out.println("정답입니다!");
	}else {
		System.out.println("틀렸습니다!");
	}
	
	
	
	scanner.close();
	
	
	
	
	
	}

}
