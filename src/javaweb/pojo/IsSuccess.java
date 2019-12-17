package javaweb.pojo;

public class IsSuccess {
	private int success;

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + success;
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
		IsSuccess other = (IsSuccess) obj;
		if (success != other.success)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IsSuccess [success=" + success + "]";
	}

	public IsSuccess(int success) {
		super();
		this.success = success;
	}

	public IsSuccess() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
