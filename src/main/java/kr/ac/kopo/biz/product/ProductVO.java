package kr.ac.kopo.biz.product;

public class ProductVO {
	private String productName;
	private String productType;
	private String releaseDate;
	private String endDate;
	private double productRate;
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public double getProductRate() {
		return productRate;
	}
	
	public void setProductRate(double productRate) {
		this.productRate = productRate;
	}
	
	public ProductVO(String productName, String productType, String releaseDate, String endDate, double productRate) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.releaseDate = releaseDate;
		this.endDate = endDate;
		this.productRate = productRate;
	}
	
	public ProductVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "ProductVO [productName=" + productName + ", productType=" + productType + ", releaseDate=" + releaseDate
				+ ", endDate=" + endDate + ", productRate=" + productRate + "]";
	}
	
	
}
