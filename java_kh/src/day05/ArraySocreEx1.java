package day05;

import java.util.Scanner;

public class ArraySocreEx1 {

	public static void main(String[] args) {
		/*학생 5명의 국어 성적을 입력받고, 총점과 평균을 구하는 코드를 작성하세요.*/
		Scanner scanner=new Scanner(System.in);
		int[]korScores = new int[5];
		
		for(int i=0;i<5;i++) {
			System.out.print("학생" + (i+1) + "성적 : ");
			korScores[i]=scanner.nextInt();
		}for(int i=0;i<5;i++) {
			System.out.println(" 학생" + (i+1) + "성적 : " + korScores[i]);
		int sum=0;
		/*sum= sum+korScore[0];
		sum= sum+korScore[1];
		sum= sum+korScore[2];
		sum= sum+korScore[3];
		sum= sum+korScore[4];*/
		sum += korScores[i];
		
		double avg=(double)sum/5;
		System.out.println("총점 : " + sum + ", 평균 : " + avg);
		scanner.close();
			

			
	}
		
		
		}
		
		
	}


