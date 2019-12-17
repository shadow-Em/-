package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.dao.LoginDao;
import javaweb.pojo.User;

public class LoginDaoImpl implements LoginDao {
	public User checkUser(String uNo,String uPassword)
	{
		//����JDBC����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=new User();
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//����SQL����
			String sql="call Login(?,?);";
			//����SQL�������
			ps=conn.prepareStatement(sql);
			//��ռλ����ֵ
			ps.setString(1, uNo);
			ps.setString(2, uPassword);
			//ִ��
			rs=ps.executeQuery();
			while(rs.next())
			{
				if(rs.getString("uNo")!=null)
				{
					u.setuNo(rs.getString("uNo"));
				}
				if(rs.getString("uName")!=null)
				{
					u.setuName(rs.getString("uName"));
				}
				if(rs.getString("uPassword")!=null)
				{
					u.setuPassword(rs.getString("uPassword"));
				}
				if(rs.getString("uEmail")!=null)
				{
					u.setuEmail(rs.getString("uEmail"));
				}
				if(rs.getString("uAddress")!=null)
				{
					u.setuAddress(rs.getString("uAddress"));
				}
				u.setuBalance(rs.getDouble("uBalance"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return u;
	}
}
