package day05;

import java.util.Scanner;

public class ArrayEx1 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		/*int kor1, kor2,kor3,kor4,kor5;
		kor1=scanner.nextInt();
		kor2=scanner.nextInt();
		kor3=scanner.nextInt();
		kor4=scanner.nextInt();
		kor5=scanner.nextInt();*/
		//아래 반복문은 변수명에 숫자가 들어가서 i로 변경 후 반복문을 쓰려고 해도
		//불가능 
		
		//학생 5명의 국어 성적을 저장하기 위한 배열
		
		
		int[]korScores = new int[5];
		/*korScores[0]=scanner.nextInt();
		korScores[1]=scanner.nextInt();
		korScores[2]=scanner.nextInt();
		korScores[3]=scanner.nextInt();
		korScores[4]=scanner.nextInt();*/
		
		for(int i=0;i<5;i++) {
			System.out.print("학생" + (i+1) + "성적 : ");
			korScores[i]=scanner.nextInt();
		}for(int i=0;i<5;i++) {
			System.out.print(" 학생" + (i+1) + "성적 : " + korScores[i]);
		}
		
		
		scanner.close();
		
		
		
		
		
		
		
		
		
		
		
		
					
	}

}
