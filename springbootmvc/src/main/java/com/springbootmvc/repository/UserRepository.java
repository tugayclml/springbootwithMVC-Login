package com.springbootmvc.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springbootmvc.login.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User , Integer>{
	User findByEmail(String email);
}
