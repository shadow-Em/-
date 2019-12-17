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
		//����JDBC����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BoughtProduct> list=null;
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//����SQL����
			String sql="call LoadBoughtProduct();";
			//����SQL�������
			ps=conn.prepareStatement(sql);
			//ִ��
			rs=ps.executeQuery();
			list=new BeanListHandler<BoughtProduct>(BoughtProduct.class).handle(rs);
			for(BoughtProduct i:list)
			{
				if(i.getpNumber()==-1)
					i.setpStatus("���¼�");
				else if(i.getpNumber()==0)
					i.setpStatus("����");
				else if(i.getpNumber()<=100)
					i.setpStatus("������");
				else if(i.getpNumber()>100)
					i.setpStatus("������");
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
