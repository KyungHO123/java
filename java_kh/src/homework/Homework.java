package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework{
	static String mean;
	private static Scanner scan = new Scanner(System.in);
	private static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	public static void main(String[] args) {
		
		int menu = 0;
		//반복
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				//메뉴 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != 8);
	}
	
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1.단어 추가");
		System.out.println("2.단어 수정");
		System.out.println("3.단어 삭제");
		System.out.println("4.뜻 추가");
		System.out.println("5.뜻 수정");
		System.out.println("6.뜻 삭제");
		System.out.println("7.조회");
		System.out.println("8.종료");
		System.out.print("메뉴 선택 : ");
	}

	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//단어 추가
			ArrayList<String> list = new ArrayList<String>();
			System.out.print("추가할 단어 : ");
			String word = scan.next();
			if(map.containsKey(word)){
				System.out.println("이미 있는 단어");
			}else {
				map.put(word, list);
			}
			break;
		case 2:
			//단어 수정
			/* 1. apple(키값) 찾기
			 * 수정할 단어
			 * 2. aplle(키값) 만들기
			 * 3. apple벨류값을 aplle벨류에 복사
			 * 4. apple키를 삭제
			 */
			//새로운 단어 입력
			System.out.println("수정할 단어 : ");
			scan.nextLine();
			word = scan.next();
			map.containsKey(word);
			
			System.out.println("단어 수정 : ");
			String changeWord = scan.next();
			map.put(changeWord, map.remove(word));
			System.out.println("수정 완료");
			
		case 3:
			//단어 삭제
			System.out.println("삭제할 단어 : ");
			scan.nextLine();
			word = scan.next();
			map.remove(word);
			System.out.println(word + " 삭제 완료");
			break;
		case 4:
			//뜻 추가
			System.out.print("뜻을 추가할 단어 : ");
			word = scan.next();
			if(map.containsKey(word)) {
				System.out.print("추가할 뜻 : ");
				 mean = scan.next();
				map.get(word).add(mean);
			}else {
				System.out.println("없는 단어");
			}
			break;
		case 5:	
			break;
		case 6:
			//뜻 삭제
			break;
		case 7:
			//조회
			System.out.println(map);
			break;
		case 8:
			//종료
			System.out.println("종료");
			break;
		default:
			throw new InputMismatchException();
		} 
	}

}