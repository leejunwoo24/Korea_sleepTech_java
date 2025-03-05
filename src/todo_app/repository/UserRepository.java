package todo_app.repository;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import todo_app.entity.User;

public class UserRepository {
		Set<User> users = new HashSet<User>();
		private static final UserRepository instance = new UserRepository();
		
		private UserRepository(){
			
		}
		
		public static UserRepository getInstance(){
			return instance;
		}
		
		public void userSave(User user) {
			users.add(user);
		}
		
		public Set<User> userFindAll(){
			return users;
		}
		
		public Optional<User> userFindById(Long id){
		   return users.stream()
				 .filter(user -> user.getId().equals(id))
				 .findFirst();
			
		    
			
		}
		
		public void userDeleteById(String userId) {
			for(User user : users) {
				if(user.getUserId().equals(userId)) {
					users.remove(user);
				}
			}
		}
}
