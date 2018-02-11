package App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import App.model.Message;
import App.repository.MessageRepository;

@Component
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	public Page<Message> findAll(Pageable page) {
		return messageRepository.findAll(page);
	}

	public Message findOne(Long id) {
		return messageRepository.findOne(id);
	}

	public Message save(Message message) {
		return messageRepository.save(message);
	}

	public void remove(Long id) {
		messageRepository.delete(id);
	}
}
