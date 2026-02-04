package com.tqt.sba301_se1943_springrestapi02.repository;

import com.tqt.sba301_se1943_springrestapi02.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
