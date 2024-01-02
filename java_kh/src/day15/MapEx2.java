package day15;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MapEx2 {
	
	static Scanner sc=new Scanner(System.in);
	static Map<String, String>map = new HashMap<String, String>();
	
	public static void main(String[] args) {
		/* 회원을 관리하는 프로그램을 작성하세요.
		 * 메뉴
		 * 1.회원가입
		 * 	-아이디 비번 입력
		 * 	-이미 가입된 회원인지 체크(containsKey)
		 * 2.회원검색
		 * 	아이디를 입력해서 회원 정보를 조회
		 * 3.종료
		 * */
		 int menu=0;
		
		do {
			//메뉴 출력
			printMenu();
			try {
				menu= sc.nextInt();
				//메뉴실행
				runMenu(menu);
			}catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				sc.nextLine();//잘못 입력된 값을 문자열로 가져와서 버림
			}
			//종료
			
			
		}while(menu != 3);
		

	}
	private static void printMenu() {
		System.out.println("-------------");
		System.out.println("1.회원 가입");
		System.out.println("2.회원 검색");
		System.out.println("3. 종 료 ");
		System.out.println("-------------");
		System.out.print("메뉴 입력: ");
	}
	
	private static void runMenu(int menu) {
		String id,pw;
		switch(menu) {
		case 1:
			insertMember();
	
			break;
		case 2:
			searchMember();
			System.out.println("회원 검색 : ");
			break;
		case 3:
			System.out.println("종료합니다");
			break;
		default:
			throw new InputMismatchException();
		
		} 
		
	}
	private static void insertMember() {
		//아이디를 입력
		System.out.println("아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		//map에 아이디가 잇는지 확인
		

		//있으면 이미 있는 아이디라고 출력하고 메서드 종료
		if(map.containsKey(id)) {
			System.out.println("이미 가입된 아이디입니다.");
			return;
		}
		//없으면 비번 입력
		System.out.println("비번 : ");
		String pw=sc.nextLine();
		//map에 추가
		map.put(id, pw);	
	}
	
	private static void searchMember() {
		//아이디 입력
		System.out.println("아이디 : ");
		sc.nextLine();
		String id = sc.nextLine();
		//아이디, 비번 출력
		//비번을 가져옴
		String pw = map.get(id);
		
		//가져온 비번이 null이면 없는 회원이라 출력
		if(pw == null) {
			System.out.println("등록되지 않은 회원입니다.");
			return;
		}
		//아니면 아이디, 비번을 출력
		System.out.println("아이디 : " + id + " , 비번 : " + pw);
		
	}
}
