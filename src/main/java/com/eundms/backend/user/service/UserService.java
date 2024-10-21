package com.eundms.backend.user.service;

import com.eundms.backend.user.model.Users;

public interface UserService {
	Users getById(Long id);
	void register(Users user);
	Users update(Users user);
	void resign(Long id);
}
