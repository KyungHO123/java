package day14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoEx1 {

	public static void main(String[] args) {
		/* 랜덤으로 당첨 번호를 생성하고, 사용자가 로또 번호를 입력하면 등수를 알려주는 코드를 작성하세요.
		 * 단 , 컬렉션을 이용
		 * 당첨번호 : 6개, 보너스 : 1개
		 * 사용 : 6개
		 * 번호 범위 :1 ~45
		 * */
		/*ArrayList<Integer>list = new ArrayList<Integer>();
		int min =1,max=45;
		for(int i=0;i <6;i++) {
		int tmp = (int)(Math.random()*(max-min-1)+min);
			list.add(tmp);
			
			}System.out.println(list);
		}*/
		
		
		
		//Set 강사님 코드 
		Set<Integer> lotto = new HashSet<Integer>();
		Set<Integer> user = new HashSet<Integer>();
		int min=1,max=45;int bonus;
		//로또 당첨번호 6개를 랜덤으로 생성 (중복X)
		while(lotto.size()<6) {
			int tmp = (int)(Math.random()*(max-min-1)+min);
			lotto.add(tmp);
		}
		//보너스 번호를 생성
		while(true) {
			bonus = (int)(Math.random()*(max-min-1)+min);
			if(!lotto.contains(bonus)) {
				break;
			}
		}
		System.out.println(lotto + ", 보너스 : " + bonus);
		//사용자가 당첨 번호를 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("번호(중복되지 않은 6개) : ");
		while(user.size()<6) {
			int tmp = sc.nextInt();
			user.add(tmp);
		}
		//일치하는 개수 계산
		int count = 0;
		for(int tmp:user) {
			if(lotto.contains(tmp)) {
				count++;
			}
		}
		//등수를 출력
		switch(count) {
		case 6:
			System.out.println("1등");
			break;
		case 5:
			int rank = user.contains(bonus)? 2: 3;
			System.out.println(rank+"등");
			break;
		case 4:
			System.out.println("4등");
			break;
		case 3:
			System.out.println("5등");
			break;
		default :
			System.out.println("꽝 입니다.");
			
		}
	}
}


