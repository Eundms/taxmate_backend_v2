package com.eundms.backend.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eundms.backend.user.dto.RegisterDTO;
import com.eundms.backend.user.dto.UserDTO;
import com.eundms.backend.user.model.Users;
import com.eundms.backend.user.service.UserService;

@RestController
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// 등록
	@PostMapping("/users")
	ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO){
		userService.register(Users.builder()
				.email(registerDTO.getEmail())
				.password(registerDTO.getPassword())
				.username(registerDTO.getUsername())
			.build());
		return ResponseEntity.ok().body("");
	}

	// 유저 정보 가져오기
	@GetMapping("/users/{userId}")
	ResponseEntity<?> getUser(@RequestParam Long userId) {
		Users user = userService.getById(userId);
		return ResponseEntity.ok().body(UserDTO.from(user));
	}

	// 삭제
	@DeleteMapping("/users/{userId}")
	ResponseEntity<?> deleteUser(@RequestParam Long userId) {
		userService.resign(userId);
		return ResponseEntity.ok().body("");
	}

}
