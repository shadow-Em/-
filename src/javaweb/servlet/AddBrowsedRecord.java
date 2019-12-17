package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaweb.dao.AddBrowsedRecordDao;
import javaweb.daoImpl.AddBrowsedRecordDaoImpl;
import javaweb.pojo.User;

/**
 * 添加浏览记录
 * 浏览-0
 * 加入购物车-1
 * 购买-2
 */
@WebServlet(name = "add-browsed-record", urlPatterns = { "/add-browsed-record" })
public class AddBrowsedRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		int exist=1;
		String pNo="";
		HttpSession hs=req.getSession();

		//处理请求信息
		if(hs.getAttribute("user")==null)
		{
			exist=0;
		}
		else {
			User u=(User) hs.getAttribute("user");
			pNo=req.getParameter("pNo");
			AddBrowsedRecordDao ad=new AddBrowsedRecordDaoImpl();
			try {
				ad.addBrowsedRecord(u.getuNo(),pNo);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		//响应处理结果
		resp.getWriter().write("{\"exist\":"+exist+"}");
	}

}
