package com.company.dao.repository;

import com.company.dao.entities.User;
import com.company.dto.response.UserRespons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findNameAndSurnameByEmail(String email);

}
