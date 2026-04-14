package user.management.repository;

import java.util.ArrayList;
import java.util.List;

import user.management.domain.User;

public class UserRepository {
	private List<User> users = new ArrayList<>();
	
	public void save(User user) {
		users.add(user);
	}
	
	public User findByLoginId(String loginId) {
		for(User user : users) {
			if(user.getLoginId().equals(loginId) && !user.isDeleted())
				return user;
		}
		
		return null;
	}
	
	public User findByLoginIdIncludingDeleted(String loginId) {
		for(User user : users) {
			if(user.getLoginId().equals(loginId)) {
				return user;
			}
		}
		
		return null;
	}
	
	public List<User> findAll(){
		List<User> result = new ArrayList<>();
		
		for(User user : users) {
			if(!user.isDeleted()) {
				result.add(user);
			}
		}
		return result;
	}
	
	public boolean deleteByLoginId(String loginId) {
		User user = findByLoginId(loginId);
		
		if(user == null) {
			return false;
		}
		
		user.setDeleted(true);
		return true;
	}
}
