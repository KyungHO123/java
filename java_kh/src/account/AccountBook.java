package account;

import lombok.Data;

@Data
public class AccountBook {
    String date; //날짜
    int amount; //금액
    String category; //카테고리


    public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	//생성자 초기화
    public AccountBook(String date, int amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }


	@Override
	public String toString() {
		return "AccountBook [date=" + date + ", amount=" + amount + ", category=" + category + "]";
	}
    
    
}
