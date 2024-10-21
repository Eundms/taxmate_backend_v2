package com.eundms.backend.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
	private String email;
	private String username;
	private String password;
}
