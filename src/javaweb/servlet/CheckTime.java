package javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ¼ì²éÊÇ·ñµÇÂ¼³¬Ê±
 */
@WebServlet(name = "check-time", urlPatterns = { "/check-time" })
public class CheckTime extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html;charset=utf-8");
    	resp.setHeader("Access-Control-Allow-Origin", "*");
    	resp.setCharacterEncoding("utf-8");
    	int exist=1;
    	HttpSession hs=req.getSession();
    	if(hs.getAttribute("user")==null)
    	{
    		exist=0;
    		resp.getWriter().write("{\"exist\":"+exist+"}");
    	}
    	else {
			resp.getWriter().write("{\"exist\":"+exist+"}");
		}
	}

}
