package kr.kh.account.service;

import java.util.List;
import java.util.Locale.Category;

import com.mysql.cj.conf.ConnectionUrl.Type;

import accountbook.Item;

public interface AccountService {
	List<Type> getTypeList();

	List<Category> getCategoryList(String type);

	boolean insertItem(Item item);

	List<Item> getItemListByDate(String date);

	boolean updateItem(Item item);

	boolean deleteItem(int it_num);


}
