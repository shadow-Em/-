package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import javaweb.dao.BuyOneDao;
import javaweb.daoImpl.BuyOneDaoImpl;
import javaweb.pojo.FailToBuy;
import javaweb.pojo.User;
import javaweb.tools.MailUtils;

/**
 * 一键购买全部
 */
@WebServlet(name = "buy-all", urlPatterns = { "/buy-all" })
public class BuyAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	   	resp.setContentType("text/html;charset=utf-8");
	   	resp.setHeader("Access-Control-Allow-Origin", "*");
	   	resp.setCharacterEncoding("utf-8");
	   	int exist=1;
	   	FailToBuy f=new FailToBuy();
	   	User user=null;
	   	HttpSession hs=req.getSession();
	   	if(hs.getAttribute("user")==null)
	   	{
	   		exist=0;
	   	}
	   	else {
			user=(User) hs.getAttribute("user");
			BuyOneDao bd=new BuyOneDaoImpl();
			try {
				f.setFailName(bd.buyAll(user.getuNo()));
				if(f.getFailName().size()>0)
				{
					exist=3;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
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
	   	f.setExist(exist);
	   	resp.getWriter().write(new Gson().toJson(f));
	}

}
