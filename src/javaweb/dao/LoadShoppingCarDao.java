package javaweb.dao;

import java.util.List;

import javaweb.pojo.ShoppingCar;

public interface LoadShoppingCarDao {
	List<ShoppingCar> loadShoppingCar(String uNo);
}
