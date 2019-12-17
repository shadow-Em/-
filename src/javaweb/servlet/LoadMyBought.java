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

import javaweb.dao.LoadMyBoughtDao;
import javaweb.daoImpl.LoadMyBoughtDaoImpl;
import javaweb.pojo.BoughtCard;
import javaweb.pojo.User;

/**
 * 加载我的购买记录
 */
@WebServlet(name = "load-my-bought", urlPatterns = { "/load-my-bought" })
public class LoadMyBought extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html;charset=utf-8");
    	resp.setHeader("Access-Control-Allow-Origin", "*");
    	resp.setCharacterEncoding("utf-8");
    	List<BoughtCard> list=new ArrayList<BoughtCard>();
    	BoughtCard b=new BoughtCard();
    	
    	HttpSession hs=req.getSession();
    	if(hs.getAttribute("user")==null) {
    		b.setExist(0);
    		list.add(b);
    	}
    	else {
			User user=(User) hs.getAttribute("user");
			LoadMyBoughtDao lb=new LoadMyBoughtDaoImpl();
			try {
				list=lb.loadMyBought(user.getuNo());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if(list.isEmpty()) {
				list.add(b);
			}
		}
    	resp.getWriter().write(new Gson().toJson(list));
	}

}
