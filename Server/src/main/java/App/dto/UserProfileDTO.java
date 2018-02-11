package App.dto;

import App.model.SecurityUser;

public class UserProfileDTO {

	private String firstName;

	private String lastName;

	public UserProfileDTO(SecurityUser user) {
		super();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
	}

	public UserProfileDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
