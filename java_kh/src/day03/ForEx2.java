package day03;

public class ForEx2 {

	public static void main(String[] args) {
		/* 1에서 10사이의 짝수들의 합을 구하는 코드를 작성하세요
		 * 반복회수  : 
		 * 규칙성    :
		 * 반복문종료후:
		 * */
		int s=0;
		//초기화에 i를 선언하면 i는 반복문 밖에서 사용할 수 없다. 
		//사용하려면 재 선언을 해야함.
		for(int i =1; i<=10 ; i++) {
			if(i%2==0) {
				s=s+i;
			
			}
			
		}System.out.println(s);
		
		
		
		
		
		
	
	}

}
