package day04;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Up Down 게임을 구현하세요.
		 * - 다음과 같은 메뉴를 가져야 합니다.
		 * 1. 새게임
		 * 2. 최고기록 확인
		 * 3. 프로그램 종료
		 * 
		 * - 새게임은 업다운 게임을 시작
		 * 	-랜덤으로 생선된 수를 맞추는 게임
		 * 	-맞췄을 때 맞춘 횟수를 출력하고 메뉴로 돌아감
		 * - 최고기록 확인 업다운 게임을 하면서 맞춘 횟수 중 가장 적은
		 * 횟수를 알려줌
		 * */
	/* 반복문 -
	 * 	 -메뉴를 출력
	 * 	
	 * 	 -메뉴를 선택
	 * 
	 * 	 -선택한 메뉴에 따라 기능을 실행
	 *   -1번메뉴 선택
	 *   	-업다운 게임을 실행
	 *   	-랜덤한 수 생선
	 *   	-반복문 
	 *   		-정수 입력
	 *   		-입력회수를 1증가
	 *   		-입력한 정수와 랜덤한 수 비교후 up/down/정답 출력
	 *   	-게임이 끝났으면 현재 횟수와 최고기록 회수보다 좋으면
	 *   	-최고 기록횟수를 현재 횟수로 수정
	 *   -2번메뉴 선택
	 *   	-최고기록을 출력
	 *   
	 *   -3번메뉴 선택
	 *   	-프로그램을 종료
	 */ int menu; //메뉴
	 int count ,bestCount = -1;//게임 플레이 횟수, 최고기록
	 int random; //랜덤한 수
	 int num;//입력한 정수
	 int max=100,min=1;
	 
		do {
		
		System.out.println("-------------");
		System.out.println("메뉴 선택 : ");
		System.out.println("1. 새게임");
		System.out.println("2. 최고기록 확인");
		System.out.println("3. 프로그램 종료");
		System.out.println("-------------");
		menu = scan.nextInt();
	
		
		switch(menu) {
		case 1:
			random = (int)(Math.random()*(max-min+1) + min);
			System.out.println("게임시작" );
			count = 0;
			do {
				//정수입력
				num = scan.nextInt();
				//입력횟수를 1증가
				count++;
				//입력한 정수와 랜덤한 수 비교후 업다운 정답 출력
				if(num > random) {
					System.out.println("Down!");
				}else if(num < random) {
					System.out.println("Up!");
				}else {
					System.out.println("정답!");
				}
				}while(num != random);
			//현재 기록을 출력
			System.out.println("기록 : " + count);
			//게임이 끝났으면 현재 횟수가 최고기록 횟수보다 좋으면
			if(-1 ==bestCount || count < bestCount) {
				//최고 기록횟수를 현재 횟수로 수정
				bestCount = count;
			}
		break;
		case 2:
			int bestcount = -1;
			if(bestcount == -1) {
				System.out.println("플레이한 기록이 없습니다.");
			}
		//System.out.println("2. 최고기록 확인");
		System.out.println("최고 기록 : " + bestcount);
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


