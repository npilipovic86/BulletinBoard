package App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import App.model.Message;

@Component
public interface MessageRepository extends JpaRepository<Message, Long> {

}
