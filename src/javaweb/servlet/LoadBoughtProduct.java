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

import javaweb.dao.LoadBoughtProductDao;
import javaweb.daoImpl.LoadBoughtProductDaoImpl;
import javaweb.pojo.BoughtProduct;
//import javaweb.pojo.User;

/**
 * 加载已购商品信息
 */
@WebServlet(name = "load-bought-product", urlPatterns = { "/load-bought-product" })
public class LoadBoughtProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
      	resp.setContentType("text/html;charset=utf-8");
      	resp.setHeader("Access-Control-Allow-Origin", "*");
      	resp.setCharacterEncoding("utf-8");
      	List<BoughtProduct> list=new ArrayList<BoughtProduct>();
      	BoughtProduct bp=new BoughtProduct();
      	
      	HttpSession hs=req.getSession();
      	if(hs.getAttribute("user")==null)
      	{
      		bp.setExist(0);
      		list.add(bp);
      	}
      	else {
			//User user=(User) hs.getAttribute("user");
			LoadBoughtProductDao ld=new LoadBoughtProductDaoImpl();
			try {
				list=ld.loadBoughtProduct();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if(list.isEmpty())
			{
				list.add(bp);
			}
		}
      	resp.getWriter().write(new Gson().toJson(list));
	}

}
