package App.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Board {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	
	
	@OneToMany
	private List<Message> messages;

	@Column
	@CreationTimestamp
	private Date createDateTime;

	public Board() {
		super();
	}

	public Board(Long id, String title, List<Message> messages, Date createDateTime) {
		super();
		this.id = id;
		this.title = title;
		this.messages = messages;
		this.createDateTime = createDateTime;
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

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

}
