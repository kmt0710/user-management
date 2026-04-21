package user.management.dto;

public class CreateUserRequest {
	private String loginId;
	private String password;
	private String name;
	private String email;
	
	public CreateUserRequest(String loginId, String password, String name, String email) {
		this.loginId = loginId;
		this.password = password;
		this.name = name;	
		this.email = email;
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
}
