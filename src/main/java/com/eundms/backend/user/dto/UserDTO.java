package com.eundms.backend.user.dto;

import java.time.LocalDateTime;

import com.eundms.backend.user.model.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class UserDTO {
	private String email;
	private String username;
	private String createdAt;
	private String updatedAt;

	public static UserDTO from(Users user) {
		return UserDTO.builder()
			.email(user.getEmail())
			.username(user.getUsername())
			.createdAt(user.getCreatedAt())
			.updatedAt(user.getUpdatedAt())
			.build();
	}
}
