package user.management.serivce;

import java.util.List;

import user.management.domain.User;
import user.management.repository.UserRepository;

public class UserService {
	private UserRepository userRepository = new UserRepository();
	
	public void register(String loginId, String password, String name, String email) {
		validateLoginId(loginId);
		validatePassword(password);
		validateName(name);
		validateEmail(email);
		checkDuplicateLoginId(loginId);
		
		User user = new User(loginId, password, name, email);
		userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUser(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	
	public boolean deleteUser(String loginId) {
		validateDeletePolicy(loginId);
		return userRepository.deleteByLoginId(loginId);
	}
	
	public void updateUser(String loginId, String name, String password) {
		validateLoginId(loginId);
		
		User user = userRepository.findByLoginId(loginId);
		
		if(user == null){
			throw new IllegalArgumentException("존재하지 않는 아이디 입니다.");
		}
		
		validateName(name);
		validatePassword(password);
		
		user.setName(name);
		user.setPassword(password);
		
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
		if(name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
		}
	}
	
	private void validateEmail(String email) {
		if(email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("이메일은 비어 있을 수 없습니다.");
		}
	}
	
	private void checkDuplicateLoginId(String loginId) {
		User foundUser  = userRepository.findByLoginIdIncludingDeleted(loginId);
		
		if(foundUser != null) {
			throw new IllegalArgumentException(loginId + " 는 이미 사용 중이거나 삭제된 아이디 입니다.");
		}
	}
	
	private void validateDeletePolicy(String loginIde) {
		if("admin".equals(loginIde)) {
			throw new IllegalArgumentException("admin 계정은 삭제할 수 없습니다.");
		}
	}
}
