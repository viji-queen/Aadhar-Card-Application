package com.aadhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aadhar.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
