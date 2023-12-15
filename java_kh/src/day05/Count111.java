package day05;

import java.util.Scanner;

public class Count111 {
	public static void main(String[] args) {
		// 5개짜리 배열 (입력한 수를 저장하는 배열 - user)
        int[] user = new int[5];

        // 10개짜리 배열 (각 숫자가 몇 개 입력되었는지 저장하는 배열 - count)
        int[] count = new int[10];

        // 반복문으로 5개의 정수를 입력받아 user에 저장하고 count 배열에 숫자 개수를 세어준다.
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("정수를 입력하세요: ");
            int input = scanner.nextInt();
            
            // user 배열에 저장
            user[i] = input;

            // count 배열에 해당하는 숫자의 개수를 1 증가
            count[input]++;
        }

        // count 배열 출력
        for (int i = 1; i < 10; i++) {
            System.out.println(i + "의 개수: " + count[i]);
        }
    }
}
		
		
		
		
		
		
		
		
		
		
		
		
	
