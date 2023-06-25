package kr.ac.kopo.biz.account;

public class AccountVO {
	
	private String accNo;
	private String userId;
	private String productName;
	private String bankCode;
	private String accType;
	private int dormantAcc;
	private long balance;
	private String accCreateDate;
	private String accPassword;
	
	public String getAccNo() {
		return accNo;
	}
	
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getBankCode() {
		return bankCode;
	}
	
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	public String getAccType() {
		return accType;
	}
	
	public void setAccType(String accType) {
		this.accType = accType;
	}
	
	public int getDormantAcc() {
		return dormantAcc;
	}
	
	public void setDormantAcc(int dormantAcc) {
		this.dormantAcc = dormantAcc;
	}
	
	public long getBalance() {
		return balance;
	}
	
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public String getAccCreateDate() {
		return accCreateDate;
	}
	
	public void setAccCreateDate(String accCreateDate) {
		this.accCreateDate = accCreateDate;
	}
	
	public String getAccPassword() {
		return accPassword;
	}
	
	public void setAccPassword(String accPassword) {
		this.accPassword = accPassword;
	}
	
	public AccountVO(String accNo, String userId, String productName, String bankCode, String accType, int dormantAcc,
			long balance, String accCreateDate, String accPassword) {
		super();
		this.accNo = accNo;
		this.userId = userId;
		this.productName = productName;
		this.bankCode = bankCode;
		this.accType = accType;
		this.dormantAcc = dormantAcc;
		this.balance = balance;
		this.accCreateDate = accCreateDate;
		this.accPassword = accPassword;
	}
	
	public AccountVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "accountVO [accNo=" + accNo + ", userId=" + userId + ", productName=" + productName + ", bankCode="
				+ bankCode + ", accType=" + accType + ", dormantAcc=" + dormantAcc + ", balance=" + balance
				+ ", accCreateDate=" + accCreateDate + ", accPassword=" + accPassword + "]";
	}
	
	
}
