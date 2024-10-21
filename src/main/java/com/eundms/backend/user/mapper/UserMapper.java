package com.eundms.backend.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.eundms.backend.user.model.Users;

@Mapper
public interface UserMapper {
	Users findById(Long id);

	void save(Users user);

	void update(Users user);

	void delete(Long id);
}
