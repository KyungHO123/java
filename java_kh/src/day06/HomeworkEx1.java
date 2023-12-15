package day06;

import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		/*숫자 야구게임을 구현하세요.
		 * -1~9사이의 중복되지 않은 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞추는 게임
		 * -로또와 비슷함.
		 * - S: 숫자가 있고,위치가 같은 경우 
		 * - B: 숫자가 있지만 위치가 다른 경우
		 * - O: 일치하는 숫자가 하나도 없는 경우
		 * - 3S가 되면 게임이 종료 
		 * 
		 * 예시
		 * 랜덤으로 생선된 숫자 : 3 9 1
		 * 입력 : 1 2 3
		 * 결과 : 2B
		 * 입력 : 4 5 6
		 * 결과 : O
		 * 입력 : 7 9 8
		 * 결과 : 1S
		 * 입력 : 3 1 9
		 * 결과 : 1S 2B
		 * 입력 : 3 9 1
		 * 결과 : 3S
		 * */
		System.out.println("야구시작");
		Scanner scanner = new Scanner(System.in);
		int num[] = new int[3];
		int user[]= new int[3];
		int strike = 0,ball=0;
		int min=1,max=9;
		
		for(int i = 0;i <num.length;i++) {
			num[i]=(int)(Math.random()*(max-min+1) + min);
			System.out.print("" + num[i]);
			for(int j=0;j<i;j++) {
				if(num[j]==num[i]) {
					
					i--;
					break;
				}
			}
		}
		//for(int t:num) {
			//System.out.print(t+" ");
		while(true) {
			for(int i =0;i<user.length;i++) {
				
				user[i]=scanner.nextInt();
				for(int j=0;j<i;j++) {
					if(user[i]==user[j]) {
						System.out.println("중복");
						i--;
						break;
					}
				}	
				
			}
			for(int i=0;i<user.length;i++) {
				for(int j=0;j<user.length;j++) {
					if(user[i]==num[j]&&i==j) {
						//System.out.print(i);
						strike++;
					}else if(num[i] == num[j]&&i != j) {
						ball++;
					}
				}
			}
			System.out.println(strike +"스트라이크" + "\n"+ball + "볼");
			if(strike == 3) {
				System.out.println("정답");
				break;
			}
			strike=0;
			ball=0;
      }
	}		
  }

