package com.arun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arun.entity.UserRegistration;

public interface UserRepository extends JpaRepository<UserRegistration, Integer>
{

	UserRegistration findAllByUserId(int id);

}
