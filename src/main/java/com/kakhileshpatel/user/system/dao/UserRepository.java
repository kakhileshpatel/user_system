package com.kakhileshpatel.user.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kakhileshpatel.user.system.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
