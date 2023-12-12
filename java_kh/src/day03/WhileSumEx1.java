package day03;

public class WhileSumEx1 {

	public static void main(String[] args) {
		/* 1부터 5까지의 합을 구하는 코드를 작성하세요.
		 * 반복회수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : sum = sum+i
		 * 반복문종료후 : sum을 출력
		 * */
		int sum = 0;
		int i = 1;
		int n = 5;
		while(i <= n) {
			System.out.println(sum=sum+i++);
		}
	}
}
		
		/* 강사님 코드
		int sum = 0;
		int i = 1;
		int n = 100;
		while(i <= n) {
			sum = sum + i;
			++i;
		}
	System.out.println(sum);*/

	



