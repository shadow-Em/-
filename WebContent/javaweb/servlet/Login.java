package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import javaweb.dao.LoginDao;
import javaweb.daoImpl.LoginDaoImpl;
import javaweb.pojo.User;

/**
 *  用户登录
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置响应编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//获取请求信息
		String uNo=req.getParameter("uNo");
		String uPassword=req.getParameter("uPassword");
		/*
		String uNo="test";
		String uPassword="111";*/
		
		//处理请求信息
		User user=new User();
		LoginDao ld=new LoginDaoImpl();
		user=ld.checkUser(uNo, uPassword);

		//响应处理结果
		resp.getWriter().write(new Gson().toJson(user));
	}

}
