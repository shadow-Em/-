package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import javaweb.dao.LoadMyBoughtDao;
import javaweb.pojo.BoughtCard;

public class LoadMyBoughtDaoImpl implements LoadMyBoughtDao {
	public List<BoughtCard> loadMyBought(String uNo)
	{
		//����JDBC����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BoughtCard> list=null;
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//����SQL����
			String sql="call LoadMyBought(?);";
			//����SQL�������
			ps=conn.prepareStatement(sql);
			ps.setString(1, uNo);
			//ִ��
			rs=ps.executeQuery();
			list=new BeanListHandler<BoughtCard>(BoughtCard.class).handle(rs);
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
		return list;
	}
}
