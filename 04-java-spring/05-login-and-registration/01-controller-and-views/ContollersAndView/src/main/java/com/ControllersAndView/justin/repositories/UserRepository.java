package com.ControllersAndView.justin.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ControllersAndView.justin.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}