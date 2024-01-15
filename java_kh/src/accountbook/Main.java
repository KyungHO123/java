package accountbook;

public class Main {
	/* ==
==가계부====
	 * 1.수입,지출 조회
	 * 2.잔액 조회
	 * 3.프로그램 종료
 
	 * 날짜 , 품목 , 수입 , 지출 , 잔액 ,계정과목
	 * 입력 : 1
	 * ===수입 지출 조회===
	 * 1.수입 추가
	 * 2.수입 조회
	 * 3.지출 추가
	 * 4.지출 조회
	 * 메뉴 입력 : 1
	 * ===수입추가====
	 * 날짜 입력 :2024-01-05
	 * 수입 입력 :80000
	 * 계정과목:아르바이트
	 * ===수입추가====
	 * 날짜 입력 :2024-01-04
	 * 수입 입력 :80000
	 * 계정과목:아르바이트
	 * ===수입 지출 조회===
	 * 1.수입 추가
	 * 2.수입 조회
	 * 3.지출 추가
	 * 4.지출 조회
	 * 메뉴 입력 : 2
	 * ====수입 조회=====
	 * 2024-01-04 80000원 아르바이트
	 * 2024-01-05 80000원 아르바이트
	 * * ===수입 지출 조회===
	 * 1.수입 추가
	 * 2.수입 조회
	 * 3.지출 추가
	 * 4.지출 조회
	 * 메뉴 입력 : 3
	 * ===지출 추가====
	 * 날짜 입력 : 2024-01-04
	 * 지출 입력 : 20000
	 * 계정과목 : 식비
	 * ===수입 지출 조회===
	 * 1.수입 추가
	 * 2.수입 조회
	 * 3.지출 추가
	 * 4.지출 조회
	 * 메뉴 입력 : 4
	 * ====지출조회=====
	 * 2024-01-04 20000 식비
	 * ====잔액조회====
	 * 현재 잔액 :140000원 
	 * */
		

	public static void main(String[] args) {
		
		AccountBookProgram ap = new AccountBookProgram();
		ap.run();

	}

}