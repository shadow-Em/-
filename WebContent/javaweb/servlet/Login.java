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
 *  �û���¼
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������Ӧ�����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//��ȡ������Ϣ
		String uNo=req.getParameter("uNo");
		String uPassword=req.getParameter("uPassword");
		/*
		String uNo="test";
		String uPassword="111";*/
		
		//����������Ϣ
		User user=new User();
		LoginDao ld=new LoginDaoImpl();
		user=ld.checkUser(uNo, uPassword);

		//��Ӧ������
		resp.getWriter().write(new Gson().toJson(user));
	}

}
