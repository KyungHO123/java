package day05;

import java.util.Scanner;

public class NNTNTNT {

	public static void main(String[] args) {
		 // 정수를 입력받음
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int num = scanner.nextInt();

        // 정수를 거꾸로 출력
        int reverse = reverseInteger(num);
        System.out.println("입력한 정수를 거꾸로 출력: " + reverse);
    }

    // 정수를 거꾸로 만드는 메서드
    private static int reverseInteger(int n) {
        int reverse1 = 0;

        while (n != 0) {
            int digit = n % 10;
            reverse1 = reverse1 * 10 + digit;
            n /= 10;
        }

        return reverse1;
	}

}
