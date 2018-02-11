package App.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import App.model.Board;
import App.model.Message;

public class BoardDTO {

	private Long id;
	private String title;

	private List<Message> messages;

	private Date createdDateTime;

	public BoardDTO() {
		super();
	}

	public BoardDTO(Long id, String title, List<Message> messages, Date createdDateTime) {
		super();
		this.id = id;
		this.title = title;
		this.messages = messages;
		this.createdDateTime = createdDateTime;
	}

	public BoardDTO(Board board) {
		super();
		this.id = board.getId();
		this.title = board.getTitle();
		this.createdDateTime = board.getCreateDateTime();
		this.messages = board.getMessages();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

}
