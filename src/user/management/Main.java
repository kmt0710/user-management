package user.management;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserService userService = new UserService();
		
		while(true) {
			System.out.println("===== 회원 관리 프로그램 =====");
			System.out.println("1. 회원 등록");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 아이디로 회원 조회");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 종료");
			System.out.println("메뉴를 선택해주세요: ");
			
			String input = sc.nextLine();
			
			switch(input) {
			case "1" :
				registerUser(sc, userService);
				break;
			case "2":
				showAllUsers(userService);
				break;
			case "3":
				findUser(sc, userService);
				break;
			case "4":
				deleteUser(sc, userService);
				break;
			case "5":
				System.out.println("프로그램을 종료합니다");
				sc.close();
				return;
				default:
				 	System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
			}   
		}
	}
	
	private static void registerUser(Scanner sc, UserService userService) {
		try {
			System.out.print("아이디: ");
			String loginId = sc.nextLine();
			
			System.out.println("비밀번호: ");
			String password = sc.nextLine();
			
			System.out.println("이름: ");
			String name = sc.nextLine();
			
			userService.register(loginId, password, name);
			System.out.println("회원 등록이 완료되었습니다.");
		} 
		
		catch(IllegalArgumentException e) {
			System.out.println("등록 실패 :" + e.getMessage());
		}
	}
	
	private static void showAllUsers(UserService userService) {
		List<User> users = userService.getAllUsers();
		
		if(users.isEmpty()) {
			System.out.println("등록된 회원이 없습니다.");
			return;
		}
		
		System.out.println("\n===== 전체 회원 목록 ====");
		for(User user : users) {
			System.out.println(user);
		}
	}
	
	private static void findUser(Scanner sc, UserService userService) {
		System.out.print("조회할 아이디: ");
		String loginId = sc.nextLine();
		
		User user = userService.getUser(loginId);
		
		if(user == null) {
			System.out.println("해당 아이디의 회원이 없습니다");
			return;
		}
		
		System.out.println("조회 결과: " + user);
	}
	
	private static void deleteUser(Scanner sc, UserService userService) {
		System.out.print("삭제할 아이디: ");
		String loginId = sc.nextLine();
		
		boolean deleted = userService.deleteUser(loginId);
		
		if(deleted) System.out.println("회원 삭제가 완료되었습니다.");
		
		else System.out.println("해당 아이디의 회원이 없습니다.");
	}
}
