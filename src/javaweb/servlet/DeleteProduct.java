package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaweb.dao.DeleteProductDao;
import javaweb.daoImpl.DeleteProductDaoImpl;

/**
 * É¾³ýÉÌÆ·
 */
@WebServlet(name = "delete-product", urlPatterns = { "/delete-product" })
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	   	resp.setContentType("text/html;charset=utf-8");
	   	resp.setHeader("Access-Control-Allow-Origin", "*");
	   	resp.setCharacterEncoding("utf-8");
	   	int exist=1;
	   	String pNo = "";
	   	HttpSession hs= req.getSession();
	   	if(hs.getAttribute("user")==null)
	   	{
	   		exist=0;
	   	}
	   	else {
			pNo=req.getParameter("pNo");
			DeleteProductDao dd=new DeleteProductDaoImpl();
			try {
				dd.deleteProduct(pNo);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	   	resp.getWriter().write("{\"exist\":"+exist+"}");
	}

}
