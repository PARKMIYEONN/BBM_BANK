package kr.ac.kopo.biz.transaction;

public class TransactionVO {
	
	private int transCode;
	private String accNo;
	private String transDate;
	private String transType;
	private long transAmount;
	private String transInfo;
	private String bankCode;
	
	public int getTransCode() {
		return transCode;
	}
	
	public void setTransCode(int transCode) {
		this.transCode = transCode;
	}
	
	public String getAccNo() {
		return accNo;
	}
	
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	public String getTransDate() {
		return transDate;
	}
	
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	
	public String getTransType() {
		return transType;
	}
	
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	public long getTransAmount() {
		return transAmount;
	}
	
	public void setTransAmount(long transAmount) {
		this.transAmount = transAmount;
	}
	
	public String getTransInfo() {
		return transInfo;
	}
	
	public void setTransInfo(String transInfo) {
		this.transInfo = transInfo;
	}
	
	public String getBankCode() {
		return bankCode;
	}
	
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	public TransactionVO(int transCode, String accNo, String transDate, String transType, long transAmount,
			String transInfo, String bankCode) {
		super();
		this.transCode = transCode;
		this.accNo = accNo;
		this.transDate = transDate;
		this.transType = transType;
		this.transAmount = transAmount;
		this.transInfo = transInfo;
		this.bankCode = bankCode;
	}
	
	public TransactionVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "TransactionVO [transCode=" + transCode + ", accNo=" + accNo + ", transDate=" + transDate
				+ ", transType=" + transType + ", transAmount=" + transAmount + ", transInfo=" + transInfo
				+ ", bankCode=" + bankCode + "]";
	}
	
	
	


}
