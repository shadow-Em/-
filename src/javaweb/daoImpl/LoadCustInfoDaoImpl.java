package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import javaweb.dao.LoadCustInfoDao;
import javaweb.pojo.CustomerInfo;

public class LoadCustInfoDaoImpl implements LoadCustInfoDao {
	public List<CustomerInfo> loadCustomerInfo()
	{
		//声明JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<CustomerInfo> list=null;
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//创建SQL命令
			String sql="call LoadCustomerInfo();";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//执行
			rs=ps.executeQuery();
			list=new BeanListHandler<CustomerInfo>(CustomerInfo.class).handle(rs);
			for(CustomerInfo i:list)
			{
				if(i.getrType()==1)
					i.setuDo("用户浏览");
				else if(i.getrType()==2)
					i.setuDo("加入购物车");
				else if(i.getrType()==3)
					i.setuDo("用户购买");
			}
			System.out.println(list);
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
