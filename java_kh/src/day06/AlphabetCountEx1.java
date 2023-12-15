package day06;

import java.util.Scanner;

public class AlphabetCountEx1 {

	public static void main(String[] args) {
		/*단어를 입력받아 단어 각 알파벳이 몇번 나왔는지 str.length와str.charAt을 활용하여 자바로출력하는 코드
		 *입력 : apple
		 *a:1
		 *e:1
		 *l:1
		 *p:2 
		 * */
		//단어를 입력 => 문자열을 입력
		System.out.println("단어 입력 : ");
		Scanner scanner=new Scanner(System.in);
		String str=scanner.next();
		int[]arr=new int[26];
		
		
		//반복문으로 문자열의 길이만큼 반복
		for(int i=0;i <str.length();i++) {
			// 문자열의 각 문자를 가져옴
		char ch=str.charAt(i);
			//가져온 문자의 배열 번지에 숫자를 증가
			//가져온 문자가 a이면 0번지에 있는 숫자를 1증가,b이면 1번지에 있는 숫자를 1증가
		
		arr[ch-'a']++;
		}System.out.println("알파벳 출현 횟수");
		// 내 코드 *****
		/*for(char c='a';c<='z';c++) {
			int count=arr[c-'a'];
			if(count>0) {
				System.out.println(c+" : " +count);
			}
		} */
		
		//강사님 코드 1
		/*for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				char ch=(char)('a'+i);
				System.out.println(ch + " : " + arr[i]);
			}
		}*///여기까지
		
		//강사님코드 2
		char ch='a';
		for(int count:arr) {
			if(count !=0) {
			System.out.println(ch + " : " +count);
		}ch++;
			}
		scanner.close();
		
	}

}
