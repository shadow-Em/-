package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javaweb.dao.AddBrowsedRecordDao;
import javaweb.tools.RandomNum;

public class AddBrowsedRecordDaoImpl implements AddBrowsedRecordDao {
	public void addBrowsedRecord(String uNo,String pNo)
	{
		//声明JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;
		String f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		RandomNum rn=new RandomNum();
		String rNo=UUID.randomUUID().toString();
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//String rNo=rn.createOtherNo();
			//创建SQL命令
			String sql="call AddBrowsedRecord(?,?,?,?);";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			System.out.println(rNo);
			ps.setString(1, uNo);
			ps.setString(2, pNo);
			ps.setString(3, f);
			ps.setString(4, rNo);
			//执行
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
