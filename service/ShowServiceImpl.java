package MovieTicket.MovieTicket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import MovieTicket.MovieTicket.DAO.ShowDAO;
import MovieTicket.MovieTicket.entity.Show;
@Service
@Transactional
public class ShowServiceImpl implements ShowService {
	@Autowired
	ShowDAO sdao;
	@Override
	public int add(Show show) {
		// TODO Auto-generated method stub
		return sdao.add(show);
	}

	@Override
	public int update(Show show) {
		// TODO Auto-generated method stub
		return sdao.update(show);
	}

	@Override
	public int delete(Show show) {
		// TODO Auto-generated method stub
		return sdao.delete(show);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return sdao.delete(id);
	}

	@Override
	public List<Show> getAll() {
		// TODO Auto-generated method stub
		return sdao.getAll();
	}

	@Override
	public Show getById(int id) {
		// TODO Auto-generated method stub
		return sdao.getById(id);
	}

	@Override
	public List<Show> getAll(String txt) {
		// TODO Auto-generated method stub
		return sdao.getAll(txt);
	}

}
