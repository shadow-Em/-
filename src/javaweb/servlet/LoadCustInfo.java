package javaweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import javaweb.dao.LoadCustInfoDao;
import javaweb.daoImpl.LoadCustInfoDaoImpl;
import javaweb.pojo.CustomerInfo;

/**
 * 加载顾客信息
 */
@WebServlet(name = "load-customer-info", urlPatterns = { "/load-customer-info" })
public class LoadCustInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
      	resp.setContentType("text/html;charset=utf-8");
      	resp.setHeader("Access-Control-Allow-Origin", "*");
      	resp.setCharacterEncoding("utf-8");
      	List<CustomerInfo> list=new ArrayList<CustomerInfo>();
      	CustomerInfo c=new CustomerInfo();
      	
      	HttpSession hs=req.getSession();
      	if(hs.getAttribute("user")==null)
      	{
      		list.add(c);
      	}
      	else {
			LoadCustInfoDao ld=new LoadCustInfoDaoImpl();
			try {
				list=ld.loadCustomerInfo();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if(list.isEmpty())
			{
				list.add(c);
			}
		}
      	resp.getWriter().write(new Gson().toJson(list));
	}

}
