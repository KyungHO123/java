package day05;

import java.util.Arrays;

public class LottoEx1 {

	public static void main(String[] args) {
		/*1~45사이의 중복되지 않는 랜덤한 수 6개를 출력하세요.
		 * */
		/*int min = 1, max= 45;
		int []arr=new int[6];
		int count = 0; 
		
				while(count < 6 ) {
					
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
				} Arrays.sort(arr);
				for(int i = 0; i < arr.length;i++) {
					System.out.print(arr[i] + " ");
				}*/
				//강사님 코드
				int min = 1, max = 45;
				int lotto[]=new int[6];
				int count = 0;
								
				//랜검으로 중복되지 않은 6개의 수를 생성
				while(count<lotto.length) {
					//랜덤한 수 생선
					int r=(int)(Math.random()*(max-min+1) + min);
					
					//중복 확인
					int i;
					for(i=0;i<count;i++) {
						if(lotto[i]==r) {
							break;
							
						}
					}
					//중복되지 않으면 저장 후 count증가
					if(i == count) {
						lotto[count++]=r;
					}
				}
				//정렬
				Arrays.sort(lotto);
				//출력
				for(int i=0;i <lotto.length;i++) {
					System.out.print(lotto[i]+ " ");
				}
				
				
				
				
				
				
				
				
				
				
				
				
	}

}
