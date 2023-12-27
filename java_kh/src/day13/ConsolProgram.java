package day13;

import java.util.Scanner;

public class ConsolProgram implements Program{
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void printMenu() {
		System.out.println("--------메뉴---------");
		System.out.println("1.기능1");
		System.out.println("2.기능2");
		System.out.println("3.기능3");
		System.out.println("4.종료");
		System.out.println("-----------------");
		System.out.println("메뉴입력 : ");
	}
	@Override
	public void runMenu(int menu) {
		switch(menu){
			case 1:
				System.out.println("기능1이 실행중");
				break;
			case 2:
				System.out.println("기능2이 실행중");
				break;
			case 3:
				System.out.println("기능3이 실행중");
				break;
			case 4:
				
				break;
			default:	
				System.out.println("잘못된 메뉴");
		}
	}
	@Override
	public void printExit() {
		System.out.println("-----------------");
		System.out.println("프로그램을 종료합니다");
		System.out.println("-----------------");
	}
	@Override
	public void run() {
		System.out.println("-----------------");
		System.out.println("프로그램을 실행합니다.");
		System.out.println("-----------------");
		int menu;
		do {
			//메뉴출력
			printMenu();
			//메뉴입력
			menu = sc.nextInt();
			//메뉴실행
			runMenu(menu);

		}while(menu != 4);
		printExit();
	}
}


















