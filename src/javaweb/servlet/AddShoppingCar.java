package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaweb.dao.AddShoppingCarDao;
import javaweb.daoImpl.AddShoppingCarDaoImpl;
import javaweb.pojo.User;

/**
 * 加入购物车
 */
@WebServlet(name = "add-shopping-car", urlPatterns = { "/add-shopping-car" })
public class AddShoppingCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	   	resp.setContentType("text/html;charset=utf-8");
	   	resp.setHeader("Access-Control-Allow-Origin", "*");
	   	resp.setCharacterEncoding("utf-8");
	   	int exist=1;
	   	int rType=2;
	   	String pNo="";
	   	HttpSession hs=req.getSession();
	   	if(hs.getAttribute("user")==null)
	   	{
	   		exist=0;
	   	}
	   	else {
	   		User user=(User) hs.getAttribute("user");
	   		pNo=req.getParameter("pNo");
	   		AddShoppingCarDao ad=new AddShoppingCarDaoImpl();
	   		try {
				ad.addShoppingCar(user.getuNo(), pNo, rType);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	   	resp.getWriter().write("{\"exist\":"+exist+"}");
	}

}
