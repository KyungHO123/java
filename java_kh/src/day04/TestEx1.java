package day04;

import java.util.Scanner;

public class TestEx1 {

	public static void main(String[] args) {
		/* Scanner를 이용하여 국어, 영어, 수학 성적을 입력받고,
		 * 총점과 평균을 구하는 코드를 작성하세요. */
		Scanner scanner = new Scanner(System.in);
		/*System.out.println("성적을 입력 하세요 : ");
		int kor = scanner.nextInt(),eng = scanner.nextInt(),mat =scanner.nextInt();
		int sum = kor + eng + mat;
		System.out.println("입력하신 성적의 총점은 " + sum + "점 입니다." );
		System.out.println("입력하신 성적의 평균은 " + (double)sum/3 + "점 입니다.");*/
		
		//성적을 입력받기 위한 안내 문구 출력
		System.out.print("성적 입력(국어,영어,수학 순) : ");
		//성적을 Scanner를 통해 입력 
		int kor = scanner.nextInt();
		int eng = scanner.nextInt();
		int math= scanner.nextInt();
		//성적의 총점과 평균을 계산
		int sum = kor + eng + math;
		double avg = (double)sum/3; // 정수 / 정수 = 정수라서 형변환 해줘야함
		//성적의 총점과 평균이 출력
		System.out.println("총점 : " + sum + ", 평균 : " + avg);
		scanner.close();	
	}

}
