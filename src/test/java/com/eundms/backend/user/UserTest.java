package com.eundms.backend.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.eundms.backend.user.mapper.UserMapper;
import com.eundms.backend.user.model.Users;
import com.eundms.backend.user.service.UserServiceImpl;

class UserTest {

	@InjectMocks
	private UserServiceImpl userService; // 테스트할 대상 클래스

	@Mock
	private UserMapper userMapper;   // Mock 객체로 대체될 의존성

	private Users user;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this); // Mock 객체 초기화
		user = new Users("test@example.com", "password", "testUser");
		user.setId(1L);
	}

	@Test
	public void testGetUserById() {
		when(userMapper.findById(1L)).thenReturn(user);

		// 서비스 메서드 호출
		Users retrievedUser = userService.getById(1L);

		// 결과 검증
		assertThat(retrievedUser).isNotNull();
		assertThat(retrievedUser.getUsername()).isEqualTo("testUser");

		// userMapper의 getUserById가 1번 호출됐는지 검증
		verify(userMapper, times(1)).findById(1L);
	}

	@Test
	public void testCreateUser() {
		// createUser 호출
		userService.register(user);

		verify(userMapper, times(1)).save(user);
	}

	@Test
	public void testUpdateUser() {
		user.setUsername("updatedUser");
		userService.update(user);

		verify(userMapper, times(1)).update(user);
	}

	@Test
	public void testDeleteUser() {
		userService.resign(1L);

		verify(userMapper, times(1)).delete(1L);
	}
}
