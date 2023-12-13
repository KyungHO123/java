package day04;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsEX {

	public static void main(String[] args) {
		/*다음 기능을 가진 가위,바위,보 게임 프로그램을 작성하세요.
		 * 1.새게임
		 * 2.기록
		 * 3.프로그램 종료
		 * 
		 * -새게임
		 * 	- 컴퓨터가 랜덤으로 내는 가위,바위,보와 내가 입력한 가위,바위,보를
		 * 	  비교하여 이기면 승, 지면 패, 비기면 무로 기록함
		 * 	- 바위 : R , 보 : P ,가위 : S
		 * -기록
		 * 	-승 무 패를 순서대로 출력
		 * */
		Scanner scanner=new Scanner(System.in);
		int random;
		int menu; 
		char com , user;
		 int num;
		 int win=0,draw=0,lose=0;
			do {
			
			System.out.println("=========");
			System.out.println("메뉴 선택 : ");
			System.out.println("1. 새게임");
			System.out.println("2. 기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.println("=========");
			menu = scanner.nextInt();
			switch(menu) {
			case 1:
			
				//랜덤으로 1~3사이의 숫자를 생성
				random = (int)(Math.random()*3 + 1);
				//1이면 R, 2이면 P, 3이면 S로
				com = random == 1? 'R' : (random == 2?'P' :'S');
				//사용자가 R,P,S중 하나를 입력
					System.out.println("가위(S),바위(R),보(P) 입력 : ");
					user = scanner.next().charAt(0);
				//사용자가 낸 가위바위보와 컴퓨터가 낸 랜덤 가위보를 비교해서
					
					if(user == com) {
						System.out.println("무승부!");
						draw++;
					}
					//승
					else if(('R'==user&&com =='S')
							||(user =='S'&&com =='P')
							||(user =='P'&&com =='P')) {
						System.out.println("user :" + user + " VS 컴퓨터 : " + com);
					System.out.println("user 승!");
						win++;
					}
					//패
					else {
						System.out.println("user :" + user + "VS 컴퓨터 : " + com);
						System.out.println("user 패!");
						lose++;
					}
				//승무패를 출력
				//승무패를 기록
				
			break;
			case 2:
				//승,무,패 기록을 출력
			System.out.println(win+"승 "+draw+"무 "+ lose +"패");
			break;
			case 3:
			System.out.println("3. 프로그램 종료");
			break;
			default:
			System.out.print("메뉴 선택 : ");
			}
			}while( menu !=3); 

			}
	{System.out.println("프로그램 종료");
		

	}
}
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
	
		