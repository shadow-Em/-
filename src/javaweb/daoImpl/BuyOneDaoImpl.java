package javaweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javaweb.dao.BuyOneDao;
import javaweb.tools.RandomNum;

public class BuyOneDaoImpl implements BuyOneDao {
	public int buyOne(String uNo,String pNo)
	{
		int exist=1;
		//����JDBC����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		RandomNum rn=new RandomNum();
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			String rNo=rn.createOtherNo();
			//String pName="";
			//String uEmail="";
			//����SQL����
			String sql="call BuyOne(?,?,?,?);";
			//����SQL�������
			ps=conn.prepareStatement(sql);
			ps.setString(1, rNo);
			ps.setString(2, uNo);
			ps.setString(3, pNo);
			ps.setString(4, time);
			//ִ��
			rs=ps.executeQuery();
			while(rs.next())
			{
				exist=rs.getInt("exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		return exist;
	}
	
	
	public List<String> buyAll(String uNo)
	{
		List<String> f = new ArrayList<String>();
		List<String> gf = new ArrayList<String>();
		List<String> rf = new ArrayList<String>();
		//����JDBC����
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//��ȡ���Ӷ���
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shadowshop?useSSL=false&serverTimezone=UTC","root","root");
			//����SQL����
			String sql="select pName,pNo from product where product.pNo in(select r.pNo from record r where uNo=? and rType=2);";
			//����SQL�������
			ps=conn.prepareStatement(sql);
			ps.setString(1, uNo);
			//ִ��
			rs=ps.executeQuery();
			while(rs.next())
			{
				f.add(rs.getString("pName"));
				gf.add(rs.getString("pNo"));
			}
			for(int i=0;i<gf.size();i++)
			{
				int exist=buyOne(uNo,gf.get(i));
				if(exist==3||exist==4) {
					rf.add(f.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		return rf;
	}
}

