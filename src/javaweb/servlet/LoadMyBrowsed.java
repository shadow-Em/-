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

import javaweb.dao.LoadMyBrowsedDao;
import javaweb.daoImpl.LoadMyBrowsedDaoImpl;
import javaweb.pojo.BrowsedCard;
import javaweb.pojo.User;

/**
 * 加载我的浏览记录
 */
@WebServlet(name = "load-my-browsed", urlPatterns = { "/load-my-browsed" })
public class LoadMyBrowsed extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html;charset=utf-8");
    	resp.setHeader("Access-Control-Allow-Origin", "*");
    	resp.setCharacterEncoding("utf-8");
    	List<BrowsedCard> list=new ArrayList<BrowsedCard>();
    	BrowsedCard b=new BrowsedCard();
    	
    	HttpSession hs=req.getSession();
    	if(hs.getAttribute("user")==null)
    	{
    		b.setExist(0);
    		list.add(b);
    	}
    	else {
			User user=(User) hs.getAttribute("user");
			LoadMyBrowsedDao ld=new LoadMyBrowsedDaoImpl();
			try {
				list=ld.loadBrowsedCard(user.getuNo());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if(list.isEmpty())
			{
				list.add(b);
			}
		}
    	resp.getWriter().write(new Gson().toJson(list));
	}

}
