package com.ferraz.despensalivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferraz.despensalivre.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
