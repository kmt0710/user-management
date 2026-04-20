package user.management.dto;

public class UserResponse {
	private String loginId;
	private String name;
	
	public UserResponse(String loginId, String name) {
		this.loginId = loginId;
		this.name = name;
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public String gerName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "아이디: " + loginId + ", 이름: " + name;
	}
}
