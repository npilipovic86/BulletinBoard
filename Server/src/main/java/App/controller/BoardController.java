package App.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import App.dto.BoardDTO;
import App.dto.MessageDTO;
import App.model.Board;
import App.model.Message;
import App.service.BoardService;
import App.service.MessageService;

@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private MessageService messageService;

	@GetMapping(value = "api/boards")
	public ResponseEntity<List<BoardDTO>> getBoards() {
		List<BoardDTO> boards = boardService.findAll().stream().map(BoardDTO::new).collect(Collectors.toList());
		return new ResponseEntity<>(boards, HttpStatus.OK);
	}

	@GetMapping(value = "api/boards/{id}")
	public ResponseEntity<BoardDTO> getBoard(@PathVariable Long id) {
		Board group = boardService.findOne(id);
		if (group != null) {
			BoardDTO groupDTO = new BoardDTO(group);
			return new ResponseEntity<>(groupDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR')")
	@PostMapping(value = "api/boards", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO groupDTO) {
		Board group = new Board();
		group.setTitle(groupDTO.getTitle());
		final Board savedGroup = boardService.save(group);
		return new ResponseEntity<>(new BoardDTO(savedGroup), HttpStatus.CREATED);
	}

	@PostMapping(value = "api/boards/{id}/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageDTO> createMessage(@PathVariable Long id, @RequestBody MessageDTO messageDTO) {
		final Board board = boardService.findOne(id);
		if (board == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		final Message message = new Message();
		message.setText(messageDTO.getText());
		message.setCreateDateTime(messageDTO.getCreatedDateTime());
//		message.setUser(messageDTO.getUser());
		message.setBoard(board);

		final Message savedMessage = messageService.save(message);

		return new ResponseEntity<>(new MessageDTO(savedMessage), HttpStatus.CREATED);
	}

	@PreAuthorize("hasAnyAuthority('ADMINISTRATOR')")
	@DeleteMapping(value = "api/boards/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Board group = boardService.findOne(id);
		if (group != null) {
			boardService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
