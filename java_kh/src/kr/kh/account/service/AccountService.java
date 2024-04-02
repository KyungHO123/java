package kr.kh.account.service;

import java.util.List;

import kr.kh.account.model.vo.Category;
import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;


public interface AccountService {
	List<Type> getTypeList();

	List<Category> getCategoryList(String type);

	boolean insertItem(Item item);

	List<Item> getItemListByDate(String date);

	boolean updateItem(Item item);

	boolean deleteItem(int it_num);


}
