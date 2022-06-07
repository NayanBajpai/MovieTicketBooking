package MovieTicket.MovieTicket.DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import MovieTicket.MovieTicket.entity.Screen;
@Repository
public class ScreenDAOImp implements ScreenDAO {
	@Autowired
	  private SessionFactory sessionFactory;
		@Override
		public int addScreen(Screen s) {
			// TODO Auto-generated method stub
			//create the session object using the Session factory
		Session session=	sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		//save or update
		//if the primarykey id is null -- save as new new record
		//if the primarykey id is not null -- update the record
		session.save(s);
			return  s.getId();
		}

		@Override
		public int updateScreen(Screen s) {
			// TODO Auto-generated method stub
			// create the object of the session using the session factory
			Session session=sessionFactory.getCurrentSession();
			// we will call save or update
			session.saveOrUpdate(s);
			//close the session
			//session.close();
			return s.getId();
		}

		@Override
		public int deleteScreen(Screen s) {
			// TODO Auto-generated method stub
			// create the object of the session using the session factory
			Session session=sessionFactory.getCurrentSession();
			// search the student with the id exists or not
			Screen sc = session.get(Screen.class, s.getId());
			//check the std is null or not if null means norecord found 
			if(sc==null) {
				return -1;
			}
			// if found then delete the record 
			session.delete(s);
			//close the session
			session.close();
			return 1; // record the updated successfully
			
			
		}

		@Override
		public int deleteScreen(int id) {
			// TODO Auto-generated method stub
			// create the object of the session using the session factory
					Session session=sessionFactory.getCurrentSession();
					// search the student with the id exists or not
					Screen sc = session.get(Screen.class, id);
					//check the std is null or not if null means norecord found 
					if(sc==null) {
						return -1;
					}
					// if found then delete the record 
					session.delete(sc);
					//close the session
					//session.close();
					return 1; // record the updated successfully
			
		}

		@Override
		public List<Screen> getAllScreens() {
			// TODO Auto-generated method stub
			// create the object of the session using the session factory
			Session currentsession=sessionFactory.getCurrentSession();
			//createQuery(HQL from <entity> order by firstname)
			//Query<Student>
			List<Screen> scs = currentsession.createCriteria(Screen.class).list();
			return scs;
		}

		@Override
		public Screen getScreenById(int id) {
//			get the current session object using the 
			Session session = sessionFactory.getCurrentSession();
			Screen s = session.get(Screen.class,id);
			
			return s;
		}

		

}
