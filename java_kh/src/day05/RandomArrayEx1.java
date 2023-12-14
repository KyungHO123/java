package day05;

import java.util.Arrays;

public class RandomArrayEx1 {

	public static void main(String[] args) {
		/* 1~9사이의 랜덤한 수를 3개 생성해서 배열에 저장하는 코드를 작성.
		 * 3개짜리 배열을 생성하여 랜덤한 수를 저장
		 */
		int arr[]=new int[3];
		int max=9,min=1;
		int random = (int)(Math.random()*(max-min+1) + min);
		System.out.println(random);
		
		Arrays.sort(arr);
		for(int i = 0;i< arr.length-1;i++) {
			for (int j = 0;j<arr.length-1;j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j]; 
					arr[j]=arr[j+1]; 
					arr[j+1]=tmp;    
				}
			}
		}
		for(int i = 0;i < arr.length;i++) {
			System.out.print(arr[i] + " ");
			}
		System.out.println();
		
		//강사님 코드
		/*int[]arr = new int[3];
		int min =1 , max=9;
		/*
		arr[0] = (int)(Math.random()*(max-min+1) + min);
		arr[1] = (int)(Math.random()*(max-min+1) + min);
		arr[2] = (int)(Math.random()*(max-min+1) + min);
		for(int i =0;i < arr.length;i++) {
			arr[i] = (int)(Math.random()*(max-min+1) + min);
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}*/
	}
}
