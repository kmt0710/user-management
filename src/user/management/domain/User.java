package user.management.domain;

public class User{
	private String loginId;
	private String password;
	private String name;
	private String email;
	private boolean deleted;
	
	public User(String loginId, String password, String name, String email) {
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public String getPassword() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	@Override
	public String toString() {
		return "아이디: " + loginId + ", 이름: " + name;
	}
}
