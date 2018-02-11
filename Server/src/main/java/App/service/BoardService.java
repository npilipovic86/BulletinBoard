package App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import App.model.Board;
import App.repository.BoardRepository;

@Component
public class BoardService {

	@Autowired
	private BoardRepository groupRepository;

	public List<Board> findAll() {
		return groupRepository.findAll();
	}

	public Page<Board> findAll(Pageable page) {
		return groupRepository.findAll(page);
	}

	public Board findOne(Long id) {
		return groupRepository.findOne(id);
	}

	public Board save(Board group) {
		return groupRepository.save(group);
	}

	public void remove(Long id) {
		groupRepository.delete(id);
	}

	public Board findByTitle(String title) {
		return groupRepository.findByTitle(title);
	}

}
