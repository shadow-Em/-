package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import javaweb.dao.Register;
import javaweb.daoImpl.RegisterDaoImpl;
import javaweb.pojo.IsSuccess;

/**
 * 用户注册
 */
@WebServlet(name = "register", urlPatterns = { "/register" })
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置相应编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//获取请求信息
		String uNo=req.getParameter("uNo");
		String uName=req.getParameter("uName");
		String uPassword=req.getParameter("uPassword");
		String uEmail=req.getParameter("uEmail");
		double uBalance=Double.parseDouble(req.getParameter("uBalance"));
		System.out.println(uNo+uName+uPassword+uEmail+uBalance);
		/*
		String uNo="test";
		String uName="fortest";
		String uPassword="fortest";
		String uEmail="9999999@qq.com";
		double uBalance=8888.22;*/
		
		//处理请求信息
		Register r=new RegisterDaoImpl();
		r.createUser(uNo, uName, uPassword, uEmail, uBalance);
		/*int exist=0;
		exist=r.checkId(uNo);*/
		
		//响应处理结果
		/*if(exist==1)//存在该账号
		{
			resp.getWriter().write(new Gson().toJson(new IsSuccess(0)));
		}
		else if(exist==0)
		{
			resp.getWriter().write(new Gson().toJson(new IsSuccess(1)));
		}*/
		resp.getWriter().write(new Gson().toJson(new IsSuccess(1)));
	}

}
