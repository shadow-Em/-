package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaweb.dao.DeleteOneDao;
import javaweb.daoImpl.DeleteOneDaoImpl;
import javaweb.pojo.User;

/**
 * 从购物车删除某件商品
 */
@WebServlet(name = "delete-one", urlPatterns = { "/delete-one" })
public class DeleteOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	   	resp.setContentType("text/html;charset=utf-8");
	   	resp.setHeader("Access-Control-Allow-Origin", "*");
	   	resp.setCharacterEncoding("utf-8");
	   	int exist=1;
	   	String pNo="";
	   	int pBuyNum=0;
	   	HttpSession hs=req.getSession();
	   	if(hs.getAttribute("user")==null)
	   	{
	   		exist=0;
	   	}
	   	else {
			User user=(User) hs.getAttribute("user");
			pNo=req.getParameter("pNo");
			pBuyNum=Integer.parseInt(req.getParameter("pBuyNum"));
			DeleteOneDao d=new DeleteOneDaoImpl();
			try {
				d.deleteOne(user.getuNo(), pBuyNum, pNo);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	   	resp.getWriter().write("{\"exist\":"+exist+"}");
	}

}
