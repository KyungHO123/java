package day03;

public class NestedIfEx1 {

	public static void main(String[] args) {
		//2의 배수이면 2의 배수라고 출력하고, 6의 배수이면 6의 배수라고 출력하고
		//2,6의 배수가 아니면 2,6의 배수가 아님이라고 출력하느 예제
		int num = 15;
		
		//2의 배수를 확인 > num을 2로 나눴을 때 나머지가 0
		if (num%2 == 0) {
			//3의 배수
			if (num%3 == 0) {
				System.out.println(num + "은 6의 배수");
				}else {
					System.out.println(num + "은 2의 배수");
				}
		
		}else {
			System.out.println("2, 6의 배수가 아님");
		}
		
		//중첩 if를 사용 안하
		if(num % 2 == 0 && num % 3 == 0) {
			System.out.println(num + "은 6의 배수");
		}else if (num % 2 == 0) {
			System.out.println(num + "은 2의 배수");
		}else {
			System.out.println("2, 6의 배수가 아님");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
