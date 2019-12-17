package javaweb.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import javaweb.dao.AddNewProductDao;
import javaweb.daoImpl.AddNewProductDaoImpl;
import javaweb.pojo.Product;

/**
 * �������Ʒ
 */
@WebServlet(name = "add-new-product", urlPatterns = { "/add-new-product" })
public class AddNewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
	   	resp.setContentType("text/html;charset=utf-8");
	   	resp.setHeader("Access-Control-Allow-Origin", "*");
	   	resp.setCharacterEncoding("utf-8");
	   	Product p=new Product();
	   	DiskFileItemFactory factory=new DiskFileItemFactory();
	   	String tempPath=this.getServletContext().getRealPath("tempFolder");
	   	File f=new File(tempPath);
	   	if(!f.exists()) {
	   		f.mkdirs();
	   	}
	   	factory.setRepository(f);
	   	ServletFileUpload fileUpload=new ServletFileUpload(factory);
	   	fileUpload.setHeaderEncoding("utf-8");
	   	try {
			List<FileItem> fileItems=fileUpload.parseRequest(req);
			
			int num=1;
			for(int i=0;i<fileItems.size();i++)
			{
				if(fileItems.get(i).isFormField())
				{
					String s=fileItems.get(i).getString();
					s=new String(s.getBytes("iso8859-1"),"utf-8");
					p=new Gson().fromJson(s, Product.class);
					if("".equals(p.getpNo()))
					{
						p.setExist(0);
						p.setpNo(UUID.randomUUID().toString());
					}
				}
			}
			for(int i=0;i<fileItems.size();i++)
			{
				if(!fileItems.get(i).isFormField())
				{
					String afterDot=fileItems.get(i).getName();
					afterDot=afterDot.substring(afterDot.lastIndexOf("."));
					String fileName=p.getpNo()+"_"+num+afterDot;
					String webPath=this.getServletContext().getRealPath("img"+File.separator);
					if(num==1)
					{
						p.setpUrl(".."+File.separator+"img"+File.separator+fileName);
					}
					else {
						p.setpUrl2(".."+File.separator+"img"+File.separator+fileName);
					}
					num++;
					String filePath=webPath+File.separator+fileName;
					File file=new File(filePath);
					file.getParentFile().mkdirs();
					file.createNewFile();
					//��ȡ�ϴ����ļ���
					InputStream in = fileItems.get(i).getInputStream();
					//�򿪴����õ��ļ�
					FileOutputStream out =new FileOutputStream(file);
					//���Կ�
					byte[] buffer= new byte[1024];//ÿ�ζ�ȡ1B
					int len;
					//��ʼ��ȡ
					while((len=in.read(buffer))>0)
						out.write(buffer, 0,len);
					//�ر���
					in.close();
					out.close();
					//ɾ����ʱ�ļ�
					fileItems.get(i).delete();	
//					System.out.println("�ϴ��ɹ�");
				}
			}
			AddNewProductDao ad=new AddNewProductDaoImpl();
			ad.addNewProduct(p);
		} catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
