package day03;

public class WhileEx1 {
	//While문 예제
	public static void main(String[] args) {
		//Hello World를 5번 출력하는 예제
		
		//초기화 i = 1;
		int i = 1;
		int count = 2;
		while(i <= count) {
			
			//실행문;
			System.out.println("Hello World");
			
			
			//증감식;
			++i; //i++; i+=1; i=i+1;
		}
		
		/*System.out.println("Hello World"); //i = 1
		System.out.println("Hello World"); //i = 2
		System.out.println("Hello World"); //i = 3
		System.out.println("Hello World"); //i = 4
		System.out.println("Hello World"); //i = 5 */
	}

}
