package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import javaweb.dao.LoadBoughtProductDao;
import javaweb.pojo.BoughtProduct;

public class LoadBoughtProductDaoImpl implements LoadBoughtProductDao {
	public List<BoughtProduct> loadBoughtProduct()
	{
		//声明JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BoughtProduct> list=null;
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//创建SQL命令
			String sql="call LoadBoughtProduct();";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//执行
			rs=ps.executeQuery();
			list=new BeanListHandler<BoughtProduct>(BoughtProduct.class).handle(rs);
			for(BoughtProduct i:list)
			{
				if(i.getpNumber()==-1)
					i.setpStatus("已下架");
				else if(i.getpNumber()==0)
					i.setpStatus("售罄");
				else if(i.getpNumber()<=100)
					i.setpStatus("库存紧张");
				else if(i.getpNumber()>100)
					i.setpStatus("库存充足");
				i.setpAllMoney(i.getpBuyNum()*i.getpMoney());
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
