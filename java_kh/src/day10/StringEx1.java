package day10;

public class StringEx1 {
	/* 영어 단어장 프로그램을 만드세요
	 * 1. 기능 정리
	 * 단어추가 ,단어조회, 단어삭제 ,프로그램 종료
	 * 2.틀 작성
	 * 
	 * 메뉴
	 * 1.단어추가 
	 * 2.단어조회
	 * 3.프로그램종료
	 * 메뉴 선택 :1
	 * ------------
	 * 단어추가
	 * 단어를 입력(영어):apple
	 * 뜻을 입력 (한글):사과
	 * 저장되었습니다.
	 * ------------
	 * 1.단어추가 
	 * 2.단어조회
	 * 3.프로그램종료
	 * 메뉴 선택 :2
	 * --------------
	 * 단어조회
	 * 1 apple 사과
	 * ---서브 메뉴-----
	 * 1.단어수정
	 * 2.단어삭제
	 * 3.뒤로가기
	 * 메뉴 선택 : 1
	 * ---------------
	 * 수정할 단어 번호 : 1
	 * 단어를 입력(영어):banana
	 * 뜻을 입력 (한글):바나나
	 * 수정되었습니다.
	 * ---------------
	 *  * 메뉴
	 * 1.단어추가 
	 * 2.단어조회
	 * 3.프로그램종료
	 * 메뉴 선택 :2
	 * ------------
	 * * 단어조회
	 * 1 banana 바나나
	 * ---서브 메뉴-----
	 * 1.단어수정
	 * 2.단어삭제
	 * 3.뒤로가기
	 * 메뉴 선택 : 2
	 * ---------------
	 * 삭제하실 단어 번호 입력:1
	 * ---------------
	 * 삭제되었습니다.
	 * ---------------
	 * *  * 메뉴
	 * 1.단어추가 
	 * 2.단어조회
	 * 3.프로그램종료
	 * 메뉴 선택 :3
	 * 프로그램 종료
	 * 
	 * 3. 필요한 메서드 구현
	 * 
	 * */
	

	public static void main(String[] args) {
		//문자열 비교 예제
		//데이터 영역에 abc가 추가되고 추가된 주소를 가져와서 str1에 저장
		String str1="abc";
		
		//이미 추가된 abc의 주소를 가져와서 str2에 저장 => str1과 str2가 공유
		String str2="abc";
		
		//생성된 문자열 인스턴스의 주소를 str3에 저장
		String str3=new String("abc");
		
		//참조 변수에서 ==는 주소를 비교
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str2 == str3);
		
		//문자열은 equals라는 메서드를 통해 비교
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str2.equals(str3));
		
	}

}
