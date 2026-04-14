package user.management;

import java.util.List;

public class UserService {
	private UserRepository userRepository = new UserRepository();
	
	public void register(String loginId, String password, String name) {
		validateLoginId(loginId);
		validatePassword(password);
		validateName(name);
		checkDuplicateLoginId(loginId);
		
		User user = new User(loginId, password, name);
		userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUser(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	
	public boolean deleteUser (String loginId) {
		return userRepository.deleteBtLoginId(loginId);
	}
	
	private void validateLoginId(String loginId) {
		if(loginId == null || loginId.trim().isEmpty()) {
			throw new IllegalArgumentException("아이디는 비어 있을 수 없습니다.");
		}
	}
	
	private void validatePassword(String password) {
		if(password == null || password.length() < 4) {
			throw new IllegalArgumentException("비밀번호는 4자 이상이어야 합니다.");
		}
	}
	
	private void validateName(String name) {
		if(name == null || name.trim().isBlank()) {
			throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
		}
	}
	
	private void checkDuplicateLoginId(String logindID) {
		User foundUser = userRepository.findByLoginId(logindID);
		
		if(foundUser != null) {
			throw new IllegalArgumentException("이미 사용 중인 아이디입니다");
		}
	}
}
