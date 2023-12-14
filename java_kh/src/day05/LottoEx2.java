package day05;

import java.util.Arrays;
import java.util.Scanner;

public class LottoEx2 {

	public static void main(String[] args) {
		/* 로또 당첨 번호를 랜덤으로 생성한 후(당첨번호 6자리 +보너스 번호)
		 * 사용자가 번호를 입력하면 (로또번호 6자리) 당첨 등수를 출력하는 코드를 작성하세요 
		 * */
		
		//7개짜리 배열을 만들어 로또 당첨 번호를 랜덤으로 생성 -1배열
		
		//위에서 생성한 배열 중 0번지부터 6개를 새로운 배열에 복사 - 2번 배열
		
		//1번 배열 6번지에 있는 값을 보너스로 지정 -보너스 번호
		
		//2번 배열 정렬 후 출력 
		
		//사용자 번호를 입력(6개)해서 배열에 저장 - 3번 배열 
		
		//당첨 개수 확인[이중반복문]
		
		//당첨 개수에 따른 등수를 출력 
		
		
		/*int min = 1, max= 45;
		int []arr=new int[7];
		
		int count = 0; 
		
		//1번 배열 
				while(count < 7 ) {
					
					int r=(int)(Math.random()*(max-min+1) + min);
					
					
					boolean duplicated = false;
					for(int i = 0;i < count; i++) {
						if(arr[i]==r) {
							duplicated = true;
							break;
						}
					}
					if(!duplicated) {
						arr[count] = r;
						count++;
					}
				} System.out.print("로또 당첨번호 : ");
				Arrays.sort(arr);
				for(int i = 0; i < arr.length;i++) {
					
					System.out.print( arr[i] + " "  );
				}
		//2번배열 
		Scanner scanner= new Scanner(System.in);
		System.out.println("\n번호를 입력하세요 : ");
		int user =scanner.nextInt();
		//System.out.println("입력하신 번호 : " + user);
		for(int i = 0;i < arr.length;i++) {
			System.out.print( user + " ");
 }*/
		//7개짜리 배열을 만들어 로또 당첨 번호를 랜덤으로 생성 -1번배열
			int[]tmp = new int[7];
			int count = 0;
			int min=1,max=45;
			int bonus =tmp[6];
			
			while(count<tmp.length) {
			int r = (int)(Math.random()*(max-min+1)+min);
			
			int i;
			for(i = 0 ; i < count;i++ );
			if(r == tmp[i]) {
				break;
			}if(i == count) {
				tmp[count++] = r;
			} 
		}
		//위에서 생성한 배열 중 0번지부터 6개를 새로운 배열에 복사 - 2번 배열
			int[]lotto = new int[6];
			
		//2번 배열 정렬 후 출력
			Arrays.sort(lotto);
			System.out.print("당첨번호 : ");
			for(int i = 0;i < lotto.length;i++) {
				System.out.print(lotto[i] + " ");
			}
		System.out.println(" [" + bonus + "]");
		//사용자 번호를 입력(6개)해서 배열에 저장 - 3번 배열
		Scanner scanner=new Scanner(System.in);
		int[]user = new int[6];
		System.out.print("입력 번호 : ");
		for(int i = 0;i<6;i++) {
			user[i]=scanner.nextInt();
		}
		int sameCount = 0;
		for(int i = 0; i<lotto.length;i++) {
			for(int j=0;j<user.length;j++) {
				if(lotto[i] == user[j]) {
					sameCount++;
					break;
				}
			}
		}
		//당첨 개수에 따른 등수를 출력
		switch(sameCount) {
		case 6:
			System.out.println("1등!");
			break;
		case 5:
			int i;
			for(i = 0;i <user.length;i++) {
				if(bonus == user[i]) {}

}
			//보너스번호와 일치
			break;
		case 4:
			System.out.println("4등");
			break;
		case 3:
			System.out.println("5등");
			break;
			default:
				System.out.println("꽝!");
		}
			
			
			
			
			
			
			
			
			
			
}
}