package com.eundms.backend.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users {
	private Long id;
	private String email;
	private String password;
	private String username;
	private String createdAt;
	private String updatedAt;

	@Builder
	public Users(String email, String password, String username) {
		this.email = email;
		this.password = password;
		this.username = username;
	}
}
