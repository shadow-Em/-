package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javaweb.dao.ChangeUserInfoDao;

public class ChangeUserInfoDaoImpl implements ChangeUserInfoDao {
	public void changeUserInfo(String uNo,String uName,String uPassword,String uEmail,String uAddress,double uBalance)
	{
		//����JDBC����
		Connection conn=null;
		PreparedStatement ps=null;
		//List<User> uList=new ArrayList<User>();
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//����SQL����
			String sql="update user set uName=?,uPassword=?,uEmail=?,uAddress=?,uBalance=? where uNo=?;";
			//����SQL�������
			ps=conn.prepareStatement(sql);
			ps.setString(1, uName);
			ps.setString(2, uPassword);
			ps.setString(3, uEmail);
			ps.setString(4, uAddress);
			ps.setDouble(5, uBalance);
			ps.setString(6, uNo);
			//ִ��
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}
