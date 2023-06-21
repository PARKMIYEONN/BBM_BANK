package kr.ac.kopo.biz.user;

public class UserVO {
	
	 private String userId;
	 private String userPassword;
	 private String userName;
	 private String userEmail;
	 private String userBirthday;
	 private int gender;
	 private String userTel;
	 private String userPost;
	 private String userAddress;
	 
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) { 
		this.userId = userId;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserBirthday() {
		return userBirthday;
	}
	
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	
	public int getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public String getUserTel() {
		return userTel;
	}
	
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	public String getUserPost() {
		return userPost;
	}
	
	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}
	
	public String getUserAddress() {
		return userAddress;
	}
	
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	public UserVO(String userId, String userPassword, String userName, String userEmail, String userBirthday,
			int gender, String userTel, String userPost, String userAddress) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userBirthday = userBirthday;
		this.gender = gender;
		this.userTel = userTel;
		this.userPost = userPost;
		this.userAddress = userAddress;
	}
	
	public UserVO() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName + ", userEmail="
				+ userEmail + ", userBirthday=" + userBirthday + ", gender=" + gender + ", userTel=" + userTel
				+ ", userPost=" + userPost + ", userAddress=" + userAddress + "]";
	}
	 
	 
	 

}
