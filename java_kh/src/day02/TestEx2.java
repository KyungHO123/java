package day02;

public class TestEx2 {
		//홀짝 판별 예제
	public static void main(String[] args) {
		
		int num = 3;
		
		//num가 홀수이면 홀수라고 출력하고, num가 짝수이면 짝수라고 출력하는 코드를 작성하세요.
		//num을 2로 나누었을 때 나머지가 0과 같으면 짝수라고 출력하고,
		//num을 2로 나누었을 때 나머지가 0과 같지 않으면 홀수라고 출력
		
		if((num % 2) == 0 ) {
			System.out.println("짝수 입니다.");
		}else {
			System.out.println("홀수 입니다.");
		}
			
	}

}
