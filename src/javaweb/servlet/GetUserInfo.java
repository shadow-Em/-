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
 * ��ȡsession�д洢���û���Ϣ
 */
@WebServlet(name = "get-user-info", urlPatterns = { "/get-user-info" })
public class GetUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("text/html;charset=utf-8");
		
		//��ȡ������Ϣ
		HttpSession hs=req.getSession();
		User user=new User();
		
		//����������Ϣ
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
		
		//��Ӧ������
		resp.getWriter().write(new Gson().toJson(user));
	}
}
