package com.company.model.dao.repository;

import com.company.model.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findNameAndSurnameByEmail(String email);

}
