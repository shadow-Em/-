package javaweb.dao;

import java.util.List;

public interface BuyOneDao {
	int buyOne(String uNo,String pNo);
	List<String> buyAll(String uNo);
}
