package account;

public class AccountBook {
    String date; //날짜
    int amount; //금액
    String category; //카테고리


    //생성자 초기화
    public AccountBook(String date, int amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }
}
