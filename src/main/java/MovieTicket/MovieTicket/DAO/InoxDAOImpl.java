package MovieTicket.MovieTicket.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import MovieTicket.MovieTicket.entity.Inox;
@Repository
public class InoxDAOImpl implements InoxDAO {
	  @Autowired 
	  private SessionFactory sessionFactory;
		@Override
		public int addInox(Inox inox) {
			
		Session session=sessionFactory.getCurrentSession();
		session.save(inox);
		return  inox.getId();
	}

		@Override
		public int updateInox(Inox inox) {
			
			Session session=sessionFactory.getCurrentSession();
			
			session.saveOrUpdate(inox);
			
			return inox.getId();
		}

		@Override
		public int deleteInox(Inox inox) {
			
			Session session=sessionFactory.getCurrentSession();
			
			Inox std=	session.get(Inox.class, inox.getId());
		
		if(std==null)
		{
			return -1; 
		}
		
		session.delete(inox);
		
			return 1;
		}

		@Override
		public int deleteInox(int id) {
			
			Session session=sessionFactory.getCurrentSession();
					
			Inox std=	session.get(Inox.class, id);
				
				if(std==null)
				{
					return -1;
				}
				
				session.delete(std);
				
					return 1;
		}

		@Override
		public List<Inox> getAllInox() {
			
						Session currentSession = sessionFactory.getCurrentSession();
					
			List<Inox> inox=currentSession.createCriteria(Inox.class).list();
			return inox;
		}

		@Override
		public Inox getInoxById(int id) {
		
			Session session=sessionFactory.getCurrentSession();
			
			Inox inox=	session.get(Inox.class,id);
			return  inox;
		}

		
}
