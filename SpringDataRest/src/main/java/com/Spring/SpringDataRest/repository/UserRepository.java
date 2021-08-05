package com.Spring.SpringDataRest.repository;

import com.Spring.SpringDataRest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
}
