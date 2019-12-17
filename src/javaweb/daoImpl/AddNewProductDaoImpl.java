package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javaweb.dao.AddNewProductDao;
import javaweb.pojo.Product;

public class AddNewProductDaoImpl implements AddNewProductDao {
	public void addNewProduct(Product p)
	{
		//声明JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="";
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			if(p.getExist()==0)
			{
				sql="insert into product values(?,?,?,?,?,?,?,?,?);";
				ps=conn.prepareStatement(sql);
				ps.setString(1, p.getpNo());
				ps.setString(2, p.getpName());
				ps.setInt(3, p.getpNumber());
				ps.setString(4, p.getpUrl());
				ps.setString(5, p.getpIntroduce());
				ps.setDouble(6, p.getpMoney());
				ps.setInt(7, 1);
				ps.setString(8, p.getpDetail());
				ps.setString(9, p.getpUrl2());
				ps.executeUpdate();
			}
			else {
				sql="call ChangeProduct(?,?,?,?,?,?,?,?);";
				ps=conn.prepareStatement(sql);
				ps.setString(1, p.getpNo());
				ps.setString(2, p.getpName());
				ps.setInt(3, p.getpNumber());
				ps.setString(4, p.getpUrl());
				ps.setString(5, p.getpIntroduce());
				ps.setDouble(6, p.getpMoney());
				//ps.setInt(7, 1);
				ps.setString(7, p.getpDetail());
				ps.setString(8, p.getpUrl2());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
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
