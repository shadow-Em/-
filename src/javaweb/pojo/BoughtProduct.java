package javaweb.pojo;

public class BoughtProduct {
	private String pName="";
	private String pStatus="";
	private double pMoney=0;
	private int pBuyNum=0;
	private double pAllMoney = 0;
	private String pNo ="";
	private String pIntroduce="";
	private String pDetail = "";
	private int pNumber = 0;
	private int exist=1;
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpStatus() {
		return pStatus;
	}
	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}
	public double getpMoney() {
		return pMoney;
	}
	public void setpMoney(double pMoney) {
		this.pMoney = pMoney;
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
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getpIntroduce() {
		return pIntroduce;
	}
	public void setpIntroduce(String pIntroduce) {
		this.pIntroduce = pIntroduce;
	}
	public String getpDetail() {
		return pDetail;
	}
	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}
	public int getpNumber() {
		return pNumber;
	}
	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}
	public int getExist() {
		return exist;
	}
	public void setExist(int exist) {
		this.exist = exist;
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
		result = prime * result + ((pDetail == null) ? 0 : pDetail.hashCode());
		result = prime * result + ((pIntroduce == null) ? 0 : pIntroduce.hashCode());
		temp = Double.doubleToLongBits(pMoney);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + ((pNo == null) ? 0 : pNo.hashCode());
		result = prime * result + pNumber;
		result = prime * result + ((pStatus == null) ? 0 : pStatus.hashCode());
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
		BoughtProduct other = (BoughtProduct) obj;
		if (exist != other.exist)
			return false;
		if (Double.doubleToLongBits(pAllMoney) != Double.doubleToLongBits(other.pAllMoney))
			return false;
		if (pBuyNum != other.pBuyNum)
			return false;
		if (pDetail == null) {
			if (other.pDetail != null)
				return false;
		} else if (!pDetail.equals(other.pDetail))
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
		if (pNo == null) {
			if (other.pNo != null)
				return false;
		} else if (!pNo.equals(other.pNo))
			return false;
		if (pNumber != other.pNumber)
			return false;
		if (pStatus == null) {
			if (other.pStatus != null)
				return false;
		} else if (!pStatus.equals(other.pStatus))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoughtProduct [pName=" + pName + ", pStatus=" + pStatus + ", pMoney=" + pMoney + ", pBuyNum=" + pBuyNum
				+ ", pAllMoney=" + pAllMoney + ", pNo=" + pNo + ", pIntroduce=" + pIntroduce + ", pDetail=" + pDetail
				+ ", pNumber=" + pNumber + ", exist=" + exist + "]";
	}
	public BoughtProduct(String pName, String pStatus, double pMoney, int pBuyNum, double pAllMoney, String pNo,
			String pIntroduce, String pDetail, int pNumber, int exist) {
		super();
		this.pName = pName;
		this.pStatus = pStatus;
		this.pMoney = pMoney;
		this.pBuyNum = pBuyNum;
		this.pAllMoney = pAllMoney;
		this.pNo = pNo;
		this.pIntroduce = pIntroduce;
		this.pDetail = pDetail;
		this.pNumber = pNumber;
		this.exist = exist;
	}
	public BoughtProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
