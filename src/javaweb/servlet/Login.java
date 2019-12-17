package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String uNo="";
		if(req.getParameter("uNo")!=null)
			uNo=req.getParameter("uNo");
		String uPassword="";
		if(req.getParameter("uPassword")!=null)
			uPassword=req.getParameter("uPassword");
		/*
		String uNo="test";
		String uPassword="111";*/
		
		//����session
		HttpSession hs=req.getSession();
		hs.setMaxInactiveInterval(60*25);
		//����������Ϣ
		LoginDao ld=new LoginDaoImpl();
		User user=null;
		try {
			user=ld.checkUser(uNo, uPassword);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(user.toString());

		if(!"".equals(user.getuNo()))
		{
			hs.setAttribute("user", user);
		}

		//��Ӧ������
		resp.getWriter().write(new Gson().toJson(user));
	}

}
