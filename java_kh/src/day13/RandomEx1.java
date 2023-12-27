package day13;

import java.util.Random;

public class RandomEx1 {

	public static void main(String[] args) {
		//()안에 되도록이면 숫자 넣지 말기
		Random random = new Random();
		
		int min = 1 , max = 9;
		for(int i = 0; i < 10 ;i++) {
			System.out.print(random.nextInt(max-min+1)+min);
		}
		
	}
	
}

