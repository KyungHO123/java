package account;




import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Scanner;

import lombok.Data;
@Data
public class AcoountBookProgram implements AccountProgram {
    private final Scanner sc= new Scanner(System.in);
    List<AccountBook>list = new ArrayList<AccountBook>();
    
    @Override
    public void run() {
        int menu;

        do {
        printMenu();//메뉴출력
        menu=sc.nextInt();//메뉴선택
        runMenu(menu);//메뉴실행
        }while(menu != 3);



    }

    @Override
    public void printMenu() {
        System.out.println("===메뉴선택===");
        System.out.println("1.수입추가");
        System.out.println("2.수입조회");
        System.out.println("3.지출추가");
        System.out.println("4.지출내역");
        System.out.println("5.잔액조회");
        System.out.println("6.가계부종료");
        System.out.println("=============");
        System.out.print("메뉴 입력 : ");

    }

    @Override
    public void runMenu(int menu) {
        switch (menu){
            case 1:
                System.out.println("===수입추가===");
                addIncome();
                break;

            case 2:
                System.out.println("===수입조회===");
                showIncome();
                break;

            case 3:
                System.out.println("===지출추가===");
                addExpense();
                break;

            case 4:
                System.out.println("===지출조회===");
                showExpense();
                break;
                
            case 5:
                System.out.println("===잔액조회===");
                balance();
                break;
                
            case 6:
                System.out.println("====종료합니다====");
                break;
                
            default:
                System.out.println("잘못 입력 하셨습니다.");

        }

    }
    //잔액조회
    private void balance() {
    }
    //지출조회
    private void showExpense() {

    }
    //지출추가
    private void addExpense() {
    	System.out.print("날짜 입력 : " );
    	sc.nextLine(); //엔터
        String date = sc.nextLine();
        
        System.out.print("지출 입력 : ");
        int amount = sc.nextInt();
        
        System.out.print("계정과목 : ");
        sc.nextLine();// 엔터
        String category = sc.nextLine();
        
        list.add(new AccountBook(date, amount, category));
        System.out.println("지출이 추가 되었습니다.");
    }
    //수입조회
    private void showIncome() {
    }
    //수입추가
    private void addIncome() {
        System.out.print("날짜 입력 : " );
        sc.nextLine(); //엔터
        String date = sc.nextLine();
        
        System.out.print("수입 입력 : ");
        int amount = sc.nextInt();

        System.out.print("계정과목 : ");
        sc.nextLine();// 엔터
        String category = sc.nextLine();
        //리스트 수입내역
        list.add(new AccountBook(date,amount,category));
        System.out.println("수입이 추가되었습니다.");

    }
}
