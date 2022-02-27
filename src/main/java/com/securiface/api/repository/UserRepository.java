package com.securiface.api.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import com.securiface.api.model.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

	public Optional<User> findByEmail(String email);
	

}