package day06;

import java.util.Scanner;

public class OddEvenGameEx1 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		//정수가 num가 주어졌을 때 홀수인지 짝수인지 판별하는 예제

		int num = 11;
		int min =1 ,max=100;
		int totalMoney = 10000;//게임 시작시 주어지는 금액
		//num가 1~100사이의 랜덤한 수를 생선하는 코드를 작성
		while(totalMoney>0) {
		
		num = (int)(Math.random()*(max-min+1) + min);
	    //사용자가 게임에 투입할 금액을 입력하는 코드를 작성(최소 1원에서 현재 금액까지)
		System.out.println("배팅할 금액을 입력하세요(1~" + totalMoney +") : ");
		int money = scanner.nextInt();
		
		//입력받은 money가 totalMoney보다 크면 totalMoney로 바뀌는걸 자바로 출력해줘
		
		money = money>totalMoney ? totalMoney : money;
		if(money>totalMoney) {
			money = totalMoney;
			System.out.println("배팅 금액이 현재 금액보다 많습니다.");
		}else {
			System.out.println("배팅 금액" + totalMoney+"원");
		}
		
		System.out.println("배팅한 금액 : " + money + "원");
		
		System.out.println(num);
		//사용자가 0또는 1을 입력받은 코드를 작성 0:짝수 , 1:홀수
		System.out.println("홀(1) / 짝(0)? ");
		int user = scanner.nextInt();
		if(num%2==0) {
			System.out.println("짝수입니다.");
		}else {
			System.out.println("홀수입니다.");
		}
		//사용자가 입력한 값이 맞았는지 틀렸는지를 출력하는 코드를 작성
		//사용자가 입력한 값이 num의 홀짝과 맞는지를 출력하는 코드
		//승이면 배팅 금액을 주고, 패이면 배팅 금액을 차감
		
		if (user == num%2) {
			System.out.println("사용자 승!");
			totalMoney += money;
			
			}else {
			System.out.println("사용자 패!");
			totalMoney -= money;
		}	
		//user의 totalMoney가 0이 될때까지 반복하는 코드를 자바로 출력해줘
	
		
		System.out.println("현재 금액 : " + totalMoney+ "원");}
		System.out.println("배팅금액이 없으므로 게임을 종료합니다.");
		scanner.close();		
		
		
		
	
		
		
		
	}

}
