package App.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Message {

	@Id
	@GeneratedValue
	private Long id;

	private String text;


	@Column
	@CreationTimestamp
	private Date createDateTime;

	@ManyToOne(fetch = FetchType.LAZY)
	private Board board;

	public Message() {
		super();
	}

	public Message(Long id, String text, SecurityUser user, Date createDateTime, Board board) {
		super();
		this.id = id;
		this.text = text;
		this.createDateTime = createDateTime;
		this.board = board;
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


	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
