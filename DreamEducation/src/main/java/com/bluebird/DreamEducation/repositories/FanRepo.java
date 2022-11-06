package com.bluebird.DreamEducation.repositories;

import com.bluebird.DreamEducation.entities.Fan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FanRepo extends JpaRepository<Fan, Long> {





}
