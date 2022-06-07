package MovieTicket.MovieTicket.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import MovieTicket.MovieTicket.entity.Role;
import MovieTicket.MovieTicket.entity.Role;

//add the Repositator
@Repository
public class RoleDAOImpl implements RoleDAO {
		//inject the Sessionfactory
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public int add(Role role) {
		//create the session object using the Session factory
		Session session=sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		//save or update
		//if the primarykey id is null -- save as new new record
		//if the primarykey id is not null -- update the record
		session.save(role);
		//close the session
		//session.close();
			return  role.getRoleid();
	}

	@Override
	public int update(Role role) {
		//create the session object using the Session factory
				Session session=sessionFactory.getCurrentSession();
				
				// save/upate the customer ... finally LOL
				//save or update
				//if the primarykey id is null -- save as new new record
				//if the primarykey id is not null -- update the record
				session.saveOrUpdate(role);
				//close the session
				//session.close();
					return  role.getRoleid();
	}

	@Override
	public int delete(Role role) {
		//create the object of the Session using the SessionFactory
				Session session=sessionFactory.getCurrentSession();
				//search the student eixts the id exists or not
				Role role1=	session.get(Role.class, role.getRole());
			//check the std is null or null if null means no record
			if(role1==null)
			{
				return -1;//no record found; 
			}
			//if found then delete the record
			session.delete(role1);
			//close the session
			//session.close();
				return 1;//record is updated successfully	
	}

	@Override
	public int delete(int id) {
		//create the object of the Session using the SessionFactory
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
		Role role1=	session.get(Role.class, id);
	//check the std is null or null if null means no record
	if(role1==null)
	{
		return -1;//no record found; 
	}
	//if found then delete the record
	session.delete(role1);
	//close the session
	//session.close();
		return 1;//record is updated successfully
	}

	@Override
	public List<Role> getAll() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	//createCriteria the object provided by the  HiberNate
		//we pass the class and we get the list of the object
		//select * from student
List<Role> roles=currentSession.createCriteria(Role.class).list();
return roles;
	}

	@Override
	public Role getById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
		Role role=	session.get(Role.class, id);
		return role;
	}

	@Override
	public List<Role> searchRole(String rolename) {
		Session session=sessionFactory.getCurrentSession();
		//createQuery("from <entity> where <columnname/filedname>=:parametername")
		Query query=session.createQuery("from Role where role=:prole");
		query.setParameter("prole", rolename);
		return query.list();
	}
	
}
