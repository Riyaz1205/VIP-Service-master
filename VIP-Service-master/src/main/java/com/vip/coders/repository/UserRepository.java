package com.vip.coders.repository;

import com.vip.coders.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findByid(long id);

    List<User> findByRoleAndActive(String role, boolean isActive);
}
