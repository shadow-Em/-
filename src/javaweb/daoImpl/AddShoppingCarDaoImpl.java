package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javaweb.dao.AddShoppingCarDao;
import javaweb.tools.RandomNum;

public class AddShoppingCarDaoImpl implements AddShoppingCarDao {
	public void addShoppingCar(String uNo,String pNo,int rType)
	{
		//����JDBC����
		Connection conn=null;
		PreparedStatement ps=null;
		String f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		RandomNum rn=new RandomNum();
		String rNo=UUID.randomUUID().toString();
		System.out.println(rNo);
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//String rNo=rn.createOtherNo();
			
			//����SQL����
			String sql="call AddShoppingCar(?,?,?,?);";
			//����SQL�������
			ps=conn.prepareStatement(sql);
			ps.setString(1, rNo);
			ps.setString(2, uNo);
			ps.setString(3, pNo);
			ps.setString(4, f);
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
