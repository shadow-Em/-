package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaweb.dao.Register;

public class RegisterDaoImpl implements Register {
	public void createUser(String uNo,String uName,String uPassword,String uEmail,double uBalance)
	{
		//声明JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;
		//ResultSet rs=null;
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//创建SQL命令
			String sql="insert into `user`(uNo,uName,uPassword,uEmail,uBalance) values(?,?,?,?,?);";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, uNo);
			ps.setString(2, uName);
			ps.setString(3, uPassword);
			ps.setString(4, uEmail);
			ps.setDouble(5, uBalance);
			//执行
			ps.execute();
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
	
	public int checkId(String uNo)
	{
		//声明JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int exist=0;
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//创建SQL命令
			String sql="call checkuNo(?);";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, uNo);
			//执行
			rs=ps.executeQuery();
			while(rs.next())
			{
				exist=rs.getInt("ex");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		return exist;
	}
}
