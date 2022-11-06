package com.bluebird.DreamEducation.repositories;

import com.bluebird.DreamEducation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {



    @Query(value = "select * from users where username = :username and password = :password", nativeQuery = true)
    public Users findUser(String username, String password);
}
