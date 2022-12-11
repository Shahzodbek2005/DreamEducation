package com.bluebird.DreamEducation.repositories;

import com.bluebird.DreamEducation.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

    @Query(nativeQuery = true, value = "select * from role where name = :name")
    Role findByName(@Param("name") String name);
}