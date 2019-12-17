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
		//声明JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=new User();
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//创建SQL命令
			String sql="call Login(?,?);";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, uNo);
			ps.setString(2, uPassword);
			//执行
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
