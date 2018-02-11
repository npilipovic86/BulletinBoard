package App.dto;

import java.util.Date;

import App.model.Message;
import App.model.SecurityUser;

public class MessageDTO {

	private Long id;
	private String text;
//	private SecurityUser user;
	private Date createdDateTime;
	private BoardDTO board;

	public MessageDTO() {
		super();
	}

	public MessageDTO(Long id, String text, SecurityUser user, Date createdDateTime, BoardDTO board) {
		super();
		this.id = id;
		this.text = text;
//		this.user = user;
		this.createdDateTime = createdDateTime;
		this.board = board;
	}

	public MessageDTO(Message message) {
		super();
		this.id = message.getId();
		this.text = message.getText();
//		this.user = message.getUser();
		this.createdDateTime = message.getCreateDateTime();
		this.board = new BoardDTO(message.getBoard());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

//	public SecurityUser getUser() {
//		return user;
//	}
//
//	public void setUser(SecurityUser user) {
//		this.user = user;
//	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public BoardDTO getBoard() {
		return board;
	}

	public void setBoard(BoardDTO board) {
		this.board = board;
	}
	
	

}
