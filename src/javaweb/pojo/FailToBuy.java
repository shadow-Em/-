package javaweb.pojo;

import java.util.List;

public class FailToBuy {
	private int exist=1;
	private List<String>failName;
	public int getExist() {
		return exist;
	}
	public void setExist(int exist) {
		this.exist = exist;
	}
	public List<String> getFailName() {
		return failName;
	}
	public void setFailName(List<String> failName) {
		this.failName = failName;
	}
	@Override
	public String toString() {
		return "FailToBuy [exist=" + exist + ", failName=" + failName + "]";
	}
	
}
