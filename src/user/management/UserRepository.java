package user.management;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	private List<User> users = new ArrayList<>();
	
	public void save(User user) {
		users.add(user);
	}
	
	public User findByLoginId(String loginId) {
		for(User user : users) {
			if(user.getLoginId().equals(loginId)) return user;
		}
		
		return null;
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public boolean deleteBtLoginId(String loginId) {
		User user = findByLoginId(loginId);
		
		if(user == null) return false;
		
		users.remove(user);
		
		return true;
	}
}
