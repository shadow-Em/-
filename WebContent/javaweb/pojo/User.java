package javaweb.pojo;

public class User {
	private String uNo="";
	private String uName="";
	private String uPassword="";
	private String uAddress="";
	private String uEmail="";
	private double uBalance=0;
	public String getuNo() {
		return uNo;
	}
	public void setuNo(String uNo) {
		this.uNo = uNo;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public double getuBalance() {
		return uBalance;
	}
	public void setuBalance(double d) {
		this.uBalance = d;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uAddress == null) ? 0 : uAddress.hashCode());
		long temp;
		temp = Double.doubleToLongBits(uBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((uEmail == null) ? 0 : uEmail.hashCode());
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
		result = prime * result + ((uNo == null) ? 0 : uNo.hashCode());
		result = prime * result + ((uPassword == null) ? 0 : uPassword.hashCode());
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
		User other = (User) obj;
		if (uAddress == null) {
			if (other.uAddress != null)
				return false;
		} else if (!uAddress.equals(other.uAddress))
			return false;
		if (Double.doubleToLongBits(uBalance) != Double.doubleToLongBits(other.uBalance))
			return false;
		if (uEmail == null) {
			if (other.uEmail != null)
				return false;
		} else if (!uEmail.equals(other.uEmail))
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		if (uNo == null) {
			if (other.uNo != null)
				return false;
		} else if (!uNo.equals(other.uNo))
			return false;
		if (uPassword == null) {
			if (other.uPassword != null)
				return false;
		} else if (!uPassword.equals(other.uPassword))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [uNo=" + uNo + ", uName=" + uName + ", uPassword=" + uPassword + ", uAddress=" + uAddress
				+ ", uEmail=" + uEmail + ", uBalance=" + uBalance + "]";
	}
	public User(String uNo, String uName, String uPassword, String uAddress, String uEmail, double uBalance) {
		super();
		this.uNo = uNo;
		this.uName = uName;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uEmail = uEmail;
		this.uBalance = uBalance;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
