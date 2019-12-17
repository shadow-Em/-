package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import javaweb.dao.ChangeUserInfoDao;
import javaweb.daoImpl.ChangeUserInfoDaoImpl;
import javaweb.pojo.User;

/**
 * 修改个人信息
 */
@WebServlet(name = "change-user-info", urlPatterns = { "/change-user-info" })
public class ChangeUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String uNo="";
    	String uPassword="";
    	String uEmail="";
    	String uName="";
    	String uAddress="";
    	double uBalance=0;
    	User u = new User();
    	HttpSession hs= req.getSession();
    	if(hs.getAttribute("user")==null) {
    		u.setExist(0);	
    	}
    	else {
    		u=(User) hs.getAttribute("user");
    		if(req.getParameter("uNo")!=null)
        		u.setuNo(req.getParameter("uNo"));
        	if(req.getParameter("uAddress")!=null)
        		u.setuAddress(req.getParameter("uAddress")); 
        	if(req.getParameter("uPassword")!=null)
        		u.setuPassword(req.getParameter("uPassword"));
        	if(req.getParameter("uEmail")!=null)
        		u.setuEmail(req.getParameter("uEmail"));
        	if(req.getParameter("uName")!=null)
        		u.setuName(req.getParameter("uName"));
        	if(req.getParameter("uBalance")!=null)
        		u.setuBalance(Double.parseDouble(req.getParameter("uBalance")));
//        	System.out.println("修改"+u.toString());
        	hs.setAttribute("user", u);
        	ChangeUserInfoDao cd=new ChangeUserInfoDaoImpl();
        	try {
				cd.changeUserInfo(u.getuNo(),u.getuName(),u.getuPassword(),u.getuEmail(),u.getuAddress(),u.getuBalance());				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	resp.getWriter().write(new Gson().toJson(u));		
		//处理请求信息
		//响应处理结果
	}

}
