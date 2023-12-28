package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {

	public static void main(String[] args) {
		//속담을 입력받아 저장하고, 출력하는 코드를 작성하세요.
		ArrayList<String>list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		String str;
		/*System.out.println("속담을 입력하세요 : ");
		String str1=sc.nextLine();
		System.out.println("입력한 속담 : " + str1);*/
		
		//강사님 코드
		while(true) {
			System.out.println("속담을 입력하세요.(종료하려면 -1): ");
			str = sc.nextLine();
			
			//종료하기 위해 -1을 입력했으면 반복문 종료
			if(str.equals("-1")) {
				break;
			}
			list.add(str);
		}
		
		for(String tmp : list) {
			System.out.println(tmp);
		}
	}

}
