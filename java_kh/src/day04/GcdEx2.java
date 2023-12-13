package day04;

public class GcdEx2 {

	public static void main(String[] args) {
		/*두 정수의 공약수를 출력하는 코드를 작성하세요
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수: 공통으로 있는 약수
		 * 12의 약수 : 1,2,3,4,6,12
		 * 8의 약수 : 1,2,4,8
		 * 8과 12의 공약수 : 1,2,4
		 * 반복회수 : i는 1부터 num1까지
		 * 규칙성 : 
		 * 반복문종료후:
		 * */
		
		//8과 12의 공약수니까 변수 2개 초기화
		/*int num1 = 12 , num2=8;
		System.out.print("8과 12의 공약수 : ");
		
		num1만 하면 12의 약수만 나옴 num2까지 해야 공약수가 나옴
		for(int i=1; i<=num1 ; i++ ) {
			if(num1%i==0){
				if(num2%i==0)
				System.out.print(i+(i == num2?"\n":","));
			}*/
		
		//강사님 코드
		int num1 = 8, num2 = 12;
		System.out.print(num1 +"과" + num2 + "의 공약수 : ");
		for(int i = 1 ; i <= num1 ; i++ ) {
			if(num1%i==0 && num2%i ==0) {
				System.out.print((i == 1 ?"" : ", ") + i);
			}
		}
	}
}
