package App.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import App.dto.MessageDTO;
import App.model.Message;

import App.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping(value = "api/boards/{id}/messages")
	public ResponseEntity<List<MessageDTO>> getMessagesPage(Pageable page, @PathVariable Long id) {
		//List<MessageDTO> retVal = messageService.findAll().stream().map(MessageDTO::new).collect(Collectors.toList());
		List<Message> messages = messageService.findAll();
		List<MessageDTO> retVal = new ArrayList<>();
		for (Message m : messages) {
			if (m.getBoard().getId() == id) {
				retVal.add(new MessageDTO(m));
			}
		}
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "api/messages")
	public ResponseEntity<List<MessageDTO>> getMessages() {
		 List<MessageDTO> messages = messageService.findAll().stream().map(MessageDTO::new).collect(Collectors.toList());
		if (messages != null) {
			return new ResponseEntity<>(messages, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR')")
	@DeleteMapping(value = "api/messages/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Message message = messageService.findOne(id);
		if (message != null) {
			messageService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
