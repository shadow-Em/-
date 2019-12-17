package javaweb.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/*
 * 		生成唯一的随机数，做uNo哇pNo哇之类的。
 */
public class RandomNum {
	public String createUNo(String uid) {
		String uNo="";
		char first=uid.charAt(0);
		char end=uid.charAt(uid.length()-1);
		Date now = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MMdd"+first+end+"HHmmss");
		uNo=f.format(now);
		//生成：MMdd+uid第一位和最后一位+HHmmss
		return uNo;
	}
	public String createOtherNo() {
		String no="";
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random r = new Random();
		//生成
		Date now = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MM'"+str.charAt(r.nextInt(str.length()))+"'dd'"+str.charAt(r.nextInt(str.length()))+"'HHmmss");
		no=f.format(now);
		return no;
	}
}
