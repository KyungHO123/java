package day06;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkEx2 {

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
		//반복문 : 프로그램 종료를 선택하기 전까지 반복
		int menu;
		Scanner scanner = new Scanner(System.in);
		int records[]=new int[5];
		String names[]=new String[5];
		int rankCount = 0;
		
		//records를 가장 큰값으로 초기화
		for(int i=0;i<records.length;i++) {
			records[i]=Integer.MAX_VALUE;
		}
		do {
			
			//메뉴를 출력
			System.out.println("메뉴");
			System.out.println("1. 새 게임");
			System.out.println("2. 기록 확인");
			System.out.print("메뉴 선택");
			menu = scanner.nextInt();
			switch(menu) {
			case 1:
				int min = 1, max= 9;
				int com[]=new int[3];
				int count = 0; 
				int recordCount = 0;
				while(count<com.length) {
					int r=(int)(Math.random()*(max-min+1) + min);
					int i;
					for(i=0;i<count;i++) {
						if(com[i]==r) {
							break;
						}
					}
					if(i == count) {
						com[count++]=r;
					}
				}
				for(int i=0;i <com.length;i++) {
					System.out.print(com[i]+ " ");
				}System.out.println();	
				int strike,ball;
				int user[]=new int[com.length];
					do {
						count=0;
						System.out.print("입력 : ");
						while(count<user.length) {
							int input = scanner.nextInt();
							for(int i=0;i<count;i++) {
								if(user[i]==input) {
									break;
								}if(i==count) {
									user[count++]=input;
							}					
						}
					}
					    strike=0;
						ball=0;
						for(int i=0;i<com.length;i++) {
							for(int j=0;j<user.length;j++) {
								if(com[i] == user[j]) {
								}if(i==j) {
										strike++;
									}else {
										ball++;
									}
								}	if(strike !=0) {
									System.out.println(strike +"S");
							}
					
						}
						if(ball != 0) {
							System.out.println(ball +"B");
						}
						if(strike ==0&&ball==0) {
							System.out.print("O");
						}
						System.out.println();
						recordCount++;
					}while(strike<3);
					System.out.println("정답입니다.!");	
					//기록을 비교하여 등수에 들면 추가
					//기록이 5개 등록이 안 된 경우나 마지막 기록이 내 기록보다 큰 경우
					String name =scanner.next();

					if (rankCount < 5 ||records[rankCount-1]<recordCount) {
						records[4]=recordCount;
					

						System.out.print("이름 : ");
						rankCount = rankCount<5? rankCount+1:rankCount;
					int index =0;
					//현재 기록이 들어갈 위치를 찾음
					for(int i =0;i<rankCount;i++) {
						if(recordCount < records[i]) {
							index=i;
							break;
						}
					}
					//이전 기록들을 뒤로 한칸 씩 밈
					for(int i=rankCount-1;i > index;i--) {
						records[i]=records[i-1];
					}	
					records[index] = recordCount;
					names[index] =name;
                    }
				break;
			case 2:
				if(rankCount ==0) {
					System.out.println("기록이 없습니다.");
				}else {
					for(int i=0;i<rankCount;i++) {
						System.out.println(i+1 + "등" + records[i] +"회 -" + names[i]);
					}
				}
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
      }while(menu!= 3);
		scanner.close();
	}		
} 
//丕刀卜己卜