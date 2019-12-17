package javaweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javaweb.dao.LoadGoodsDao;
import javaweb.daoImpl.LoadGoodsDaoImpl;
import javaweb.pojo.Product;

/**
 * ������Ʒ��Ϣ
 */
@WebServlet(name = "load-goods", urlPatterns = { "/load-goods" })
public class LoadGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("text/html;charset=utf-8");
		
		//��ȡ������Ϣ
		List<Product> pList=new ArrayList<Product>();
		Product p=new Product();
		HttpSession hs=req.getSession();
		
		//����������Ϣ
		if(hs.getAttribute("user")==null)
		{
			p.setExist(0);
			pList.add(p);
		}
		else {
			LoadGoodsDao ld=new LoadGoodsDaoImpl();
			try {
				pList=ld.loadGoods();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if(pList.isEmpty()) {
				pList.add(p);
			}
		}
		
		//��Ӧ������
		//System.out.println(new Gson().toJson(pList));
		resp.getWriter().write(new Gson().toJson(pList));
		
	}

}
