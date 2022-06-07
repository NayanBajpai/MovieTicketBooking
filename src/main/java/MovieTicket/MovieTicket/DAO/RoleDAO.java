package MovieTicket.MovieTicket.DAO;

import java.util.List;

import MovieTicket.MovieTicket.entity.Role;


public interface RoleDAO {
	//declare the method that we want for the student
		public int add(Role role);
		public int update(Role role);
		public int delete(Role role);
		public int delete(int id);
		//create some method to get the student
		public List<Role> getAll();
		public Role getById(int id);
		public List<Role> searchRole(String role);
		
		
}
