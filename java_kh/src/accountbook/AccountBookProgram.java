package accountbook;

import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;

public class AccountBookProgram implements Program {
	private Scanner sc = new Scanner(System.in);
	private final int EXIT = 3;
	@Override
	public void run() {
		int menu = 0;
		do {
			try {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
			}catch(InputMismatchException e) {
				System.out.println("잘못 입력 하셨습니다.");
			}
		}while(menu != EXIT);
		
	}
	/* ===수입 지출 조회===
	 * 1.수입 추가
	 * 2.수입 조회
	 * 3.지출 추가
	 * 4.지출 조회
	 * 메뉴 입력 : 1
	 * ===수입추가====*/

	@Override
	public void printMenu() {
		 System.out.println("====가계부====");
         System.out.println("1.수입,지출 조회");
         System.out.println("2.잔액 조회");
         System.out.println("3.프로그램 종료");
         System.out.println("=============");
         System.out.print("메뉴 입력 : ");
		
	}

	@Override
	public void runMenu(int menu) {
		switch (menu) {
		case 1: 
			subMenu();
			break;
		case 2:
			//2. 잔액 조회
			break;
		case 3:
			System.out.println("|프|로|그|램|종|료|");
			//3. 프로그램 종료
			break;
		default:
			throw new InputMismatchException();
		}
		
	}

	private void subMenu() {
		
		
	}

}
