package javaweb.dao;

import java.util.List;

import javaweb.pojo.BoughtCard;

public interface LoadMyBoughtDao {
	List<BoughtCard> loadMyBought(String uNo);
}
