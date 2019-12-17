package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.handlers.BeanHandler;
import javaweb.dao.GetUserInfoDao;
import javaweb.pojo.User;

public class GetUserInfoDaoImpl implements GetUserInfoDao {
	public User getUserInfo(String uNo)
	{
		//����JDBC����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;	
		User u=null;
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//����SQL����
			String sql="select * from user where uNo=?;";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uNo);
			rs=ps.executeQuery();
			u=new BeanHandler<User>(User.class).handle(rs);
		} catch (Exception e) {
			// TODO: handle exception
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
