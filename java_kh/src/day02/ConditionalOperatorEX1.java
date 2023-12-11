package day02;

public class ConditionalOperatorEX1 {
	 //조건 선택 연산자
	public static void main (String[] agrs) {
		/*성적이 A인지 아닌지를 판별하는 예제
		 * 성적이 100이하이고 90이상이면 A, 아니면 A가 아님
		 * 
		 */
		int score = 90;
		String result = "";
		
		//score가 100보다 작거나 같고 90보다 크거나 같으면
		//score <= 100 && score >= 90
		result = score <= 100 && score >= 90 ? "A학점입니다." :"A학점이 아닙니다.";
	    System.out.println(score +"점은 " + result);
	}
		
	


}
