package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaweb.dao.BuyOneDao;
import javaweb.daoImpl.BuyOneDaoImpl;
import javaweb.pojo.User;
import javaweb.tools.MailUtils;

/**
 * 购买一件商品
 */
@WebServlet(name = "buy-one", urlPatterns = { "/buy-one" })
public class BuyOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	   	resp.setContentType("text/html;charset=utf-8");
	   	resp.setHeader("Access-Control-Allow-Origin", "*");
	   	resp.setCharacterEncoding("utf-8");
	   	int exist=1;
	   	String pNo="";
	   	User user=null;
	   	double pMoney=0;
	   	HttpSession hs=req.getSession();
	   	if(hs.getAttribute("user")==null)
	   	{
	   		exist=0;
	   	}
	   	else {
			user=(User) hs.getAttribute("user");
			pNo=req.getParameter("pNo");
			pMoney=Double.parseDouble(req.getParameter("pMoney"));
			if(user.getuBalance()<pMoney)
			{
				exist=2;
			}
			else {
				BuyOneDao bd=new BuyOneDaoImpl();
				try {
					exist=bd.buyOne(user.getuNo(), pNo);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	   	if(exist==1)
	   	{
	   		try {
				String message="您购买的商品已发货哦，请注意查收！";
				MailUtils.sendMail(user.getuEmail(), message);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	   	}
	   	resp.getWriter().write("{\"exist\":"+exist+"}");
	}

}
