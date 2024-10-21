package com.eundms.backend.user.service;

import org.springframework.stereotype.Service;

import com.eundms.backend.user.mapper.UserMapper;
import com.eundms.backend.user.model.Users;

@Service
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public Users getById(Long id){
		return userMapper.findById(id);
	}

	@Override
	public void register(Users user) {
		userMapper.save(user);
	}

	@Override
	public Users update(Users user) {
		userMapper.update(user);
		return userMapper.findById(user.getId());
	}

	@Override
	public void resign(Long id) {
		userMapper.delete(id);
	}
}
