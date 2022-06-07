package MovieTicket.MovieTicket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import MovieTicket.MovieTicket.DAO.ScreenDAO;
import MovieTicket.MovieTicket.entity.Screen;
@Service
@Transactional
public class ScreenServiceImp implements ScreenService {
	// inject the Dao
		@Autowired
		private ScreenDAO sdao;
		@Override
		@Transactional
		public int addScreen(Screen s) {
			// TODO Auto-generated method stub
			
			return sdao.addScreen(s);
		}

		@Override
		public int updateScreen(Screen s) {
			// TODO Auto-generated method stub
			return sdao.updateScreen(s);
		}

		@Override
		public int deleteScreen(Screen s) {
			// TODO Auto-generated method stub
			return sdao.deleteScreen(s);
		}

		@Override
		public int deleteScreen(int id) {
			// TODO Auto-generated method stub
			return sdao.deleteScreen(id);
		}

		@Override
		public List<Screen> getAllScreens() {
			// TODO Auto-generated method stub
			return sdao.getAllScreens();
		}

		@Override
		public Screen getScreenById(int id) {
			// TODO Auto-generated method stub
			return sdao.getScreenById(id);
		}

}
