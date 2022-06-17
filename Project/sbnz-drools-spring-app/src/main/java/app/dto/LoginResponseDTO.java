package app.dto;

import app.model.User;

public class LoginResponseDTO {
	
	private User user;
	private String role;
	
	public LoginResponseDTO() {
		super();
	}

	public LoginResponseDTO(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
