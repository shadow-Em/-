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

import javaweb.dao.LoadShoppingCarDao;
import javaweb.daoImpl.LoadShoppingCarDaoImpl;
import javaweb.pojo.ShoppingCar;
import javaweb.pojo.User;

/**
 * º”‘ÿπ∫ŒÔ≥µ
 */
@WebServlet(name = "load-shopping-car", urlPatterns = { "/load-shopping-car" })
public class LoadShoppingCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html;charset=utf-8");
    	resp.setHeader("Access-Control-Allow-Origin", "*");
    	resp.setCharacterEncoding("utf-8");
    	List<ShoppingCar> sList=new ArrayList<ShoppingCar>();
    	ShoppingCar s=new ShoppingCar();
    	
    	HttpSession hs=req.getSession();
    	if(hs.getAttribute("user")==null)
    	{
    		s.setExist(0);
    		sList.add(s);
    	}
    	else {
			User user=(User) hs.getAttribute("user");
			LoadShoppingCarDao ld=new LoadShoppingCarDaoImpl();
			try {
				sList=ld.loadShoppingCar(user.getuNo());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if(sList.isEmpty())
			{
				sList.add(s);
			}
		}
    	System.out.println(new Gson().toJson(sList));
    	resp.getWriter().write(new Gson().toJson(sList));
	}

}
