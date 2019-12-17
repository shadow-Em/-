package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import javaweb.dao.GetUserInfoDao;
import javaweb.daoImpl.GetUserInfoDaoImpl;
import javaweb.pojo.User;

/**
 * 获取session中存储的用户信息
 */
@WebServlet(name = "get-user-info", urlPatterns = { "/get-user-info" })
public class GetUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("text/html;charset=utf-8");
		
		//获取请求信息
		HttpSession hs=req.getSession();
		User user=new User();
		
		//处理请求信息
		if(hs.getAttribute("user")==null)
		{
			user.setExist(0);
		}
		else {
			GetUserInfoDao gd=new GetUserInfoDaoImpl();
			user=(User) hs.getAttribute("user");
			try {
				user=gd.getUserInfo(user.getuNo());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		//响应处理结果
		resp.getWriter().write(new Gson().toJson(user));
	}
}
