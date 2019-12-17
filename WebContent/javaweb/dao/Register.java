package javaweb.dao;

public interface Register {
	void createUser(String uNo,String uName,String uPassword,String uEmail,double uBalance);
	int checkId(String uNo);
}
