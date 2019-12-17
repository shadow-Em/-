package javaweb.dao;

import java.util.List;

import javaweb.pojo.BrowsedCard;

public interface LoadMyBrowsedDao {
	List<BrowsedCard> loadBrowsedCard(String uNo);
}
