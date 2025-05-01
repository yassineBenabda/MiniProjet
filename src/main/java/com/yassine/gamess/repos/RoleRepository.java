package com.yassine.gamess.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yassine.gamess.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
