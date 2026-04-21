package user.management.serivce;

import java.util.ArrayList;
import java.util.List;

import user.management.domain.User;
import user.management.repository.UserRepository;
import user.management.dto.*;

public class UserService {
	private UserRepository userRepository = new UserRepository();
	
	public void register(CreateUserRequest request) {
		validateLoginId(request.getLoginId());
		validatePassword(request.getPassword());
		validateName(request.getName());
		validateEmail(request.getEmail());
		checkDuplicateLoginId(request.getLoginId());
		
		User user = new User(request.getLoginId(), 
				request.getPassword(), request.getName(), 
				request.getEmail());
		
		userRepository.save(user);
	}
	
	//dto 적용전
//	public List<User> getAllUsers(){
//		return userRepository.findAll();
//	}
//	
//	public userRepository getUser(String loginId) {
//		return userRepository.findByLoginId(loginId);
//	} 

	public List<UserResponse> getALlUsers(){
		List<User> users = userRepository.findAll();
		List<UserResponse> result = new ArrayList<>();
		
		for (User user : users) {
			result.add(toUserResponse(user));
		}
		
		return result;
	}
	
	public UserResponse getUser(String loginId) {
		validateLoginId(loginId);
		
		User user = userRepository.findByLoginId(loginId);
		
		if(user == null) {
			return null;
		}
		
		return toUserResponse(user);
	}
	
	public boolean deleteUser(String loginId) {
		validateDeletePolicy(loginId);
		return userRepository.deleteByLoginId(loginId);
	}
	
	public void updateUser(String loginId, UpdateUserRequest request) {
		validateLoginId(loginId);
		
		User user = userRepository.findByLoginId(loginId);
		
		if(user == null){
			throw new IllegalArgumentException("존재하지 않는 아이디 입니다.");
		}
		
		validateName(request.getName());
		validatePassword(request.getPassword());
		
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		
	}
	
	private UserResponse toUserResponse(User user) {
		return new UserResponse(user.getLoginId(), user.getName());
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
