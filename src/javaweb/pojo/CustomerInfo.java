package javaweb.pojo;

public class CustomerInfo {
	private String rTime = "";
	private String uName = "";
	private String uDo = "";
	private int rType = 0;
	private String pName = "";
	private int pBuyNum = 0;
	public String getrTime() {
		return rTime;
	}
	public void setrTime(String rTime) {
		this.rTime = rTime;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuDo() {
		return uDo;
	}
	public void setuDo(String uDo) {
		this.uDo = uDo;
	}
	public int getrType() {
		return rType;
	}
	public void setrType(int rType) {
		this.rType = rType;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpBuyNum() {
		return pBuyNum;
	}
	public void setpBuyNum(int pBuyNum) {
		this.pBuyNum = pBuyNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pBuyNum;
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + ((rTime == null) ? 0 : rTime.hashCode());
		result = prime * result + rType;
		result = prime * result + ((uDo == null) ? 0 : uDo.hashCode());
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerInfo other = (CustomerInfo) obj;
		if (pBuyNum != other.pBuyNum)
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (rTime == null) {
			if (other.rTime != null)
				return false;
		} else if (!rTime.equals(other.rTime))
			return false;
		if (rType != other.rType)
			return false;
		if (uDo == null) {
			if (other.uDo != null)
				return false;
		} else if (!uDo.equals(other.uDo))
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomerInfo [rTime=" + rTime + ", uName=" + uName + ", uDo=" + uDo + ", rType=" + rType + ", pName="
				+ pName + ", pBuyNum=" + pBuyNum + "]";
	}
	public CustomerInfo(String rTime, String uName, String uDo, int rType, String pName, int pBuyNum) {
		super();
		this.rTime = rTime;
		this.uName = uName;
		this.uDo = uDo;
		this.rType = rType;
		this.pName = pName;
		this.pBuyNum = pBuyNum;
	}
	public CustomerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
