package javaweb.pojo;

public class BoughtCard {
	private String rTime="";
	private String pName="";
	private String pIntroduce="";
	private double pMoney=0;
	private int exist=1;
	private int pBuyNum=0;
	private double pAllMoney = 0;
	public String getrTime() {
		return rTime;
	}
	public void setrTime(String rTime) {
		this.rTime = rTime;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpIntroduce() {
		return pIntroduce;
	}
	public void setpIntroduce(String pIntroduce) {
		this.pIntroduce = pIntroduce;
	}
	public double getpMoney() {
		return pMoney;
	}
	public void setpMoney(double pMoney) {
		this.pMoney = pMoney;
	}
	public int getExist() {
		return exist;
	}
	public void setExist(int exist) {
		this.exist = exist;
	}
	public int getpBuyNum() {
		return pBuyNum;
	}
	public void setpBuyNum(int pBuyNum) {
		this.pBuyNum = pBuyNum;
	}
	public double getpAllMoney() {
		return pAllMoney;
	}
	public void setpAllMoney(double pAllMoney) {
		this.pAllMoney = pAllMoney;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + exist;
		long temp;
		temp = Double.doubleToLongBits(pAllMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + pBuyNum;
		result = prime * result + ((pIntroduce == null) ? 0 : pIntroduce.hashCode());
		temp = Double.doubleToLongBits(pMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + ((rTime == null) ? 0 : rTime.hashCode());
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
		BoughtCard other = (BoughtCard) obj;
		if (exist != other.exist)
			return false;
		if (Double.doubleToLongBits(pAllMoney) != Double.doubleToLongBits(other.pAllMoney))
			return false;
		if (pBuyNum != other.pBuyNum)
			return false;
		if (pIntroduce == null) {
			if (other.pIntroduce != null)
				return false;
		} else if (!pIntroduce.equals(other.pIntroduce))
			return false;
		if (Double.doubleToLongBits(pMoney) != Double.doubleToLongBits(other.pMoney))
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
		return true;
	}
	@Override
	public String toString() {
		return "BoughtCard [rTime=" + rTime + ", pName=" + pName + ", pIntroduce=" + pIntroduce + ", pMoney=" + pMoney
				+ ", exist=" + exist + ", pBuyNum=" + pBuyNum + ", pAllMoney=" + pAllMoney + "]";
	}
	public BoughtCard(String rTime, String pName, String pIntroduce, double pMoney, int exist, int pBuyNum,
			double pAllMoney) {
		super();
		this.rTime = rTime;
		this.pName = pName;
		this.pIntroduce = pIntroduce;
		this.pMoney = pMoney;
		this.exist = exist;
		this.pBuyNum = pBuyNum;
		this.pAllMoney = pAllMoney;
	}
	public BoughtCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
