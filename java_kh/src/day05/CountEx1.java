package day05;

import java.util.Scanner;

public class CountEx1 {

	public static void main(String[] args) {
		/* 1에서 9사이의 정수를 5개 입력받아 각 숫자가 몇개씩 입력됬는지 
		 * 출력하는 코드를 작성하세요.
		 * 1 2 3 1 2
		 * 1 : 2
		 * 2 : 2
		 * 3 : 1
		 * 4 : 0
		 * 5 : 0 
		 * 6 : 0
		 * 7 : 0
		 * 8 : 0
		 * 9 : 0
		 * */
		//5개짜리배열(입력한 수를 저장하는 배열-user)과 
		
		//10개짜리 배열(각 숫자가 몇개 입력됬는지 저장하는 배열-count)선언
		int user[] = new int[5];
		int count[]= new int[10];
		
		//반복문으로 5개의 정수를 입력 받아 user에 저장하고,count배열에 입력받은 정수번지에 해당하는 숫자를 1증가
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 5개를 입력하세요(1~9) : ");
		for(int i = 0; i<=user.length;i++) {
			user[i]=scanner.nextInt();
			count[user[i]]++;
		}
		//count배열에 있는 값을 1번지부터 9번지까지 출력
		for(int i = 1; i <count.length;i++) {
			System.out.println(i + " : " + count[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*int[] user = new int[5];
		int[] count = new int[10];
		int min = 1, max = 9;
		int r = (int)(Math.random()*(max-min+1)+min);
		System.out.println(r);
		
		
		
		Arrays.sort(user);
		for(int i = 0;i< user.length-1;i++) {
			for (int j = 0;j<user.length-1;j++) {
				if(user[j] > user[j+1]) {
					int tmp = user[j]; 
					user[j]=user[j+1]; 
					user[j+1]=tmp;    
				}
			}System.out.println(user);
		}*/
		
 

	
	
	
	
	
	
	
	
	
	
	}
	
}
		
		
		
		
		

		
		
		
		
		
		

