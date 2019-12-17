package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaweb.dao.LoadShoppingCarDao;
import javaweb.pojo.ShoppingCar;

public class LoadShoppingCarDaoImpl implements LoadShoppingCarDao {
	public List<ShoppingCar> loadShoppingCar(String uNo)
	{
		//����JDBC����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ShoppingCar> list=new ArrayList<ShoppingCar>();
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//����SQL����
			String sql="SELECT r.rNo rNo, p.pNo,p.pName,p.pIntroduce,p.pUrl,p.pDetail,p.pMoney,p.pNumber,p.pType,p.pUrl2,r.pBuyNum pBuyNum FROM record r LEFT JOIN product p ON r.pNo = p.pNo WHERE r.uNo = ? AND r.rType = 2 ;";
			//����SQL�������
			ps=conn.prepareStatement(sql);
			ps.setString(1, uNo);
			//ִ��
			rs=ps.executeQuery();
			while(rs.next())
			{
				ShoppingCar s=new ShoppingCar();
				s.setrNo(rs.getString("rNo"));
				s.setpNo(rs.getString("p.pNo"));
				s.setpName(rs.getString("p.pName"));
				s.setpIntroduce(rs.getString("p.pIntroduce"));
				s.setpUrl(rs.getString("p.pUrl"));
				s.setpDetail(rs.getString("p.pDetail"));
				s.setpUrl2(rs.getString("p.pUrl2"));
				s.setpMoney(rs.getDouble("p.pMoney"));
				s.setpNumber(rs.getInt("p.pNumber"));
				s.setpType(rs.getInt("p.pType"));
				//s.setExist(1);
				s.setpBuyNum(rs.getInt("pBuyNum"));
				list.add(s);
			}
			//list=new BeanListHandler<ShoppingCar>(ShoppingCar.class).handle(rs);
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
