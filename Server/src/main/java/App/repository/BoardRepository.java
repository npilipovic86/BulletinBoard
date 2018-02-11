package App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import App.model.Board;

@Component
public interface BoardRepository extends JpaRepository<Board, Long> {

	Board findByTitle(String title);

}
