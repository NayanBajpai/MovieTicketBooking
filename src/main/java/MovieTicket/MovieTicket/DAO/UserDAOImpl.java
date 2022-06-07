package MovieTicket.MovieTicket.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import MovieTicket.MovieTicket.entity.User;
@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public String add(User user) {
		//create the session object using the Session factory
		Session session=sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		//save or update
		//if the primarykey id is null -- save as new new record
		//if the primarykey id is not null -- update the record
		session.save(user);
		//close the session
		//session.close();
			return  user.getEmail();
	}

	@Override
	public String update(User user) {
		//create the session object using the Session factory
				Session session=sessionFactory.getCurrentSession();
				
				// save/upate the customer ... finally LOL
				//save or update
				//if the primarykey id is null -- save as new new record
				//if the primarykey id is not null -- update the record
				session.saveOrUpdate(user);
				//close the session
				//session.close();
					return  user.getEmail();
	}

	@Override
	public int delete(User user) {
		//create the object of the Session using the SessionFactory
				Session session=sessionFactory.getCurrentSession();
				//search the student eixts the id exists or not
				User user1=	session.get(User.class, user.getEmail());
			//check the std is null or null if null means no record
			if(user1==null)
			{
				return -1;//no record found; 
			}
			//if found then delete the record
			session.delete(user1);
			//close the session
			//session.close();
				return 1;//record is updated successfully	
	}

	@Override
	public int delete(String  emailid) {
		//create the object of the Session using the SessionFactory
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
		//User user1=	session.get(User.class, emailid);
	Query query=session.createQuery("delete from User where email=:emailid");
	query.setParameter("emailid", emailid);
	//check the std is null or null if null means no record
	
	//if found then delete the record
	return query.executeUpdate();
	//close the session
	//session.close();
		//return 1;//record is updated successfully
	}

	@Override
	public List<User> getAll() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	//createCriteria the object provided by the  HiberNate
		//we pass the class and we get the list of the object
		//select * from student
List<User> users=currentSession.createCriteria(User.class).list();
return users;
	}

	@Override
	public User getById(String emailid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
		
		//search the student eixts the id exists or not
		User user1=	session.get(User.class, emailid);
	//List<User> users=session.createQuery("from User").list();
	//for (User user : users) {
		//if(user.getEmail().equals(emailid))
		//{
			
			return user1;
		//}
	//}		
	
	
	//return null;
	}
/*
	@Override
	public User authenticateUser(String emailid, String password) {
		Session session=sessionFactory.getCurrentSession();
		Query thequery=session.createQuery("from user where email=:email and pwd=:pwd");
		//set the parameter
		thequery.setParameter("email", emailid);
		thequery.setParameter("pwd", password);
	List<User> users=thequery.list();
	if(users.size()>0)
	{
		return users.get(0);
	}
	return null;
	}
*/
	@Override
	public User authenticateUser(String emailid, String password) {
		Session session=sessionFactory.getCurrentSession();
		User user=session.get(User.class, emailid);
		if(user!=null)
		{
			if(user.getPwd().equals(password))
			{
				return user;
			}
		}
		//set the parameter
		
	return null;
	}
	
}
