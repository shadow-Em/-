package javaweb.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*
 * 		����Ψһ�����������uNo��pNo��֮��ġ�
 */
public class RandomNum {
	public String createUNo(String uid) {
		String uNo="";
		char first=uid.charAt(0);
		char end=uid.charAt(uid.length()-1);
		Date now = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MMdd"+first+end+"HHmmss");
		uNo=f.format(now);
		//���ɣ�MMdd+uid��һλ�����һλ+HHmmss
		return uNo;
	}
	public String createOtherNo() {
		String no="";
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random r = new Random();
		//����
		Date now = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MM'"+str.charAt(r.nextInt(str.length()))+"'dd'"+str.charAt(r.nextInt(str.length()))+"'HHmmss");
		no=f.format(now);
		return no;
	}
}
