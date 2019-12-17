package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import javaweb.dao.LoadGoodsDao;
import javaweb.pojo.Product;

public class LoadGoodsDaoImpl implements LoadGoodsDao {
	public List<Product> loadGoods()
	{
		//声明JDBC对象
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				List<Product> plist=new ArrayList<Product>();
				try {
					//加载驱动
					Class.forName("com.mysql.cj.jdbc.Driver");
					//获取连接对象
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
					//创建SQL命令
					String sql="select * from product where pNumber>0;";
					//创建SQL命令对象
					ps=conn.prepareStatement(sql);
					
					//执行
					rs=ps.executeQuery();
					while(rs.next())
					{
						Product p=new Product();
						p.setpNo(rs.getString("pNo"));
						p.setpName(rs.getString("pName"));
						p.setpIntroduce(rs.getString("pIntroduce"));
						p.setpNumber(rs.getInt("pNumber"));
						p.setpUrl(rs.getString("pUrl"));
						p.setpType(rs.getInt("pType"));
						p.setpMoney(rs.getDouble("pMoney"));
						p.setpDetail(rs.getString("pDetail"));
						p.setpUrl2(rs.getString("pUrl2"));
						plist.add(p);
					}
					//plist=new BeanListHandler<Product>(Product.class).handle(rs);
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
				System.out.println(plist);
		return plist;
	}
}
