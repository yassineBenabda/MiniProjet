package com.yassine.gamess.service;

import com.yassine.gamess.entities.Role;
import com.yassine.gamess.entities.User;

public interface UserService {
	
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);

}