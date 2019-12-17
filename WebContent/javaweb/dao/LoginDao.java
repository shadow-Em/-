package javaweb.dao;

import javaweb.pojo.User;

public interface LoginDao {
	User checkUser(String uNo,String uPassword);
}
