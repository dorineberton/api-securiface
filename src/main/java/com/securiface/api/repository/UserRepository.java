package com.securiface.api.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.securiface.api.model.Role;
import com.securiface.api.model.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

	public Optional<User> findByEmail(String email);
	

}