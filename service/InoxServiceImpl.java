package MovieTicket.MovieTicket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import MovieTicket.MovieTicket.DAO.InoxDAO;
import MovieTicket.MovieTicket.entity.Inox;

@Service
@Transactional
public class InoxServiceImpl implements InoxService {

	@Autowired
	private InoxDAO inoxdao;
	@Override
	@Transactional
	public int addInox(Inox inox) {
		
		
		return inoxdao.addInox(inox);
	}

	@Override
	public int updateInox(Inox inox) {
	
		return inoxdao.updateInox(inox);
	}

	@Override
	public int deleteInox(Inox inox) {
		// TODO Auto-generated method stub
		return inoxdao.deleteInox(inox);
	}

	@Override
	public int deleteInox(int id) {
		// TODO Auto-generated method stub
		return inoxdao.deleteInox(id);
	}

	@Override
	public List<Inox> getAllInox() {
		// TODO Auto-generated method stub
		return inoxdao.getAllInox();
	}

	@Override
	public Inox getInoxById(int id) {
		// TODO Auto-generated method stub
		return inoxdao.getInoxById(id);
	}

}
