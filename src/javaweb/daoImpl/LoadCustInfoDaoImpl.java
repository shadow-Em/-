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
		//����JDBC����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<CustomerInfo> list=null;
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//����SQL����
			String sql="call LoadCustomerInfo();";
			//����SQL�������
			ps=conn.prepareStatement(sql);
			//ִ��
			rs=ps.executeQuery();
			list=new BeanListHandler<CustomerInfo>(CustomerInfo.class).handle(rs);
			for(CustomerInfo i:list)
			{
				if(i.getrType()==1)
					i.setuDo("�û����");
				else if(i.getrType()==2)
					i.setuDo("���빺�ﳵ");
				else if(i.getrType()==3)
					i.setuDo("�û�����");
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
