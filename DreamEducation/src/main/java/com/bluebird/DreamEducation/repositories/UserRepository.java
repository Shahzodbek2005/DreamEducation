package com.bluebird.DreamEducation.repositories;

import com.bluebird.DreamEducation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query(nativeQuery = true, value = "select * from user where username =:username")
    public Long isUserExist(@Param("username") String username);

    @Query(nativeQuery = true, value = "select * from user where username =:username")
    public User findByUserName(@Param("username") String username);



}