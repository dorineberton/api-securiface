package com.securiface.api.repository;

import java.util.Optional;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securiface.api.model.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

  // public User loadUserByUsername(String username);
	public Optional<User> findByEmail(String email);

}