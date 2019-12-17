package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javaweb.dao.DeleteOneDao;

public class DeleteOneDaoImpl implements DeleteOneDao {
	public void deleteOne(String uNo,int pBuyNum,String pNo)
	{
		//声明JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;
		//ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			String sql="";
			if(pBuyNum>1)
			{
				sql="update record set `pBuyNum`=`pBuyNum`-1 where pNo=? and uNo=? and rType=2;";
			}
			else {
				sql="delete from record where pNo=? and uNo=? and rType=2;";
			}
			ps=conn.prepareStatement(sql);
			ps.setString(1, pNo);
			ps.setString(2, uNo);
			ps.executeUpdate();
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
